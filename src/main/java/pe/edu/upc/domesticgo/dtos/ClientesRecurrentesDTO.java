package pe.edu.upc.domesticgo.dtos;

public class ClientesRecurrentesDTO {
    private long totalClientesRecurrentes;

    public ClientesRecurrentesDTO() {}

    public ClientesRecurrentesDTO(long totalClientesRecurrentes) {
        this.totalClientesRecurrentes = totalClientesRecurrentes;
    }

    public long getTotalClientesRecurrentes() {
        return totalClientesRecurrentes;
    }

    public void setTotalClientesRecurrentes(long totalClientesRecurrentes) {
        this.totalClientesRecurrentes = totalClientesRecurrentes;
    }
}
