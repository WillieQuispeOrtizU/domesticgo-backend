package pe.edu.upc.domesticgo.dtos;

public class UserRegisterDTO {
    private String username;
    private String password;
    private String tipoRol; // "TRABAJADOR" o "CLIENTE"

    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getTipoRol() { return tipoRol; }
    public void setTipoRol(String tipoRol) { this.tipoRol = tipoRol; }
}