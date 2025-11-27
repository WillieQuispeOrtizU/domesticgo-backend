package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResenia;

    @Column(name = "fechaResenia", nullable = false)
    private LocalDate fechaResenia;

    @Column(name = "comentarioResenia", nullable = false, length = 200)
    private String comentarioResenia;

    @Column(name = "calificacionResenia", nullable = false)
    private int calificacionResenia;

    // Foreign Keys @ManytoOne Usuario y Servicio

    @ManyToOne
    @JoinColumn(name = "idUsuario",nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idServicio",nullable = false)
    private Servicio servicio;

    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Resenia() {
    }

    public Resenia(int idResenia, LocalDate fechaResenia, String comentarioResenia, int calificacionResenia, Usuario usuario, Servicio servicio) {
        this.idResenia = idResenia;
        this.fechaResenia = fechaResenia;
        this.comentarioResenia = comentarioResenia;
        this.calificacionResenia = calificacionResenia;
        this.usuario = usuario;
        this.servicio = servicio;
    }

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
        if (calificacionResenia >= 1 && calificacionResenia <= 5) {
            this.calificacionResenia = calificacionResenia;
        } else {
            throw new IllegalArgumentException("La puntuación debe estar entre 1 y 5.");
        }
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
