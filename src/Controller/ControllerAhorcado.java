/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaAhorcado;
import Vistas.VistaFinal;
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
        modelo.getJugador().setPartidasJugadas(modelo.getJugador().getPartidasJugadas() + 1);
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
                boolean resultado = modelo.validar((""+vistaAhorcado.saberLetraPresionada((JLabel) event.getSource())).toLowerCase().charAt(0));
                if(modelo.getJugador().getNumeroIntentos() != 1){
                    
                    int sizePalabra = modelo.getRonda().getSizePalabraActual();
                    vistaAhorcado.agregarLetraSeleccionada(modelo.getRonda().getPosicionDeLetra() + 1, sizePalabra, (JLabel) event.getSource());
                    
                    if(modelo.validarFraseCompleta()){
                        modelo.getJugador().setPartidasGanadas(modelo.getJugador().getPartidasGanadas() + 1);
                    
                        if (JOptionPane.showConfirmDialog(null, "¿Quieres seguir jugando?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            vistaAhorcado.dispose();
                            
                        }else{
                            vistaAhorcado.dispose();
                            VistaFinal vistaFinal = new VistaFinal();
                            ControllerFinal controllerFinal = new ControllerFinal(modelo, vistaFinal);
                        }
             
                    }else{
                        
                        if(resultado){
                            vistaAhorcado.ponerLetraInactiva( vistaAhorcado.saberLetraPresionada((JLabel) event.getSource()));                       
                        }
                        
                        
                        vistaAhorcado.cambiarImagenAhorcadoError(modelo.getJugador().getConteoErrores() + 1);
                        vistaAhorcado.setIntentos(modelo.getJugador().getNumeroIntentos());
                        
                        
                    }
                    
                    
                }else{
                    vistaAhorcado.dispose();
                    modelo.getJugador().setPartidasPerdidas(modelo.getJugador().getPartidasPerdidas() + 1);
                    VistaFinal vistaFinal = new VistaFinal();
                    ControllerFinal controllerFinal = new ControllerFinal(modelo, vistaFinal);
                }
                
            }
            
        }
        
    }
    
    
    
}
