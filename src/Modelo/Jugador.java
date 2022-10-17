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
    private int partidasJugadas;
    private int partidasPerdidas;
    private int partidasGanadas;
    private double porcentajeGanadas;
    private double porcentajePerdidas;
    private int porcentaje;
    public boolean fallo, ganar;


    public Jugador() {
        frases = new Ronda();
        numeroIntentos = 10;

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
    
    

    public void porcentajeGanadas(){
        porcentajeGanadas =((partidasGanadas/partidasJugadas)*100 );
    }
    
    public void porcentajePerdidas(){
        porcentajePerdidas = ((partidasPerdidas/partidasJugadas)*100 );
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
    
    public void setConteoErrores(int inicio) {
        conteoErrores = inicio;
    }
    
    public void reiniciarErrores(){
        conteoErrores = 0;
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
    
    public void reiniciarNumeroIntentos() {
        numeroIntentos = 10;
    }

    public void restarNumeroIntentos() {
        numeroIntentos--;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public double getPorcentajeGanadas() {
        porcentajeGanadas();
        return porcentajeGanadas;
    }


    public double getPorcentajePerdidas() {
        porcentajePerdidas();
        return porcentajePerdidas;
    }

    
    

    @Override
    public String toString() {
        return "\nPorcentaje Ganadas: " + getPorcentajeGanadas() +" \nPorcentaje perdidas: "+ getPorcentajePerdidas() + "Jugador{" + "partidasJugadas=" + partidasJugadas + ","
                + " \npartidasPerdidas=" + partidasPerdidas + ","
                + " \npartidasGanadas=" + partidasGanadas + '}';
        
    }
    
    
    
    
    
    
    
}
