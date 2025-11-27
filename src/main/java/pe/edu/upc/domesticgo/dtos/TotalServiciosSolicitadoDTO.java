package pe.edu.upc.domesticgo.dtos;

import java.time.LocalDate;

public class TotalServiciosSolicitadoDTO {

    private String tipoServicio;
    private Long cantidad;

    public TotalServiciosSolicitadoDTO(String tipoServicio,Long cantidad) {
        this.tipoServicio = tipoServicio;
        this.cantidad = cantidad;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }


    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
