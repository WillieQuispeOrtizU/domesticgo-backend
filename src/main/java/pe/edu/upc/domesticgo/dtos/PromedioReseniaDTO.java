package pe.edu.upc.domesticgo.dtos;

public class PromedioReseniaDTO {

    private int idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double promedioCalificacionResenia;
    private double porcentajeCalificacionResenia;

    // Constructor


    public PromedioReseniaDTO(int idUsuario, String nombres, String apellidoMaterno, String apellidoPaterno, double promedioCalificacionResenia, double porcentajeCalificacionResenia) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.promedioCalificacionResenia = promedioCalificacionResenia;
        this.porcentajeCalificacionResenia = porcentajeCalificacionResenia;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public double getPromedioCalificacionResenia() {
        return promedioCalificacionResenia;
    }

    public void setPromedioCalificacionResenia(double promedioCalificacionResenia) {
        this.promedioCalificacionResenia = promedioCalificacionResenia;
    }

    public double getPorcentajeCalificacionResenia() {
        return porcentajeCalificacionResenia;
    }

    public void setPorcentajeCalificacionResenia(double porcentajeCalificacionResenia) {
        this.porcentajeCalificacionResenia = porcentajeCalificacionResenia;
    }
}
