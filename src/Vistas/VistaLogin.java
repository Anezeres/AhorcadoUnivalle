/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RYZEN
 */
public class VistaLogin extends JFrame{
    
    private Container containerLogin;
    
    private JLabel lblTitle;
    private JLabel lblComoJugar;
    private JLabel lblJugar;
    private JLabel lblBeneficios;
    private JLabel lblCerrar;
    
    private JPanel jpContenidoGeneral;

    public VistaLogin() {
    }
    
    public void configurarVistaLogin(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ahorcado 3000");      
    }
    
    public void iniciarComponentes(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
        
        /* Cargado de imagenes */
        Icon imagenTitlePrincipal = new ImageIcon("src\\Imagenes\\00-Ahorcado3000-img.gif");
        Icon imagenComoJugar = new ImageIcon("src\\Imagenes\\01-ComoJugar-img.gif");
        Icon imagenJugar = new ImageIcon("src\\Imagenes\\02-Jugar-img.gif");
        Icon imagenBeneficios = new ImageIcon("src\\Imagenes\\03-Beneficios-img.gif");
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.gif");
        
        /* Inicializacion de imagenes */
        
        lblTitle = new JLabel(imagenTitlePrincipal);
        lblComoJugar = new JLabel(imagenComoJugar);
        lblJugar = new JLabel(imagenJugar);
        lblBeneficios = new JLabel(imagenBeneficios);
        lblCerrar = new JLabel(imagenCerrar);
        
        
        /* Configuración imagenes */
        
        
        lblTitle.setBounds(0,0,1024,640);
        lblComoJugar.setBounds(30,450,240,80);
        lblJugar.setBounds(280,450,240,80);
        lblBeneficios.setBounds(530,450,240,80);
        lblCerrar.setBounds(930,10,240,80);
        
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBeneficios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblComoJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        /* Se agregan labels al contenido general */
        
        jpContenidoGeneral.add(lblComoJugar);
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblJugar);
        jpContenidoGeneral.add(lblBeneficios);
        jpContenidoGeneral.add(lblTitle);

    }
    
    public void addLblJugarMouseListener(MouseAdapter listenControles){
        lblJugar.addMouseListener(listenControles);
    }
    
    public void addLblBeneficiosMouseListener(MouseAdapter listenControles){
        lblBeneficios.addMouseListener(listenControles);
    }
    
    public void addLblComoJugarMouseListener(MouseAdapter listenControles){
        lblComoJugar.addMouseListener(listenControles);
    }
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }
    
}


