/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class ModeloPrincipal {
    
    private Jugador jugador;
    private Ronda ronda;

    public ModeloPrincipal(Jugador jugador, Ronda ronda) {
        this.jugador = jugador;
        this.ronda = ronda;
    }
    
    public boolean validar(char letra) {
        boolean fallo = false;
        System.out.println("La letra ingresada es: " + letra);
        
        int index = ronda.getFraseActual().indexOf(letra);
        System.out.println("Index letra: " + index);
        ronda.setPosicionDeLetra(index);
        
        if(index != -1){
            
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
