/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author RYZEN
 */
public class VistaSeleccionarTema extends JFrame{
    
    private JLabel lblTema;
    private JLabel lblAnimales;
    private JLabel lblFrutas;
    private JLabel lblColores;
    private JLabel lblCerrar;
    private JLabel lblVolver;
    private JLabel lblIniciar;
    private JLabel lblIngresaNombre;
    
    private JTextField txtNombre;
    
    private JPanel jpContenidoGeneral;
    private JLayeredPane nuevoPane;
    
    private boolean animalesActivo = false;
    private boolean coloresActivo = false;
    private boolean frutasActivo = false;

    public VistaSeleccionarTema() {
    }
    
    public void configurarVistaTema(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesTema(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0, 0, 1024, 640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
        
        /* Cargado de imagenes */
        
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.gif");
        Icon imagenAnimales = new ImageIcon("src\\Imagenes\\05-Animales-img.gif");
        Icon imagenColores = new ImageIcon("src\\Imagenes\\07-Colores-img.gif");
        Icon imagenFrutas = new ImageIcon("src\\Imagenes\\09-Frutas-img.gif");
        //Icon imagenIniciar = new ImageIcon("src\\Imagenes\\11-Iniciar-img.gif");
        Icon imagenTema = new ImageIcon("src\\Imagenes\\12-SeleccionarTema-img.gif");
        Icon imagenVolver = new ImageIcon("src\\Imagenes\\13-Volver-img.gif");
        
        /* Inicializacion de imagenes */
        
        lblCerrar = new JLabel(imagenCerrar);
        lblVolver = new JLabel(imagenVolver);
        lblAnimales = new JLabel(imagenAnimales);
        lblColores = new JLabel(imagenColores);
        lblFrutas = new JLabel(imagenFrutas);
        lblTema = new JLabel(imagenTema);
        lblIngresaNombre = new JLabel();
        lblIniciar = new JLabel();
        
        txtNombre = new JTextField();
        
        /* Configuración imagenes */
        
        lblTema.setBounds(0,0,1024,640);
        lblAnimales.setBounds(280,400,240,80);
        lblColores.setBounds(520,400,240,80);
        lblFrutas.setBounds(760, 400, 240, 80);
        lblCerrar.setBounds(930,10,240,80);
        lblVolver.setBounds(-150,10,240,80);
        lblIngresaNombre.setBounds(30,530,240,80);
        lblIniciar.setBounds(760,530,240,80);
        
        
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAnimales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFrutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblColores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIngresaNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        /* Nombre */
        
        txtNombre.setBounds(410, 280, 470, 80);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setBorder(null);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 30)); 
        
        
        
        /* Se agregan labels al contenido general */
        
        jpContenidoGeneral.add(txtNombre);
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblVolver);
        jpContenidoGeneral.add(lblAnimales);
        jpContenidoGeneral.add(lblColores);
        jpContenidoGeneral.add(lblFrutas);
        jpContenidoGeneral.add(lblIngresaNombre); 
        jpContenidoGeneral.add(lblIniciar);  
        jpContenidoGeneral.add(lblTema);
            
    }
    
    /* Metodos que cambiar las imagenes de color */
    public void cambiarAnimalesActivo(){
        Icon imagenAnimalesActivo = new ImageIcon("src\\Imagenes\\06-AnimalesActivo-img.gif");
        lblAnimales.setIcon(imagenAnimalesActivo);
    }
    
    public void cambiarAnimalesInactivo(){
        Icon imagenAnimales = new ImageIcon("src\\Imagenes\\05-Animales-img.gif");
        lblAnimales.setIcon(imagenAnimales);
    }
    
    public void cambiarColoresActivo(){
        Icon imagenColoresActivo = new ImageIcon("src\\Imagenes\\08-ColoresActivo-img.gif");
        lblColores.setIcon(imagenColoresActivo);
    }
    
    public void cambiarColoresInactivo(){
        Icon imagenColores = new ImageIcon("src\\Imagenes\\07-Colores-img.gif");
        lblColores.setIcon(imagenColores);
    }
    
    public void cambiarFrutasActivo(){
        Icon imganFrutasActivo = new ImageIcon("src\\Imagenes\\10-FrutasActivo-img.gif");
        lblFrutas.setIcon(imganFrutasActivo);
    }
    
    public void cambiarFrutasInactivo(){
        Icon imagenFrutas = new ImageIcon("src\\Imagenes\\09-Frutas-img.gif");
        lblFrutas.setIcon(imagenFrutas);
    }
    
    public void agregarLblIniciar(){
        Icon imagenIniciar = new ImageIcon("src\\Imagenes\\11-Iniciar-img.gif");
        lblIniciar.setIcon(imagenIniciar);    
    }
    
    public void agregarLblIngresarNombre(){
        Icon imagenIngresaNombre = new ImageIcon("src\\Imagenes\\14-IngresaNombre-img.gif");
        lblIngresaNombre.setIcon(imagenIngresaNombre);  
    }
    
    public void eliminarLblIniciar(){
        lblIniciar.setIcon(null);
    }
    
    public void eliminarLblIngresarNombre(){
        lblIngresaNombre.setIcon(null);
    }
    
    public String getNombre(){
        return txtNombre.getText();
    }
    
    
    /* Metodos para añadir listeners */
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    public void addLblVolverMouseListener(MouseAdapter listenControles){
        lblVolver.addMouseListener(listenControles);
    }
    
    public void addLblAnimalesMouseListener(MouseAdapter listenControles){
        lblAnimales.addMouseListener(listenControles);
    }
    
    public void addLblFrutasMouseListener(MouseAdapter listenControles){
        lblFrutas.addMouseListener(listenControles);
    }
    
    public void addLblColoresMouseListener(MouseAdapter listenControles){
        lblColores.addMouseListener(listenControles);
    }
    
    public void addLblIniciarMouseListener(MouseAdapter listenControles){
        lblIniciar.addMouseListener(listenControles);
    }
    
    /* Getters and Setters */
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }

    public JLabel getLblVolver() {
        return lblVolver;
    }

    public JLabel getLblAnimales(){
        return lblAnimales;
    }
    
    public JLabel getLblColores(){
        return lblColores;
    }
    
    public JLabel getLblFrutas(){
        return lblFrutas;
    }
    
    public JLabel getLblIniciar(){
        return lblIniciar;
    }

    public boolean isAnimalesActivo() {
        return animalesActivo;
    }

    public boolean isColoresActivo() {
        return coloresActivo;
    }

    public boolean isFrutasActivo() {
        return frutasActivo;
    }

    public void setAnimalesActivo(boolean animalesActivo) {
        this.animalesActivo = animalesActivo;
    }

    public void setColoresActivo(boolean coloresActivo) {
        this.coloresActivo = coloresActivo;
    }

    public void setFrutasActivo(boolean frutasActivo) {
        this.frutasActivo = frutasActivo;
    }
    
    
    
    
}
