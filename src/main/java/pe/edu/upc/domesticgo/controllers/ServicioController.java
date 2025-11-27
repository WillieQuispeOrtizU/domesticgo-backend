package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.*;
import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.servicesinterfaces.IServicioService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private IServicioService servService;
    @Autowired
    private IServicioService iServicioService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    //@PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<ServicioDTO> listar() {
        return servService.list().stream().map(n -> {
            ModelMapper m = new ModelMapper();
            return m.map(n, ServicioDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ServicioDTO servDto) {
        ModelMapper m = new ModelMapper();
        Servicio serv = m.map(servDto, Servicio.class);
        servService.insert(serv);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ServicioDTO servDto) {
        ModelMapper m = new ModelMapper();
        Servicio serv = m.map(servDto, Servicio.class);
        servService.update(serv);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        servService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ServicioDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ServicioDTO dto = m.map(servService.searchId(id), ServicioDTO.class);
        return dto;
    }

    // REPORTES - Solo ADMIN
    @GetMapping("/servicios-pendientes")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ServiciosPendientesDTO obtenerServiciosPendientes() {
        return servService.obtenerServiciosPendientes();
    }

    @GetMapping("/ingresos-por-servicio")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<IngresosPorServicioDTO> obtenerIngresosPorServicio() {
        return servService.obtenerIngresosPorServicio();
    }

    @GetMapping("/mas-solicitados")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<TotalServiciosSolicitadoDTO>> getMostRequestedServices(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        LocalDate today = LocalDate.now();

        if (fechaInicio.isAfter(today) || fechaFin.isAfter(today)) {
            return ResponseEntity.badRequest().body(null);
        }

        List<TotalServiciosSolicitadoDTO> response = servService.getMostRequestedServiceByDate(fechaInicio, fechaFin);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/servicios-cancelados")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<ServicioCanceladoDTO>> getCancelledServicesByClient(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        LocalDate today = LocalDate.now();

        if (fechaInicio.isAfter(today) || fechaFin.isAfter(today)) {
            return ResponseEntity.badRequest().body(null);
        }

        List<ServicioCanceladoDTO> response = servService.getCancelledServicesByClient(fechaInicio, fechaFin);

        return ResponseEntity.ok(response);
    }
}
