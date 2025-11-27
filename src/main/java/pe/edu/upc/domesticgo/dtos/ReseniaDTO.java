package pe.edu.upc.domesticgo.dtos;

import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.entities.Usuario;

import java.time.LocalDate;

public class ReseniaDTO {
    private int idResenia;
    private LocalDate fechaResenia;
    private String comentarioResenia;
    private int calificacionResenia;
    private Usuario usuario;
    private Servicio servicio;

    // Getters and Setters
    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public LocalDate getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    public String getComentarioResenia() {
        return comentarioResenia;
    }

    public void setComentarioResenia(String comentarioResenia) {
        this.comentarioResenia = comentarioResenia;
    }

    public int getCalificacionResenia() {
        return calificacionResenia;
    }

    public void setCalificacionResenia(int calificacionResenia) {
        this.calificacionResenia = calificacionResenia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
