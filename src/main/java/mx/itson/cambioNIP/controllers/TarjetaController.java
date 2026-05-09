
package mx.itson.cambioNIP.controllers;

// @author Andrey

import java.time.LocalDateTime;
import mx.itson.cambioNIP.dao.TarjetaDAO;
import mx.itson.cambioNIP.dao.TransaccionDAO;
import mx.itson.cambioNIP.entities.Tarjeta;
import mx.itson.cambioNIP.entities.Transaccion;


public class TarjetaController 
{
    
    public String procesarCambioNIP(String numeroTarjeta, String nipActual, String nuevoNip, String confirmacionNip) {
        
        // 1. Validar que los campos no esten vacios y que el NIP sea de 4 digitos
        if(nuevoNip == null || nuevoNip.length() != 4 || !nuevoNip.matches("\\d+")) {
            return "Error: El NIP debe ser de 4 digitos numericos.";
        }

        // 2. Validar que el nuevo NIP y la confirmación coincidan
        if (!nuevoNip.equals(confirmacionNip)) {
            return "Error: Los NIPs nuevos no coinciden.";
        }
        
        // 3. Validar que el nuevo NIP no sea igual al anterior
        if (nipActual.equals(nuevoNip)) {
            return "Error: El nuevo NIP no puede ser igual al actual.";
        }

        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        
        // 4. RF1: Autenticar
        if (!tarjetaDAO.verificarNIP(numeroTarjeta, nipActual)) {
            return "Error: El NIP actual es incorrecto.";
        }

        // 5. Proceder con la actualizacion
        boolean actualizado = tarjetaDAO.actualizarNIP(numeroTarjeta, nuevoNip);
        
        if (actualizado) {
            // 6. RF5: Registrar la transaccion
            Tarjeta tarjeta = tarjetaDAO.obtenerPorNumero(numeroTarjeta);
            Transaccion transaccion = new Transaccion();
            transaccion.setTipo("CAMBIO_NIP");
            transaccion.setFechaHora(LocalDateTime.now());
            transaccion.setTarjeta(tarjeta);
            
            TransaccionDAO transaccionDAO = new TransaccionDAO();
            transaccionDAO.registrar(transaccion);
            
            return "Exito: Su NIP ha sido cambiado correctamente.";
        } else {
            return "Error: No se pudo actualizar el NIP en el sistema.";
        }
    }
    
}
