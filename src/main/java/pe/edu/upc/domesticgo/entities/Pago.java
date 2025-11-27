package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(name = "tipoPago", nullable = false, length = 30)
    private String tipoPago;

    @Column(name = "tipoComprobante", nullable = false, length = 25)
    private String tipoComprobante;

    @Column(name = "bancoPago", nullable = false, length = 50)
    private String bancoPago;

    @Column(name = "fechaPago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "montoPago",nullable = false)
    private double montoPago;

    @Column(name = "estadoPago", nullable = false, length = 50)  // Se añadió este campo
    private String estadoPago;
    // Foreign Key @ManytoOne Contrato

    @ManyToOne
    @JoinColumn(name = "idContrato", nullable = false)
    private Contrato contrato;

    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Pago() {
    }

    public Pago(int idPago, String tipoComprobante, String tipoPago, String bancoPago, LocalDate fechaPago, double montoPago, String estadoPago, Contrato contrato) {
        this.idPago = idPago;
        this.tipoComprobante = tipoComprobante;
        this.tipoPago = tipoPago;
        this.bancoPago = bancoPago;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.estadoPago = estadoPago;
        this.contrato = contrato;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getBancoPago() {
        return bancoPago;
    }

    public void setBancoPago(String bancoPago) {
        this.bancoPago = bancoPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }
    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
