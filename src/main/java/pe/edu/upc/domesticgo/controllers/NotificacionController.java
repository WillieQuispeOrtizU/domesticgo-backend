package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.NotificacionDTO;
import pe.edu.upc.domesticgo.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.domesticgo.entities.Notificacion;
import pe.edu.upc.domesticgo.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService notiService;

    // CLIENTE y ADMIN pueden listar
    @GetMapping("/listado")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<NotificacionDTO> listar() {
        return notiService.list().stream().map(n ->{
            ModelMapper m = new ModelMapper();
            return m.map(n, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    // Solo ADMIN puede registrar
    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody NotificacionDTO notiDto){
        ModelMapper m=new ModelMapper();
        Notificacion noti=m.map(notiDto, Notificacion.class);
        notiService.insert(noti);
    }

    // Solo ADMIN puede modificar
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody NotificacionDTO notiDto){
        ModelMapper m=new ModelMapper();
        Notificacion noti=m.map(notiDto, Notificacion.class);
        notiService.update(noti);
    }

    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        notiService.delete(id);
    }

    // CLIENTE y ADMIN pueden buscar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public NotificacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        NotificacionDTO dto=m.map(notiService.searchId(id), NotificacionDTO.class);
        return dto;
    }

    @GetMapping("/total-notifiaciones")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<NotificacionesPorUsuarioDTO> getNotificationCountByUser() {
        return notiService.getNotificationCountByUser();
    }
}
