/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaComoJugar;
import Vistas.VistaPrincipal;
import Vistas.VistaSeleccionarTema;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class ControllerComoJugar {
    
    private ModeloPrincipal modelo;
    private VistaComoJugar vistaComoJugar;
    
    public ControllerComoJugar(ModeloPrincipal modelo, VistaComoJugar vistaComoJugar) {
        this.modelo = modelo;
        this.vistaComoJugar = vistaComoJugar;
        
        vistaComoJugar.iniciarComponentesComoJugar();
        vistaComoJugar.configurarVistaComoJugar();
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        
        vistaComoJugar.addLblCerrarMouseListener(controllerMouse);
        vistaComoJugar.addLblVolverMouseListener(controllerMouse);
        vistaComoJugar.addLblSiguienteMouseListener(controllerMouse);
        
        
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vistaComoJugar.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vistaComoJugar.dispose();
             
                }
            }else if(event.getSource() == vistaComoJugar.getLblVolver()){
                vistaComoJugar.dispose();
                VistaPrincipal vista = new VistaPrincipal();
                ControllerPrincipal vistaPrincipal = new ControllerPrincipal(modelo, vista);
            }
        }
    }
    
    
}
