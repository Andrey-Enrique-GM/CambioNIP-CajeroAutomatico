
package mx.itson.cambioNIP.app;

// @author Andrey

import mx.itson.cambioNIP.view.LoginView;


public class App 
{
    
    public static void main(String[] args) {
        // Ejecutar la interfaz grafica en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> {
            LoginView login = new LoginView();
            
            // Centrar la ventana en la pantalla
            login.setLocationRelativeTo(null);
            
            // Hacerla visible
            login.setVisible(true);
            
            System.out.println("Cajero Automatico iniciado correctamente.");
        });
    }
    
}
