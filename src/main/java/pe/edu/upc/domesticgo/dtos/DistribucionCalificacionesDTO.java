package pe.edu.upc.domesticgo.dtos;

public class DistribucionCalificacionesDTO {
    private int calificacion; // 1, 2, 3, 4, 5
    private long cantidad;

    public DistribucionCalificacionesDTO(int calificacion, long cantidad) {
        this.calificacion = calificacion;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }
    public long getCantidad() { return cantidad; }
    public void setCantidad(long cantidad) { this.cantidad = cantidad; }
}