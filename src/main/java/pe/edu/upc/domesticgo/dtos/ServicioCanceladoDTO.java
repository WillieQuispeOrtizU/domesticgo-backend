package pe.edu.upc.domesticgo.dtos;

public class ServicioCanceladoDTO {

    private int idServicio;
    private String estadoServicio;
    private String tipoServicio;

    // Constructor
    public ServicioCanceladoDTO(int idServicio, String estadoServicio, String tipoServicio) {
        this.idServicio = idServicio;
        this.estadoServicio = estadoServicio;
        this.tipoServicio = tipoServicio;
    }

    // Getters y Setters
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
}
