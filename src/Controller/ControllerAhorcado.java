/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaAhorcado;
import java.awt.event.MouseAdapter;

/**
 *
 * @author RYZEN
 */
public class ControllerAhorcado {
    
    private ModeloPrincipal modelo;
    private VistaAhorcado vistaAhorcado;

    public ControllerAhorcado(ModeloPrincipal modelo, VistaAhorcado vistaAhorcado) {
        this.modelo = modelo;
        this.vistaAhorcado = vistaAhorcado;
        
        vistaAhorcado.iniciarComponentesAhorcado();
        vistaAhorcado.configurarVistaAhorcado();
        
        //agregarControllers();
    }
    
    public void agregarControllers(){
        
        //MouseListenerController controllerMouse = new MouseListenerController();
        
    }
    
    public class MouseListenerController extends MouseAdapter{
        
    }
    
    
    
}
