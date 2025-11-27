package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.UbicacionDTO;
import pe.edu.upc.domesticgo.entities.Ubicacion;
import pe.edu.upc.domesticgo.servicesinterfaces.IUbicacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private IUbicacionService ubicService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<UbicacionDTO> listar() {
        return ubicService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, UbicacionDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody UbicacionDTO ubicDto){
        ModelMapper m=new ModelMapper();
        Ubicacion ubic=m.map(ubicDto, Ubicacion.class);
        ubicService.insert(ubic);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UbicacionDTO ubicDto){
        ModelMapper m=new ModelMapper();
        Ubicacion ubic=m.map(ubicDto, Ubicacion.class);
        ubicService.update(ubic);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        ubicService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public UbicacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        UbicacionDTO dto=m.map(ubicService.searchId(id), UbicacionDTO.class);
        return dto;
    }
}
