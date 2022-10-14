/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AhorcadoUnivallePrincipal;

import Controller.ControllerPrincipal;
import Modelo.ModeloPrincipal;
import Vistas.VistaLogin;

/**
 *
 * @author RYZEN
 */
public class AhorcadoUnivalle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaLogin vista = new VistaLogin();
        ModeloPrincipal modelo = new ModeloPrincipal();
        
        ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
        
        
    }
    
}
