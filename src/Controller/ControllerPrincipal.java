/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaLogin;
import Vistas.VistaSeleccionarTema;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class ControllerPrincipal {
    private ModeloPrincipal modelo;
    private VistaLogin vista;

    public ControllerPrincipal(ModeloPrincipal modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.iniciarComponentesLogin();
        vista.configurarVistaLogin();
        
        
        agregarControllers();
          
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        
        vista.addLblCerrarMouseListener(controllerMouse);
        vista.addLblJugarMouseListener(controllerMouse);
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vista.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vista.dispose();
             
                }
            }else if(event.getSource() == vista.getJugar()){
                vista.dispose();
                VistaSeleccionarTema vistaTema = new VistaSeleccionarTema();
                ControllerSeleccionarTema controllerTema = new ControllerSeleccionarTema(modelo,vistaTema);
           }
            
        }
   
    }
    
    
    
    
}
