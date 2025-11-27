package pe.edu.upc.domesticgo.dtos;

public class NotificacionesPorUsuarioDTO {

    private int idUsuario;           // ID del usuario
    private long cantidadNotificaciones; // Cantidad de notificaciones que tiene el usuario

    // Constructor
    public NotificacionesPorUsuarioDTO(int idUsuario, long cantidadNotificaciones) {
        this.idUsuario = idUsuario;
        this.cantidadNotificaciones = cantidadNotificaciones;
    }

    // Getters and Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getCantidadNotificaciones() {
        return cantidadNotificaciones;
    }

    public void setCantidadNotificaciones(long cantidadNotificaciones) {
        this.cantidadNotificaciones = cantidadNotificaciones;
    }
}
