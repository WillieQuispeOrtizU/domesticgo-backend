package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

    @Column(name = "fechaReserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "detalleReserva", nullable = false, length = 250)
    private String detalleReserva;


    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Reserva() {
    }

    public Reserva(String detalleReserva, LocalDate fechaReserva, int idReserva) {
        this.detalleReserva = detalleReserva;
        this.fechaReserva = fechaReserva;
        this.idReserva = idReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(String detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

}
