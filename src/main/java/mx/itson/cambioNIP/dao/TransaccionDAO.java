
package mx.itson.cambioNIP.dao;

// @author Andrey

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import mx.itson.cambioNIP.entities.Transaccion;


public class TransaccionDAO 
{
    
    // RF5: Registra el movimiento en la base de datos
    public boolean registrar(Transaccion transaccion) {
        boolean exito = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO transaccion (tipo, fecha_hora, tarjeta_id) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            statement.setString(1, transaccion.getTipo());
            // Convertimos LocalDateTime a Timestamp para MySQL
            statement.setTimestamp(2, Timestamp.valueOf(transaccion.getFechaHora()));
            statement.setInt(3, transaccion.getTarjeta().getId());

            int filasAfectadas = statement.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (Exception ex) {
            System.err.println("Error al registrar transaccion: " + ex.getMessage());
        }
        return exito;
    }
    
}
