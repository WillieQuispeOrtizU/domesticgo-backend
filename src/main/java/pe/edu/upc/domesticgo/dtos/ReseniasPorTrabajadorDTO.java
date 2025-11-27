package pe.edu.upc.domesticgo.dtos;

public class ReseniasPorTrabajadorDTO {
    private int idTrabajador;
    private String nombreTrabajador;
    private long totalResenias;

    public ReseniasPorTrabajadorDTO() {}

    public ReseniasPorTrabajadorDTO(int idTrabajador, String nombreTrabajador, long totalResenias) {
        this.idTrabajador = idTrabajador;
        this.nombreTrabajador = nombreTrabajador;
        this.totalResenias = totalResenias;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public long getTotalResenias() {
        return totalResenias;
    }

    public void setTotalResenias(long totalResenias) {
        this.totalResenias = totalResenias;
    }
}
