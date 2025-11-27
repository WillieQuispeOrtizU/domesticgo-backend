package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.UsuarioDTO;
import pe.edu.upc.domesticgo.entities.Usuario;
import pe.edu.upc.domesticgo.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuaService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<UsuarioDTO> listar() {
        return usuaService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody UsuarioDTO usuaDto){
        ModelMapper m=new ModelMapper();
        Usuario usua=m.map(usuaDto, Usuario.class);
        usuaService.insert(usua);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UsuarioDTO usuaDto){
        ModelMapper m=new ModelMapper();
        Usuario usua=m.map(usuaDto, Usuario.class);
        usuaService.update(usua);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        usuaService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public UsuarioDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        UsuarioDTO dto=m.map(usuaService.searchId(id), UsuarioDTO.class);
        return dto;
    }
}
