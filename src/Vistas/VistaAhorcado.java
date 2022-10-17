package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class VistaAhorcado extends JFrame{
    private JPanel jpContenidoGeneral;
    
    private JLabel lblAhorcado;
    private JLabel lblFondoAhorcado;
    private JLabel lblNombre;
    private JLabel lblIntentos;
    
    private final Icon[] imagenesLetrasActivas;
    private final Icon[] imagenesLetrasInactivas;
    private final Icon[] imagenesLetrasCorrectas;
    
    
    
    private final JLabel[] lblLetras;
    

    public VistaAhorcado() {
        this.imagenesLetrasActivas = new Icon[26];
        this.imagenesLetrasInactivas = new Icon[26];
        this.imagenesLetrasCorrectas = new Icon[26];
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
        configurarContenidoGeneral();
        
        asignacionImagenesALabels();
        
        llenarArrayIconosLetras("Activas");
        llenarArrayIconosLetras("Inactivas");
        llenarArrayIconosLetras("Correctas");
        
        asignarLabelsLetras();
        llenarArrayLabelsLetras();
        
        
        lblNombre = new JLabel();
        lblIntentos = new JLabel("0");
        
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("arial", Font.BOLD, 30));
        lblIntentos.setForeground(Color.WHITE);
        lblIntentos.setFont(new Font("arial", Font.BOLD, 30));
        
        /* Configuración imagenes */
        
        indicarPosicionLetras();
        
        posicionarElementos();
        
        ponerCursorActivoALetras();
        
        /* Se agregan labels al contenido general */
        
        colocarLetrasEnVista();
        agregarElementosAContenidoGeneral();
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
    
    public void llenarArrayIconosLetras(String tipoLetras){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0; i<letras.length() ; i++){
            if(null != tipoLetras)
                switch (tipoLetras) {
                case "Activas":
                    imagenesLetrasActivas[i] = cargarLetra("" + letras.charAt(i),tipoLetras);
                    break;
                case "Inactivas":
                    imagenesLetrasInactivas[i] = cargarLetra("" + letras.charAt(i), tipoLetras);
                    break;
                case "Correctas":
                    imagenesLetrasCorrectas[i] = cargarLetra("" + letras.charAt(i), tipoLetras);
                    break;
                default:
                    break;
            }
            
        }
        
    }
    
    public Icon cargarLetra(String letra, String tipoLetras){
        Icon imagenLetra = null;
        
        if(null != tipoLetras)
            switch (tipoLetras) {
            case "Activas" -> imagenLetra = new ImageIcon("src\\Imagenes\\LetrasActivas\\00-LetraActiva"+ letra +"-img.jpg");
            case "Inactivas" -> imagenLetra = new ImageIcon("src\\Imagenes\\LetrasInactivas\\00-LetraInactiva"+ letra +"-img.jpg");
            case "Correctas" -> imagenLetra = new ImageIcon("src\\Imagenes\\LetrasCorrectas\\00-LetraCorrecta"+ letra +"-img.jpg");
            default -> {
            }
        }
        
        
        return imagenLetra;
    }
    
   /* Listener de cada letra */
    
    public void addLblLetrasMouseListener(MouseAdapter listenControles){
        for (JLabel lblLetra : lblLetras) {
            lblLetra.addMouseListener(listenControles);
        }
    }
    
    public JLabel saberSiUnaLetraFuePresionada(JLabel letraPreguntada){
        
        JLabel letraResultante = null;
        for (JLabel lblLetra : lblLetras) {
            if(lblLetra == letraPreguntada){
                letraResultante = lblLetra;
            }
        }
        return letraResultante;
    }
    
    public char saberLetraPresionada(JLabel letraPreguntada){
        
        char letraPresionada = 'a';
        for (JLabel lblLetra : lblLetras) {
            if(lblLetra == letraPreguntada){
                letraPresionada = lblLetra.getIcon().toString().charAt(41);
            }
        }
        return letraPresionada;
    }
    
    public void ponerLetraInactiva(char letra){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0; i<letras.length() ; i++){
            if(letra == letras.charAt(i)){
                lblLetras[i].setIcon(imagenesLetrasInactivas[i]);
                lblLetras[i].setCursor(null);
            }
        }
    }
    
    public void ponerLetraCorrecta(char letra){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0; i<letras.length() ; i++){
            if(letra == letras.charAt(i)){
                lblLetras[i].setIcon(imagenesLetrasCorrectas[i]);
            }
        }
    }
    
    public void cambiarImagenAhorcadoError(int numero){
        Icon imagenAhorcadoNuevo = new ImageIcon("src\\Imagenes\\ImagenesAhorcado\\00-Ahorcado"+numero+"-img.gif");
        lblAhorcado.setIcon(imagenAhorcadoNuevo);
    }
    
    public void agregarLetraSeleccionada(int posicion, int sizePalabra, JLabel letraSeleccionada){
        int posicionInicial = 0;
        
        ponerLetraCorrecta(saberLetraPresionada(letraSeleccionada));
        switch (sizePalabra) {
            case 4 -> posicionInicial = 523;
            case 5 -> posicionInicial = 491;
            case 6 -> posicionInicial = 450;
            case 7 -> posicionInicial = 410;
            default -> {
            }
        }
        if(posicion == -1){
            System.out.println("Ignora la letra");
        }else{
            for(int i = 1; i<posicion + 1;i++){
            if(i == posicion){
                JLabel nuevaLetraSeleccion = new JLabel(letraSeleccionada.getIcon());
                nuevaLetraSeleccion.setBounds(posicionInicial, 126, 73, 73);
                jpContenidoGeneral.add(nuevaLetraSeleccion,10,10);
            }
            posicionInicial = posicionInicial + 83;
            }
        }
    }
    
    public void cambiarFondoSegunSizePalabra(int sizePalabra){
        Icon imagenFondo = new ImageIcon("src\\Imagenes\\Fondo\\00-FondoAhorcado"+sizePalabra+"-img.gif");
        lblFondoAhorcado.setIcon(imagenFondo);
    }
    
    
    
    public void asignarLabelsLetras(){
        lblLetraA = new JLabel(imagenesLetrasActivas[0]);
        lblLetraB = new JLabel(imagenesLetrasActivas[1]);
        lblLetraC = new JLabel(imagenesLetrasActivas[2]);
        lblLetraD = new JLabel(imagenesLetrasActivas[3]);
        lblLetraE = new JLabel(imagenesLetrasActivas[4]);
        lblLetraF = new JLabel(imagenesLetrasActivas[5]);
        lblLetraG = new JLabel(imagenesLetrasActivas[6]);
        lblLetraH = new JLabel(imagenesLetrasActivas[7]);
        lblLetraI = new JLabel(imagenesLetrasActivas[8]);
        lblLetraJ = new JLabel(imagenesLetrasActivas[9]);
        lblLetraK = new JLabel(imagenesLetrasActivas[10]);
        lblLetraL = new JLabel(imagenesLetrasActivas[11]);
        lblLetraM = new JLabel(imagenesLetrasActivas[12]);
        lblLetraN = new JLabel(imagenesLetrasActivas[13]);
        lblLetraO = new JLabel(imagenesLetrasActivas[14]);
        lblLetraP = new JLabel(imagenesLetrasActivas[15]);
        lblLetraQ = new JLabel(imagenesLetrasActivas[16]);
        lblLetraR = new JLabel(imagenesLetrasActivas[17]);
        lblLetraS = new JLabel(imagenesLetrasActivas[18]);
        lblLetraT = new JLabel(imagenesLetrasActivas[19]);
        lblLetraU = new JLabel(imagenesLetrasActivas[20]);
        lblLetraV = new JLabel(imagenesLetrasActivas[21]);
        lblLetraW = new JLabel(imagenesLetrasActivas[22]);
        lblLetraX = new JLabel(imagenesLetrasActivas[23]);
        lblLetraY = new JLabel(imagenesLetrasActivas[24]);
        lblLetraZ = new JLabel(imagenesLetrasActivas[25]);
        
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

    
    public void setNombre(String nuevoNombre){
        if(nuevoNombre.length() > 10){
            lblNombre.setText(nuevoNombre.substring(0,11));
        }else{
            lblNombre.setText(nuevoNombre);
        }
    }
    
    public void setIntentos(int numeroIntentos){
        lblIntentos.setText(String.valueOf(numeroIntentos));
    }
    
    
    /* Metodos repetitivos */
    
    public void asignacionImagenesALabels(){
        /* Cargado de imagenes */
        
        Icon imagenFondo = new ImageIcon("src\\Imagenes\\Fondo\\00-FondoAhorcado6-img.gif");
        Icon imagenAhorcado = new ImageIcon("src\\Imagenes\\ImagenesAhorcado\\00-Ahorcado1-img.gif");

        /* Inicializacion de imagenes */
        
        lblAhorcado = new JLabel(imagenAhorcado);
        lblFondoAhorcado = new JLabel(imagenFondo);
        
    }
    
    public void configurarContenidoGeneral(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
    }   
    
    public void posicionarElementos(){
        lblNombre.setBounds(560, 9 , 500, 50);
        lblIntentos.setBounds(930, 9 , 500, 50);
        lblAhorcado.setBounds(0, 0, 370, 640);
        lblFondoAhorcado.setBounds(0,0,1024,640);
    }
    
    public void agregarElementosAContenidoGeneral(){
        jpContenidoGeneral.add(lblIntentos);
        jpContenidoGeneral.add(lblNombre);
        jpContenidoGeneral.add(lblAhorcado);
        jpContenidoGeneral.add(lblFondoAhorcado);
    }
     
 
}
