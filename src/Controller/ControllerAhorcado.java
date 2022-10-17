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
        int sizePalabra = modelo.getRonda().getSizePalabraActual();
        vistaAhorcado.cambiarFondoSegunSizePalabra(sizePalabra);
        vistaAhorcado.setNombre(modelo.getJugador().getNombre());
        vistaAhorcado.setIntentos(modelo.getJugador().getNumeroIntentos());
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
                
                if(modelo.getJugador().getNumeroIntentos() != 1){
                    int sizePalabra = modelo.getRonda().getSizePalabraActual();;
                
                    boolean resultado = modelo.validar((""+vistaAhorcado.saberLetraPresionada((JLabel) event.getSource())).toLowerCase().charAt(0));
                    if(resultado){
                        vistaAhorcado.ponerLetraInactiva( vistaAhorcado.saberLetraPresionada((JLabel) event.getSource()));                       
                    }
                    vistaAhorcado.agregarLetraSeleccionada(modelo.getRonda().getPosicionDeLetra() + 1, sizePalabra, (JLabel) event.getSource());
                    System.out.println("Letra pintada: "+ modelo.getRonda().getPosicionDeLetra());
                    vistaAhorcado.cambiarImagenAhorcadoError(modelo.getJugador().getConteoErrores() + 1);
                    vistaAhorcado.setIntentos(modelo.getJugador().getNumeroIntentos());
                }else{
                    vistaAhorcado.dispose();
                    System.out.println("Perdite el juego");
                }
                
            }
            
        }
        
    }
    
    
    
}
