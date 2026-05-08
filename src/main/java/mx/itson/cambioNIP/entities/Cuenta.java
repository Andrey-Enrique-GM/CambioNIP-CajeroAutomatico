
package mx.itson.cambioNIP.entities;

// @author Andrey

public class Cuenta 
{
    
    // Atributos
    private int id;
    private String numeroCuenta;
    private double saldo;
    private String estado;
    
    
    
    // Constructores
    public Cuenta(int id, String numeroCuenta, double saldo, String estado) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Cuenta(String numeroCuenta, double saldo, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Cuenta() {
    }
 
    
    
    // to String
    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", estado=" + estado + '}';
    }
    
    
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
