package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    @Column(name = "estadoServicio", nullable = false, length = 50)
    private String estadoServicio;

    @Column(name = "tipoServicio", nullable = false, length = 50)
    private String tipoServicio;

    // Foreign Keys @ManytoOne Reserva y @OnetoOne Contrato

    @OneToOne
    @JoinColumn(name = "idContrato",nullable = false)
    private Contrato contrato;
    @ManyToOne
    @JoinColumn(name = "idReserva", nullable = false)
    private Reserva reserva;

    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Servicio() {
    }

    public Servicio(int idServicio, String estadoServicio, String tipoServicio, Contrato contrato, Reserva reserva) {
        this.idServicio = idServicio;
        this.estadoServicio = estadoServicio;
        this.tipoServicio = tipoServicio;
        this.contrato = contrato;
        this.reserva = reserva;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
