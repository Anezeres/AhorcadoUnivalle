/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
import java.util.concurrent.ThreadLocalRandom;
import java.util.Stack;
import java.util.Scanner;
public class Ronda {
    //Array de colores    
    String[] colores={"gris", "azul", "cian", "cafe", "violeta", "crema", "negro", "lacre", "blanco","rosa"};
    //Array de animales
    String[] animales={"gato", "foca", "leon", "asno", "gorila", "tigre", "atun", "ganso", "erizo", "canguro"};
    //Array de frutas
    String[] frutas={"melon", "pomelo", "nispero", "mora", "limon", "durazno", "fresa", "mango", "higo", "pera"};
  //Atributos
    //Jugador partidasJugadas;
    int numeroPartidas;
    int palabrasAdivinadas;
    String temaPartidas;
    String palabraActual;
    int rondasJugadas; 
    String temaRonda;
    int posicionDeLetra;
  
  public Ronda() {
    //partidasJugadas = new Jugador();
  }
  
  static Scanner sc = new Scanner(System.in);
  //El usuario selecciona el tipo de ronda que quiere jugar
/*
  
  public int setNumeroPartidas(){
    System.out.println("Digite la cantidad de partidas que desea jugar(máximo 10)");
    int numeroPartidas = Integer.parseInt(sc.nextLine());
    return numeroPartidas;
  }
/*
  public String setTemaPartidas(){
    System.out.println("Digite el tema de la partida: colores, animales,o frutas");
    String temaPartidas = sc.nextLine();
    return temaPartidas;
  }
*/
  
  public String seleccionPalabra() {
    int i = 0;
    if (numeroPartidas>=1 && numeroPartidas<=10){
      if(temaRonda.equals("Colores")){
        int pos;
        int nAleatorio = 10;
        Stack < Integer > pAleatorio = new Stack < Integer > ();
        
        
        for (i = 0; i < nAleatorio ; i++) {
          pos = (int) Math.floor(Math.random() * nAleatorio );
          while (pAleatorio.contains(pos)) {
            pos = (int) Math.floor(Math.random() * nAleatorio );
          }
          pAleatorio.push(pos);
        }    
          int a = pAleatorio.pop();
          palabraActual = colores[a];
          System.out.printf("El color es: %s\n",palabraActual);  
          
          
      }else if(temaRonda.equals("Animales")){
        int pos;
        int nAleatorio = 10;
        Stack < Integer > pAleatorio = new Stack < Integer > ();
        
        
        for (i = 0; i < nAleatorio ; i++) {
          pos = (int) Math.floor(Math.random() * nAleatorio );
          while (pAleatorio.contains(pos)) {
            pos = (int) Math.floor(Math.random() * nAleatorio );
          }
          pAleatorio.push(pos);
        }    
          int a = pAleatorio.pop();
          palabraActual = animales[a];
          System.out.printf("El animal es: %s\n",palabraActual);  
      }else if(temaRonda.equals("Frutas")){
        int pos;
        int nAleatorio = 10;
        Stack < Integer > pAleatorio = new Stack < Integer > ();
        
        for (i = 0; i < nAleatorio ; i++) {
          pos = (int) Math.floor(Math.random() * nAleatorio );
          
          while (pAleatorio.contains(pos)) {
            pos = (int) Math.floor(Math.random() * nAleatorio );
          }
          pAleatorio.push(pos);
                        }    
          int a = pAleatorio.pop();
          palabraActual = frutas[a];
          System.out.printf("La fruta es: %s\n",palabraActual);
      }
    }else{
      System.out.println("Error, digite un número del 1 al 10");
    }
    return palabraActual;
  }

  public String getFraseActual() {
    return palabraActual;
  }

    public String getTemaRonda() {
        return temaRonda;
    }

    public void setTemaRonda(String temaRonda) {
        this.temaRonda = temaRonda;
    }

    public int getNumeroPartidas() {
        return numeroPartidas;
    }

    public void setNumeroPartidas(int numeroPartidas) {
        this.numeroPartidas = numeroPartidas;
    }
    
    public int getSizePalabraActual(){
        return palabraActual.length();
    }

    public int getPosicionDeLetra() {
        return posicionDeLetra;
    }

    public void setPosicionDeLetra(int posicionDeLetra) {
        this.posicionDeLetra = posicionDeLetra;
    }
    
    
    
    
    
    
    
  
  

}
