package pe.edu.upc.domesticgo.dtos;

public class IngresosPorServicioDTO {
    private String tipoServicio;
    private double totalIngresos;

    public IngresosPorServicioDTO() {}

    public IngresosPorServicioDTO(String tipoServicio, double totalIngresos) {
        this.tipoServicio = tipoServicio;
        this.totalIngresos = totalIngresos;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }
}
