/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

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
public class VistaComoJugar extends JFrame{
    
    private JLabel lblPaso;
    private JLabel lblCerrar;
    private JLabel lblVolver;
    private JLabel lblSiguiente;
    
    private JPanel jpContenidoGeneral;

    public VistaComoJugar() {
    }
    
    public void configurarVistaComoJugar(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesComoJugar(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
        
        /* Cargado de imagenes */
        Icon imagenPaso = new ImageIcon("src\\Imagenes\\ComoJugar\\00-ComoJugar1-img.gif");
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.gif");
        Icon imagenVolver = new ImageIcon("src\\Imagenes\\13-Volver-img.gif");
        Icon imagenSiguiente = new ImageIcon("src\\Imagenes\\25-Siguiente-img.gif");
        
        lblPaso = new JLabel(imagenPaso);
        lblCerrar = new JLabel(imagenCerrar);
        lblVolver = new JLabel(imagenVolver);
        lblSiguiente = new JLabel(imagenSiguiente);
        
        
        /* Configuración imagenes */
        
        lblPaso.setBounds(0,0,1024,640);
        lblCerrar.setBounds(930,10,240,80);
        lblSiguiente.setBounds(930,430,240,80);
        lblVolver.setBounds(-150,10,240,80);
        
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        /* Se agregan labels al contenido general */
        
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblVolver);
        jpContenidoGeneral.add(lblSiguiente);
        jpContenidoGeneral.add(lblPaso);
        
        
    }
    
    /* Metodos para añadir listeners */
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    public void addLblVolverMouseListener(MouseAdapter listenControles){
        lblVolver.addMouseListener(listenControles);
    }
    
    public void addLblSiguienteMouseListener(MouseAdapter listenControles){
        lblSiguiente.addMouseListener(listenControles);
    }
    
    /* Getters and Setters */
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }

    public JLabel getLblVolver() {
        return lblVolver;
    }
    
    public JLabel getLblSiguiente(){
        return lblSiguiente;
    }
    
}
