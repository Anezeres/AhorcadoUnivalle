/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RYZEN
 */
public class VistaAhorcado extends JFrame{
    private JPanel jpContenidoGeneral;
    
    private JLabel lblAhorcado;
    private JLabel lblFondoAhorcado;
    
    private Icon[] imagenesLetras;

    public VistaAhorcado() {
        this.imagenesLetras = new Icon[26];
    }
    
    public void configurarVistaAhorcado(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesAhorcado(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0, 0, 1024, 640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
        
        /* Cargado de imagenes */
        
        Icon imagenFondo = new ImageIcon("src\\Imagenes\\24-FondoAhorcado-img.gif");
        Icon imagenAhorcado = new ImageIcon("src\\Imagenes\\ImagenesAhorcado\\15-Ahorcado1-img.gif");
        
        llenarArrayIconosLetra();
        
        /* Inicializacion de imagenes */
        
        asignarLabelsLetras();
        
        lblAhorcado = new JLabel(imagenAhorcado);
        lblFondoAhorcado = new JLabel(imagenFondo);
        
        /* Configuración imagenes */
        
        indicarPosicionLetras();
        
        lblAhorcado.setBounds(0, 0, 370, 640);
        lblFondoAhorcado.setBounds(0,0,1024,640);
        
        /* Se agregan labels al contenido general */
        
        colocarLetrasEnVista();
        jpContenidoGeneral.add(lblAhorcado);
        jpContenidoGeneral.add(lblFondoAhorcado);
    }
    
    public void asignarLabelsLetras(){
        lblLetraA = new JLabel(imagenesLetras[0]);
        lblLetraB = new JLabel(imagenesLetras[1]);
        lblLetraC = new JLabel(imagenesLetras[2]);
        lblLetraD = new JLabel(imagenesLetras[3]);
        lblLetraE = new JLabel(imagenesLetras[4]);
        lblLetraF = new JLabel(imagenesLetras[5]);
        lblLetraG = new JLabel(imagenesLetras[6]);
        lblLetraH = new JLabel(imagenesLetras[7]);
        lblLetraI = new JLabel(imagenesLetras[8]);
        lblLetraJ = new JLabel(imagenesLetras[9]);
        lblLetraK = new JLabel(imagenesLetras[10]);
        lblLetraL = new JLabel(imagenesLetras[11]);
        lblLetraM = new JLabel(imagenesLetras[12]);
        lblLetraN = new JLabel(imagenesLetras[13]);
        lblLetraO = new JLabel(imagenesLetras[14]);
        lblLetraP = new JLabel(imagenesLetras[15]);
        lblLetraQ = new JLabel(imagenesLetras[16]);
        lblLetraR = new JLabel(imagenesLetras[17]);
        lblLetraS = new JLabel(imagenesLetras[18]);
        lblLetraT = new JLabel(imagenesLetras[19]);
        lblLetraU = new JLabel(imagenesLetras[20]);
        lblLetraV = new JLabel(imagenesLetras[21]);
        lblLetraW = new JLabel(imagenesLetras[22]);
        lblLetraX = new JLabel(imagenesLetras[23]);
        lblLetraY = new JLabel(imagenesLetras[24]);
        lblLetraZ = new JLabel(imagenesLetras[25]);
        
    }
    
    public void indicarPosicionLetras(){
        lblLetraA.setBounds(410,270,73,73);
        lblLetraB.setBounds(493,270,73,73);
        lblLetraC.setBounds(576,270,73,73);
        lblLetraD.setBounds(659,270,73,73);
        lblLetraE.setBounds(742,270,73,73);
        lblLetraF.setBounds(825,270,73,73);
        lblLetraG.setBounds(908,270,73,73);
    }
    
    public void colocarLetrasEnVista(){
        jpContenidoGeneral.add(lblLetraA);
        jpContenidoGeneral.add(lblLetraB);
        jpContenidoGeneral.add(lblLetraC);
        jpContenidoGeneral.add(lblLetraD);
        jpContenidoGeneral.add(lblLetraE);
        jpContenidoGeneral.add(lblLetraF);
        jpContenidoGeneral.add(lblLetraG);
    }
    
    public void llenarArrayIconosLetra(){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0; i<letras.length() ; i++){
            imagenesLetras[i] = cargarLetra("" + letras.charAt(i));
        }
        
    }
    
    public Icon cargarLetra(String letra){
        Icon imagenLetra = new ImageIcon("src\\Imagenes\\LetrasActivas\\00-LetraActiva"+ letra +"-img.jpg");
        return imagenLetra;
    }
    
    
    private JLabel lblLetraA;
    private JLabel lblLetraB;
    private JLabel lblLetraC;
    private JLabel lblLetraD;
    private JLabel lblLetraE;
    private JLabel lblLetraF;
    private JLabel lblLetraG;
    private JLabel lblLetraH;
    private JLabel lblLetraI;
    private JLabel lblLetraJ;
    private JLabel lblLetraK;
    private JLabel lblLetraL;
    private JLabel lblLetraM;
    private JLabel lblLetraN;
    private JLabel lblLetraO;
    private JLabel lblLetraP;
    private JLabel lblLetraQ;
    private JLabel lblLetraR;
    private JLabel lblLetraS;
    private JLabel lblLetraT;
    private JLabel lblLetraU;
    private JLabel lblLetraV;
    private JLabel lblLetraW;
    private JLabel lblLetraX;
    private JLabel lblLetraY;
    private JLabel lblLetraZ;
     
 
}
