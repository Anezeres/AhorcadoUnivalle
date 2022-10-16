/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author RYZEN
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
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0, 0, 1024, 640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
        
        /* Cargado de imagenes */
        
        Icon imagenFondo = new ImageIcon("src\\Imagenes\\Fondo\\00-FondoAhorcado6-img.gif");
        Icon imagenAhorcado = new ImageIcon("src\\Imagenes\\ImagenesAhorcado\\00-Ahorcado1-img.gif");
        
        llenarArrayIconosLetras("Activas");
        llenarArrayIconosLetras("Inactivas");
        llenarArrayIconosLetras("Correctas");
        
        /* Inicializacion de imagenes */
        
        asignarLabelsLetras();
        llenarArrayLabelsLetras();
        
        lblAhorcado = new JLabel(imagenAhorcado);
        lblFondoAhorcado = new JLabel(imagenFondo);
        lblNombre = new JLabel("01234567891");
        lblIntentos = new JLabel("0");
        
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("arial", Font.BOLD, 30));
        lblIntentos.setForeground(Color.WHITE);
        lblIntentos.setFont(new Font("arial", Font.BOLD, 30));
        
        /* Configuración imagenes */
        
        indicarPosicionLetras();
        
        lblNombre.setBounds(560, 9 , 500, 50);
        lblIntentos.setBounds(930, 9 , 500, 50);
        lblAhorcado.setBounds(0, 0, 370, 640);
        lblFondoAhorcado.setBounds(0,0,1024,640);
        
        ponerCursorActivoALetras();
        
        /* Se agregan labels al contenido general */
        
        colocarLetrasEnVista();
        jpContenidoGeneral.add(lblIntentos);
        jpContenidoGeneral.add(lblNombre);
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
        for(int i = 1; i<posicion + 1;i++){
            if(i == posicion){
                letraSeleccionada.setBounds(posicionInicial, 126, 73, 73);
            }
            posicionInicial = posicionInicial + 83;
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
    
    private boolean AActivo = false;
    private boolean BActivo = false;
    private boolean CActivo = false;
    private boolean DActivo = false;
    private boolean EActivo = false;
    private boolean FActivo = false;
    private boolean GActivo = false;
    private boolean HActivo = false;
    private boolean IActivo = false;
    private boolean JActivo = false;
    private boolean KActivo = false;
    private boolean LActivo = false;
    private boolean MActivo = false;
    private boolean NActivo = false;
    private boolean OActivo = false;
    private boolean PActivo = false;
    private boolean QActivo = false;
    private boolean RActivo = false;
    private boolean SActivo = false;
    private boolean TActivo = false;
    private boolean UActivo = false;
    private boolean VActivo = false;
    private boolean WActivo = false;
    private boolean XActivo = false;
    private boolean YActivo = false;
    private boolean ZActivo = false;

    public boolean isAActivo() {
        return AActivo;
    }

    public void setAActivo(boolean AActivo) {
        this.AActivo = AActivo;
    }

    public boolean isBActivo() {
        return BActivo;
    }

    public void setBActivo(boolean BActivo) {
        this.BActivo = BActivo;
    }

    public boolean isCActivo() {
        return CActivo;
    }

    public void setCActivo(boolean CActivo) {
        this.CActivo = CActivo;
    }

    public boolean isDActivo() {
        return DActivo;
    }

    public void setDActivo(boolean DActivo) {
        this.DActivo = DActivo;
    }

    public boolean isEActivo() {
        return EActivo;
    }

    public void setEActivo(boolean EActivo) {
        this.EActivo = EActivo;
    }

    public boolean isFActivo() {
        return FActivo;
    }

    public void setFActivo(boolean FActivo) {
        this.FActivo = FActivo;
    }

    public boolean isGActivo() {
        return GActivo;
    }

    public void setGActivo(boolean GActivo) {
        this.GActivo = GActivo;
    }

    public boolean isHActivo() {
        return HActivo;
    }

    public void setHActivo(boolean HActivo) {
        this.HActivo = HActivo;
    }

    public boolean isIActivo() {
        return IActivo;
    }

    public void setIActivo(boolean IActivo) {
        this.IActivo = IActivo;
    }

    public boolean isJActivo() {
        return JActivo;
    }

    public void setJActivo(boolean JActivo) {
        this.JActivo = JActivo;
    }

    public boolean isKActivo() {
        return KActivo;
    }

    public void setKActivo(boolean KActivo) {
        this.KActivo = KActivo;
    }

    public boolean isLActivo() {
        return LActivo;
    }

    public void setLActivo(boolean LActivo) {
        this.LActivo = LActivo;
    }

    public boolean isMActivo() {
        return MActivo;
    }

    public void setMActivo(boolean MActivo) {
        this.MActivo = MActivo;
    }

    public boolean isNActivo() {
        return NActivo;
    }

    public void setNActivo(boolean NActivo) {
        this.NActivo = NActivo;
    }

    public boolean isOActivo() {
        return OActivo;
    }

    public void setOActivo(boolean OActivo) {
        this.OActivo = OActivo;
    }

    public boolean isPActivo() {
        return PActivo;
    }

    public void setPActivo(boolean PActivo) {
        this.PActivo = PActivo;
    }

    public boolean isQActivo() {
        return QActivo;
    }

    public void setQActivo(boolean QActivo) {
        this.QActivo = QActivo;
    }

    public boolean isRActivo() {
        return RActivo;
    }

    public void setRActivo(boolean RActivo) {
        this.RActivo = RActivo;
    }

    public boolean isSActivo() {
        return SActivo;
    }

    public void setSActivo(boolean SActivo) {
        this.SActivo = SActivo;
    }

    public boolean isTActivo() {
        return TActivo;
    }

    public void setTActivo(boolean TActivo) {
        this.TActivo = TActivo;
    }

    public boolean isUActivo() {
        return UActivo;
    }

    public void setUActivo(boolean UActivo) {
        this.UActivo = UActivo;
    }

    public boolean isVActivo() {
        return VActivo;
    }

    public void setVActivo(boolean VActivo) {
        this.VActivo = VActivo;
    }

    public boolean isWActivo() {
        return WActivo;
    }

    public void setWActivo(boolean WActivo) {
        this.WActivo = WActivo;
    }

    public boolean isXActivo() {
        return XActivo;
    }

    public void setXActivo(boolean XActivo) {
        this.XActivo = XActivo;
    }

    public boolean isYActivo() {
        return YActivo;
    }

    public void setYActivo(boolean YActivo) {
        this.YActivo = YActivo;
    }

    public boolean isZActivo() {
        return ZActivo;
    }

    public void setZActivo(boolean ZActivo) {
        this.ZActivo = ZActivo;
    }
    
    
     
 
}
