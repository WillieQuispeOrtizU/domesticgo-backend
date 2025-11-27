package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.EmpleoDTO;
import pe.edu.upc.domesticgo.entities.Empleo;
import pe.edu.upc.domesticgo.servicesinterfaces.IEmpleoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleos")
public class EmpleoController {
    @Autowired
    private IEmpleoService emplService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<EmpleoDTO> listar() {
        return emplService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, EmpleoDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody EmpleoDTO emplDto){
        ModelMapper m=new ModelMapper();
        Empleo empl=m.map(emplDto, Empleo.class);
        emplService.insert(empl);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody EmpleoDTO emplDto){
        ModelMapper m=new ModelMapper();
        Empleo empl=m.map(emplDto, Empleo.class);
        emplService.update(empl);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        emplService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public EmpleoDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        EmpleoDTO dto=m.map(emplService.searchId(id), EmpleoDTO.class);
        return dto;
    }

    // CLIENTE y ADMIN pueden buscar por nombre
    @GetMapping("/buscar-empleo")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<EmpleoDTO> buscar(@RequestParam String n){
        return emplService.searchName(n).stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h, EmpleoDTO.class);
        }).collect(Collectors.toList());
    }
}
