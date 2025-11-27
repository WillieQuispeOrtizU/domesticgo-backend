package pe.edu.upc.domesticgo.dtos;

import java.time.LocalDate;

public class TotalPagosDTO {
    private long totalPagos;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public TotalPagosDTO() {}

    public TotalPagosDTO(long totalPagos, LocalDate fechaInicio, LocalDate fechaFin) {
        this.totalPagos = totalPagos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public long getTotalPagos() {
        return totalPagos;
    }

    public void setTotalPagos(long totalPagos) {
        this.totalPagos = totalPagos;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
