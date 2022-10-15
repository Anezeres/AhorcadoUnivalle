/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class Jugador {
    private Ronda frases;
    
    private String frase, clave, errores;
    
    private int conteoErrores, numeroIntentos;
    
    private boolean fallo, ganar;
    
    
    public Jugador() {
        frases = new Ronda();
        
    }
    
    
    
    public String dibujarFrase(){
        //Inicializacion delas variables de la ronda.
        clave = "";  
        //Obtener frase
        frase = frases.getFrase();        
        errores = "Letras Erroneas: ";
        conteoErrores = 0;
        numeroIntentos = 10;        
        //Crear clave
        
        for(int i=0; i < frase.length(); i++){ 
        if(frase.charAt(i) == ' '){
            clave += frase.charAt(i);
        } else{
            clave += "-";
        }
    }
        return clave;
    }
    
    public String validar(char letra) {
        fallo = false;
        int index = frase.indexOf(letra);
        if(index != -1){
            while(index > -1){
                reemplazarLetra(index, letra);
                index = frase.indexOf(index + 1, letra);
                
            }
        } else { 
            fallo = true;
            conteoErrores++;
            numeroIntentos--;
            errores += letra + " ";
        }
        return clave;
    }

    private void reemplazarLetra(int index, char letra) {
        char[] arrayClave = clave.toCharArray();
        arrayClave[index] = letra;
        clave = String.copyValueOf(arrayClave);
    }
    
    public boolean ganador(){
        if(clave.indexOf('-') == -1) {
            ganar = true;
        }else {
            ganar = false;
        }
        return ganar;
    }
    
    public String getClave() {
        return clave;
    }

    public String getErrores() {
        return errores;
    }

    public int getConteoErrores() {
        return conteoErrores;
    }

    public String getFrase() {
        return frase;
    }

    public boolean isFallo() {
        return fallo;
    }
}
