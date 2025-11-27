package pe.edu.upc.domesticgo.dtos;

public class ServiciosContratadosDTO {
    private int mes;
    private int anio;
    private long totalServicios;

    public ServiciosContratadosDTO() {}

    public ServiciosContratadosDTO(int mes, int anio, long totalServicios) {
        this.mes = mes;
        this.anio = anio;
        this.totalServicios = totalServicios;
    }

    // Getters and Setters
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public long getTotalServicios() {
        return totalServicios;
    }

    public void setTotalServicios(long totalServicios) {
        this.totalServicios = totalServicios;
    }
}
