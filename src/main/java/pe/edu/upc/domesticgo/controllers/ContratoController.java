package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ContratoDTO;
import pe.edu.upc.domesticgo.dtos.ServiciosContratadosDTO;
import pe.edu.upc.domesticgo.dtos.ClientesRecurrentesDTO;
import pe.edu.upc.domesticgo.entities.Contrato;
import pe.edu.upc.domesticgo.servicesinterfaces.IContratoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private IContratoService contService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<ContratoDTO> listar() {
        return contService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ContratoDTO contDto){
        ModelMapper m=new ModelMapper();
        Contrato cont=m.map(contDto, Contrato.class);
        contService.insert(cont);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ContratoDTO contDto){
        ModelMapper m=new ModelMapper();
        Contrato cont=m.map(contDto, Contrato.class);
        contService.update(cont);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        contService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ContratoDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ContratoDTO dto=m.map(contService.searchId(id), ContratoDTO.class);
        return dto;
    }

    // REPORTES - Solo ADMIN
    @GetMapping("/servicios-por-mes")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ServiciosContratadosDTO> obtenerServiciosPorMes(@RequestParam int mes, @RequestParam int anio) {
        return contService.obtenerServiciosPorMes(mes, anio);
    }

    @GetMapping("/clientes-recurrentes")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ClientesRecurrentesDTO obtenerClientesRecurrentes() {
        return contService.obtenerClientesRecurrentes();
    }
}
