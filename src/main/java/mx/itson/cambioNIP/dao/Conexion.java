
package mx.itson.cambioNIP.dao;

// @author Andrey

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion 
{
    
    private static String usuario = "andrey";
    private static String clave = "---";
    private static String url = "jdbc:mysql://34.30.245.236:3306/cajero_automatico";
    
    private static Connection con;
    
    
    /**
     * Metodo estatico para obtener la conexion a la base de datos.
     * @return Objeto Connection activo.
     */
    public static Connection obtener() {
        try {
            // Verificamos si la conexión es nula o se cerro por tiempo de inactividad
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, usuario, clave);
                System.out.println("¡Conexión establecida con el servidor!");
            }
        } catch (Exception ex) {
            System.err.println("Error de conexión: " + ex.getMessage());
        }
        return con;
    }
    
    
}
