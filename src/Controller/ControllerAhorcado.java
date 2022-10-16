/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaAhorcado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public final class ControllerAhorcado {
    
    private final ModeloPrincipal modelo;
    private final VistaAhorcado vistaAhorcado;

    public ControllerAhorcado(ModeloPrincipal modelo, VistaAhorcado vistaAhorcado) {
        this.modelo = modelo;
        this.vistaAhorcado = vistaAhorcado;
        
        vistaAhorcado.iniciarComponentesAhorcado();
        vistaAhorcado.configurarVistaAhorcado();
        int sizePalabra = 4;
        vistaAhorcado.cambiarFondoSegunSizePalabra(sizePalabra);
        vistaAhorcado.setNombre("Andres Del Carmen de los Santos");
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        vistaAhorcado.addLblLetrasMouseListener(controllerMouse);
        
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vistaAhorcado.saberSiUnaLetraFuePresionada( (JLabel) event.getSource())){
                int sizePalabra = 4;
                
                //vistaAhorcado.ponerLetraInactiva( vistaAhorcado.saberLetraPresionada((JLabel) event.getSource()));
                vistaAhorcado.agregarLetraSeleccionada(3, sizePalabra, (JLabel) event.getSource());
                vistaAhorcado.cambiarImagenAhorcadoError(1);
                
            }
            
        }
        
    }
    
    
    
}
