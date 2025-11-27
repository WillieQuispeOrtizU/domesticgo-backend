package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombres", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = true, length = 50)
    @Size(max = 50)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = true, length = 50)
    @Size(max = 50)
    private String apellidoMaterno;

    @Column(name = "email", nullable = false, length = 100)
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String email;

    @Column(name = "tipoDocumento", nullable = false, length = 50)
    @NotNull
    private String tipoDocumento;

    @Column(name = "numeroDocumento", nullable = false, length = 50)
    @NotNull
    @Size(min = 8, max = 20, message = "El número de documento debe tener entre 8 y 20 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "El número de documento debe ser numérico")
    private String numeroDocumento;

    @Column(name = "numeroCelular", nullable = false, length = 50)
    @NotNull
    @Size(min = 9, max = 50, message = "El número de celular debe tener al menos 9 dígitos")
    @Pattern(regexp = "^[0-9]+$", message = "El número de celular debe contener solo números")
    private String numeroCelular;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "idEmpleo", nullable = false)
    private Empleo empleo;

    // Constructores, Getters y Setters

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String email, String tipoDocumento, String numeroDocumento, String numeroCelular, LocalDate fechaNacimiento, Empleo empleo) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.numeroCelular = numeroCelular;
        this.fechaNacimiento = fechaNacimiento;
        this.empleo = empleo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleo getEmpleo() {
        return empleo;
    }

    public void setEmpleo(Empleo empleo) {
        this.empleo = empleo;
    }
}
