
package mx.itson.cambioNIP.dao;

// @author Andrey

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mx.itson.cambioNIP.entities.Tarjeta;


public class TarjetaDAO 
{
    
    // RF1: Verifica si el numero de tarjeta y el NIP coinciden en la base de datos
    public boolean verificarNIP(String numeroTarjeta, String nipActual) {
        boolean esValido = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT id FROM tarjeta WHERE numero_tarjeta = ? AND nip = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, numeroTarjeta);
            statement.setString(2, nipActual);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                esValido = true;
            }
        } catch (Exception ex) {
            System.err.println("Error al verificar NIP: " + ex.getMessage());
        }
        return esValido;
    }
    
    
    
    // Realiza el cambio fisico del NIP en la base de datos
    public boolean actualizarNIP(String numeroTarjeta, String nuevoNip) {
        boolean exito = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE tarjeta SET nip = ? WHERE numero_tarjeta = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nuevoNip);
            statement.setString(2, numeroTarjeta);

            int filasAfectadas = statement.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (Exception ex) {
            System.err.println("Error al actualizar NIP: " + ex.getMessage());
        }
        return exito;
    }
    
    
    
    // Recupera una Tarjeta completa por su numero para poder registrar la transaccion
    public Tarjeta obtenerPorNumero(String numeroTarjeta) {
        Tarjeta t = null;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT id, numero_tarjeta FROM tarjeta WHERE numero_tarjeta = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, numeroTarjeta);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                t = new Tarjeta();
                t.setId(rs.getInt("id"));
                t.setNumeroTarjeta(rs.getString("numero_tarjeta"));
            }
        } catch (Exception ex) {
            System.err.println("Error al obtener tarjeta: " + ex.getMessage());
        }
        return t;
    }
    
    
    
    // Recupera el nombre del propietario de la tarjeta por su numero de tarjeta
    public String obtenerNombrePorTarjeta(String numeroTarjeta) {
        String nombre = "Usuario";
        try {
            Connection con = Conexion.obtener();
            String sql = "SELECT nombre FROM cuenta " +
                         "JOIN tarjeta ON cuenta.id = tarjeta.cuenta_id " +
                         "WHERE tarjeta.numero_tarjeta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, numeroTarjeta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre");
            }
        } catch (Exception e) {
            System.err.println("Error al obtener nombre: " + e.getMessage());
        }
        return nombre;
    }
    
}
