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
    
    private String nombre;
    private Ronda frases;

    private String frase, errores;
    private String clave;
    private int conteoErrores;
    private int numeroIntentos;
    private int porcentaje;
    public boolean fallo, ganar;


    public Jugador() {
        frases = new Ronda();
        numeroIntentos = 10;
        clave = "";

    }

    public void reemplazarLetra(int index, char letra) {
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

    public void porcentaje(){
        porcentaje = conteoErrores * 10;
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
    
    public void sumarConteoErrores() {
        conteoErrores++;
    }

    public String getFrase() {
        return frase;
    }

    public boolean isFallo() {
        return fallo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
    
    public void setNombre(String nombreNuevo){
        nombre = nombreNuevo;
    }
    
    public String getNombre(){
        return nombre;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void restarNumeroIntentos() {
        numeroIntentos--;
    }
    
    
    
    
}
