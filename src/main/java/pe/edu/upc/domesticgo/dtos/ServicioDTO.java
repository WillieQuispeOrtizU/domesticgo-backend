package pe.edu.upc.domesticgo.dtos;

import pe.edu.upc.domesticgo.entities.Contrato;
import pe.edu.upc.domesticgo.entities.Reserva;

public class ServicioDTO {
    private int idServicio;
    private String estadoServicio;
    private String tipoServicio;
    private Contrato contrato;
    private Reserva reserva;

    public ServicioDTO(int idServicio, String estadoServicio, String tipoServicio, Contrato contrato, Reserva reserva) {
        this.idServicio = idServicio;
        this.estadoServicio = estadoServicio;
        this.tipoServicio = tipoServicio;
        this.contrato = contrato;
        this.reserva = reserva;
    }
    public ServicioDTO() {
    }
    // Getters and Setters
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
