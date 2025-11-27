package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.domesticgo.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    // Metodos de CRUD
    public List<Notificacion> list();
    public void insert(Notificacion noti);
    public void update(Notificacion noti);
    public void delete(int id);
    public Notificacion searchId(int id);

    public List<NotificacionesPorUsuarioDTO> getNotificationCountByUser();
}
