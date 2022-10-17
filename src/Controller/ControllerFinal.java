/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaFinal;
import Vistas.VistaPrincipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class ControllerFinal {
    
    private final ModeloPrincipal modelo;
    private final VistaFinal vistaFinal;

    public ControllerFinal(ModeloPrincipal modelo, VistaFinal vistaFinal) {
        this.modelo = modelo;
        this.vistaFinal = vistaFinal;
        
        vistaFinal.iniciarComponentesFinal();
        vistaFinal.configurarVistaFinal();
        
        vistaFinal.setNombre(modelo.getJugador().getNombre());
        vistaFinal.setGanadas(modelo.getJugador().porcentajeGanadas());
        vistaFinal.setPerdidas(modelo.getJugador().porcentajePerdidas());
        vistaFinal.setJugadas(modelo.getJugador().getPartidasJugadas());
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        vistaFinal.addLblVolverMouseListener(controllerMouse);
        vistaFinal.addLblCerrarMouseListener(controllerMouse);
        
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vistaFinal.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vistaFinal.dispose();
             
                }
            }else if(event.getSource() == vistaFinal.getLblVolver()){
                vistaFinal.dispose();
                VistaPrincipal vista = new VistaPrincipal();
                ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
            }
        }
    
    }
    
}
