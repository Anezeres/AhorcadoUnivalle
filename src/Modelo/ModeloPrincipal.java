package Modelo;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class ModeloPrincipal {
    
    private Jugador jugador;
    private Ronda ronda;
    private String palabra;

    public ModeloPrincipal(Jugador jugador, Ronda ronda) {
        this.jugador = jugador;
        this.ronda = ronda;
        palabra = "";
    }
    
    public boolean validar(char letra) {
        boolean fallo = false;
        System.out.println("La letra ingresada es: " + letra);
        
        int index = ronda.getFraseActual().indexOf(letra);
        System.out.println("Index letra: " + index);
        ronda.setPosicionDeLetra(index);
        
        if(index != -1){
            remplazarCaracterFraseAuxiliar(index);
            while(index > -1){
                
                if(index != -1){
                    ronda.setPosicionDeLetra(index);
                }
                
                index = ronda.getFraseActual().indexOf(letra,index  + 1);
                System.out.println("Valor del Idex dentro del bucle: "+ index);
                
            }
            
            
            
            fallo = false;
        }else {
            fallo = true;
            jugador.sumarConteoErrores();
            jugador.restarNumeroIntentos();
        }
        return fallo;
    }
    
    

    public void remplazarCaracterFraseAuxiliar(int index){ 
        
        ronda.setPalabraActualAuxiliar(ronda.getPalabraActualAuxiliar().substring(0, index) + ronda.palabraActual.charAt(index)+ ronda.getPalabraActualAuxiliar().substring(index + 1));
        System.out.println("Palabra Auxiliar: " + ronda.getPalabraActualAuxiliar());
    }
    
    public boolean validarFraseCompleta(){
        return ronda.getPalabraActualAuxiliar().contains(ronda.getFraseActual());
    }
    
    public void preguntarOtraVez(char letra){
        validar(letra);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }
    
    
    
}
