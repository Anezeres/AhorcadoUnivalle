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
    
    private final Icon[] imagenesLetras;
    private final JLabel[] lblLetras;

    public VistaAhorcado() {
        this.imagenesLetras = new Icon[26];
        this.lblLetras = new JLabel[26];
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
        llenarArrayLabelsLetras();
        
        lblAhorcado = new JLabel(imagenAhorcado);
        lblFondoAhorcado = new JLabel(imagenFondo);
        
        /* Configuración imagenes */
        
        indicarPosicionLetras();
        
        lblAhorcado.setBounds(0, 0, 370, 640);
        lblFondoAhorcado.setBounds(0,0,1024,640);
        
        ponerCursorActivoALetras();
        
        /* Se agregan labels al contenido general */
        
        colocarLetrasEnVista();
        jpContenidoGeneral.add(lblAhorcado);
        jpContenidoGeneral.add(lblFondoAhorcado);
    }
    
    public void indicarPosicionLetras(){
        
        /* Primeras 7 letras */
        realizarBuclePosicionamiento(410, 0, 7, 270);
        
        /* Segundas 7 letras */
        realizarBuclePosicionamiento(410, 7, 14,355);
        
        /* Terceras 7 letras */
        realizarBuclePosicionamiento(410, 14, 21,438);
        
        /* Ultimas 5 letras */
        realizarBuclePosicionamiento(483, 21, 26,524);
        
    }
    
    public void realizarBuclePosicionamiento(int posicionInicial, int letraInicial, int letraFinal, int altura){
        for(int i = letraInicial; i<letraFinal;i++){
            lblLetras[i].setBounds(posicionInicial, altura, 73, 73);
            posicionInicial = posicionInicial + 83;
        }
    }
    
    public void ponerCursorActivoALetras(){
        
        for (JLabel lblLetra : lblLetras) {
            lblLetra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        
    }
    
    public void colocarLetrasEnVista(){
        for (JLabel lblLetra : lblLetras) {
            jpContenidoGeneral.add(lblLetra);
        }
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
    
    public void llenarArrayLabelsLetras(){
        lblLetras[0] = lblLetraA;
        lblLetras[1] = lblLetraB;
        lblLetras[2] = lblLetraC;
        lblLetras[3] = lblLetraD;
        lblLetras[4] = lblLetraE;
        lblLetras[5] = lblLetraF;
        lblLetras[6] = lblLetraG;
        lblLetras[7] = lblLetraH;
        lblLetras[8] = lblLetraI;
        lblLetras[9] = lblLetraJ;
        lblLetras[10] = lblLetraK;
        lblLetras[11] = lblLetraL;
        lblLetras[12] = lblLetraM;
        lblLetras[13] = lblLetraN;
        lblLetras[14] = lblLetraO;
        lblLetras[15] = lblLetraP;
        lblLetras[16] = lblLetraQ;
        lblLetras[17] = lblLetraR;
        lblLetras[18] = lblLetraS;
        lblLetras[19] = lblLetraT;
        lblLetras[20] = lblLetraU;
        lblLetras[21] = lblLetraV;
        lblLetras[22] = lblLetraW;
        lblLetras[23] = lblLetraX;
        lblLetras[24] = lblLetraY;
        lblLetras[25] = lblLetraZ;
   
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
