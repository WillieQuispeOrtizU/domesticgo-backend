package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.PagoDTO;
import pe.edu.upc.domesticgo.dtos.TotalPagosDTO;
import pe.edu.upc.domesticgo.entities.Pago;
import pe.edu.upc.domesticgo.servicesinterfaces.IPagoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private IPagoService pagService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<PagoDTO> listar() {
        return pagService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody PagoDTO pagDto){
        ModelMapper m=new ModelMapper();
        Pago pag=m.map(pagDto, Pago.class);
        pagService.insert(pag);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody PagoDTO pagDto){
        ModelMapper m=new ModelMapper();
        Pago pag=m.map(pagDto, Pago.class);
        pagService.update(pag);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        pagService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public PagoDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        PagoDTO dto=m.map(pagService.searchId(id), PagoDTO.class);
        return dto;
    }

    // REPORTES - Solo ADMIN
    @GetMapping("/Total-pagos-por-fecha")
    @PreAuthorize("hasAuthority('ADMIN')")
    public TotalPagosDTO obtenerTotalPagos(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return pagService.obtenerTotalPagos(fechaInicio, fechaFin);
    }
}
