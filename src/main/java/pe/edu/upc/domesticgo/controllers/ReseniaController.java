package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.PromedioReseniaDTO;
import pe.edu.upc.domesticgo.dtos.ReseniaDTO;
import pe.edu.upc.domesticgo.dtos.ReseniasPorTrabajadorDTO;
import pe.edu.upc.domesticgo.entities.Resenia;
import pe.edu.upc.domesticgo.servicesinterfaces.IReseniaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {

    @Autowired
    private IReseniaService reseService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<ReseniaDTO> listar() {
        return reseService.list().stream().map(n -> {
            ModelMapper m = new ModelMapper();
            return m.map(n, ReseniaDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ReseniaDTO reseDto) {
        ModelMapper m = new ModelMapper();
        Resenia rese = m.map(reseDto, Resenia.class);
        reseService.insert(rese);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ReseniaDTO reseDto) {
        ModelMapper m = new ModelMapper();
        Resenia rese = m.map(reseDto, Resenia.class);
        reseService.update(rese);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        reseService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ReseniaDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ReseniaDTO dto = m.map(reseService.searchId(id), ReseniaDTO.class);
        return dto;
    }

    // REPORTES - Solo ADMIN
    @GetMapping("/resenias-por-trabajador")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ReseniasPorTrabajadorDTO> obtenerReseniasPorTrabajador() {
        return reseService.obtenerReseniasPorTrabajador();
    }

    @GetMapping("/promedio-calificaciones")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PromedioReseniaDTO> obtenerPromedioCalificacionesPorUsuario() {
        return reseService.obtenerPromedioCalificacionesPorUsuario();
    }
}
