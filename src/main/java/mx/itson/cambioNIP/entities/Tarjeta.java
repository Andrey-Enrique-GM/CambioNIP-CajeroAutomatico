
package mx.itson.cambioNIP.entities;

// @author Andrey

import java.time.LocalDate;


public class Tarjeta 
{
    
    // Atributos
    private int id;
    private String numeroTarjeta;
    private String nip;
    private LocalDate fechaVencimiento;
    private Cuenta cuenta;
    
    
    
    // Constructores
    public Tarjeta(int id, String numeroTarjeta, String nip, LocalDate fechaVencimiento, Cuenta cuenta) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.nip = nip;
        this.fechaVencimiento = fechaVencimiento;
        this.cuenta = cuenta;
    }

    public Tarjeta(String numeroTarjeta, String nip, LocalDate fechaVencimiento, Cuenta cuenta) {
        this.numeroTarjeta = numeroTarjeta;
        this.nip = nip;
        this.fechaVencimiento = fechaVencimiento;
        this.cuenta = cuenta;
    }

    public Tarjeta() {
    }
 
    
    
    // to String
    @Override
    public String toString() {
        return "Tarjeta{" + "id=" + id + ", numeroTarjeta=" + numeroTarjeta + ", nip=" + nip + ", fechaVencimiento=" + fechaVencimiento + ", cuenta=" + cuenta + '}';
    }
    
    
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
}
