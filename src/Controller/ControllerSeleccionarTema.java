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
public class ControllerSeleccionarTema {
    
    private ModeloPrincipal modelo;
    private VistaSeleccionarTema vistaTema;

    public ControllerSeleccionarTema(ModeloPrincipal modelo, VistaSeleccionarTema vistaTema) {
        this.modelo = modelo;
        this.vistaTema = vistaTema;
        
        vistaTema.iniciarComponentesTema();
        vistaTema.configurarVistaTema();
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        
        vistaTema.addLblCerrarMouseListener(controllerMouse);
        vistaTema.addLblVolverMouseListener(controllerMouse);
        vistaTema.addLblAnimalesMouseListener(controllerMouse);
        vistaTema.addLblColoresMouseListener(controllerMouse);
        vistaTema.addLblFrutasMouseListener(controllerMouse);
        
    }
    
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vistaTema.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vistaTema.dispose();
             
                }
            }else if (event.getSource() == vistaTema.getLblAnimales()){
                vistaTema.cambiarAnimalesActivo();
                vistaTema.setAnimalesActivo(true);
                
                vistaTema.cambiarColoresInactivo();
                vistaTema.cambiarFrutasInactivo();
                
                vistaTema.setColoresActivo(false);
                vistaTema.setFrutasActivo(false);
                
                if(!"".equals(vistaTema.getNombre())){
                    vistaTema.agregarLblIniciar();             
                    vistaTema.addLblIniciarMouseListener(this);
                    vistaTema.eliminarLblIngresarNombre();
                }else{
                    vistaTema.agregarLblIngresarNombre();
                    vistaTema.eliminarLblIniciar();
                }
                
            }else if(event.getSource() == vistaTema.getLblColores()){
                vistaTema.cambiarColoresActivo();
                vistaTema.setColoresActivo(true);
                
                vistaTema.cambiarAnimalesInactivo();
                vistaTema.cambiarFrutasInactivo();
                
                vistaTema.setAnimalesActivo(false);
                vistaTema.setFrutasActivo(false);
                
                if(!"".equals(vistaTema.getNombre())){
                    vistaTema.agregarLblIniciar();
                    vistaTema.addLblIniciarMouseListener(this);
                    vistaTema.eliminarLblIngresarNombre();             
                }else{
                    vistaTema.agregarLblIngresarNombre();
                    vistaTema.eliminarLblIniciar();
                }
                
            }else if(event.getSource() == vistaTema.getLblFrutas()){
                vistaTema.cambiarFrutasActivo();
                vistaTema.setFrutasActivo(true);
                
                vistaTema.cambiarAnimalesInactivo();
                vistaTema.cambiarColoresInactivo();
                
                vistaTema.setAnimalesActivo(false);
                vistaTema.setColoresActivo(false);
                
                if(!"".equals(vistaTema.getNombre())){
                    vistaTema.agregarLblIniciar();
                    vistaTema.addLblIniciarMouseListener(this);
                    vistaTema.eliminarLblIngresarNombre();
                }else{
                    vistaTema.agregarLblIngresarNombre();
                    vistaTema.eliminarLblIniciar();
                }
            }else if(event.getSource() == vistaTema.getLblIniciar()){
                
                if("".equals(vistaTema.getNombre())){
                    vistaTema.eliminarLblIniciar();
                }
                
            }else if(event.getSource() == vistaTema.getLblVolver()){
                vistaTema.dispose();
                VistaLogin vista = new VistaLogin();
                ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
            }
            
            
            
        }
        
        @Override
        public void mouseEntered(MouseEvent event){
            if (event.getSource() == vistaTema.getLblAnimales()){
                vistaTema.cambiarAnimalesActivo();
            }else if(event.getSource() == vistaTema.getLblColores()){
                vistaTema.cambiarColoresActivo();
            }else if(event.getSource() == vistaTema.getLblFrutas()){
                vistaTema.cambiarFrutasActivo();
            }
            
        }
        
        @Override
        public void mouseExited(MouseEvent event){
            if (event.getSource() == vistaTema.getLblAnimales() && vistaTema.isAnimalesActivo() == false){
                vistaTema.cambiarAnimalesInactivo();
            }else if(event.getSource() == vistaTema.getLblColores() && vistaTema.isColoresActivo() == false){
                vistaTema.cambiarColoresInactivo();
            }else if(event.getSource() == vistaTema.getLblFrutas() && vistaTema.isFrutasActivo() == false){
                vistaTema.cambiarFrutasInactivo();
            }
        }
   
    }
    
    
    
}
