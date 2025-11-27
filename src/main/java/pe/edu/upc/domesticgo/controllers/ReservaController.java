package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ReservaDTO;
import pe.edu.upc.domesticgo.entities.Reserva;
import pe.edu.upc.domesticgo.servicesinterfaces.IReservaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService reseService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<ReservaDTO> listar() {
        return reseService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ReservaDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ReservaDTO reseDto){
        ModelMapper m=new ModelMapper();
        Reserva rese=m.map(reseDto, Reserva.class);
        reseService.insert(rese);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ReservaDTO reseDto){
        ModelMapper m=new ModelMapper();
        Reserva rese=m.map(reseDto, Reserva.class);
        reseService.update(rese);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        reseService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ReservaDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ReservaDTO dto=m.map(reseService.searchId(id), ReservaDTO.class);
        return dto;
    }
}
