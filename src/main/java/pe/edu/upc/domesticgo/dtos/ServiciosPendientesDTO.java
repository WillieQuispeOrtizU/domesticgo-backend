package pe.edu.upc.domesticgo.dtos;

public class ServiciosPendientesDTO {
    private long totalPendientes;

    public ServiciosPendientesDTO() {}

    public ServiciosPendientesDTO(long totalPendientes) {
        this.totalPendientes = totalPendientes;
    }

    public long getTotalPendientes() {
        return totalPendientes;
    }

    public void setTotalPendientes(long totalPendientes) {
        this.totalPendientes = totalPendientes;
    }
}
