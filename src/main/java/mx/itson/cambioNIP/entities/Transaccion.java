
package mx.itson.cambioNIP.entities;

// @author Andrey

import java.time.LocalDateTime;


public class Transaccion 
{
    
    // Atributos
    private int id;
    private String tipo;
    private LocalDateTime fechaHora;
    private Tarjeta tarjeta;
    
    
    
    // Constructores
    public Transaccion(int id, String tipo, LocalDateTime fechaHora, Tarjeta tarjeta) {
        this.id = id;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.tarjeta = tarjeta;
    }

    public Transaccion(String tipo, LocalDateTime fechaHora, Tarjeta tarjeta) {
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.tarjeta = tarjeta;
    }

    public Transaccion() {
    }
 
    
    
    // to String
    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", tipo=" + tipo + ", fechaHora=" + fechaHora + ", tarjeta=" + tarjeta + '}';
    }
    
    
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
}
