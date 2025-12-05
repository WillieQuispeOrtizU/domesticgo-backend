package pe.edu.upc.domesticgo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.domesticgo.dtos.UserRegisterDTO;
import pe.edu.upc.domesticgo.entities.Role;
import pe.edu.upc.domesticgo.entities.Users;
import pe.edu.upc.domesticgo.repositories.IUserRepository; // Users se mantiene con Repo directo (común en seguridad)
import pe.edu.upc.domesticgo.servicesinterfaces.IRoleService; // <--- CAMBIO: Usamos el Service
import pe.edu.upc.domesticgo.securities.JwtRequest;
import pe.edu.upc.domesticgo.securities.JwtResponse;
import pe.edu.upc.domesticgo.securities.JwtTokenUtil;
import pe.edu.upc.domesticgo.servicesimplements.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IUserRepository userRepository;

    // INYECCIÓN DEL NUEVO SERVICIO DE ROLES
    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {
        authenticate(req.getUsername(), req.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO userDto) {
        Users newUser = new Users();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword())); // Encriptamos
        newUser.setEnabled(true);

        Users savedUser = userRepository.save(newUser);

        Role newRole = new Role();
        newRole.setUser(savedUser);

        if ("TRABAJADOR".equalsIgnoreCase(userDto.getTipoRol())) {
            newRole.setRol("ADMIN");
        } else {
            newRole.setRol("CLIENTE");
        }

        roleService.insert(newRole);

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}