package AhorcadoUnivallePrincipal;

import Controller.ControllerPrincipal;
import Modelo.Jugador;
import Modelo.ModeloPrincipal;
import Modelo.Ronda;
import Vistas.VistaPrincipal;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class AhorcadoUnivalle {

    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        Ronda ronda = new Ronda();
        VistaPrincipal vista = new VistaPrincipal();
        ModeloPrincipal modelo = new ModeloPrincipal(jugador, ronda);
        
        ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
        
        
    }
    
}
