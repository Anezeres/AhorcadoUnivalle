/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    private JPanel jpContenidoGeneral;

    public VistaLogin() {
    }
    
    public void configurarVistaLogin(){
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
        
        /* Inicializacion de imagenes */
        
        lblTitle = new JLabel(imagenTitlePrincipal);
        lblComoJugar = new JLabel(imagenComoJugar);
        lblJugar = new JLabel(imagenJugar);
        lblBeneficios = new JLabel(imagenBeneficios);
        
        
        /* Configuración imagenes */
        
        
        lblTitle.setBounds(0,0,1024,640);
        lblComoJugar.setBounds(30,400,240,80);
        lblJugar.setBounds(280,400,240,80);
        lblBeneficios.setBounds(530,400,240,80);

        
        /* Se agregan labels al contenido general */
        
        jpContenidoGeneral.add(lblComoJugar);
        jpContenidoGeneral.add(lblJugar);
        jpContenidoGeneral.add(lblBeneficios);
        jpContenidoGeneral.add(lblTitle);
        
    }
    
    //1024,640
    
    public class ManejadorEventosLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    
    }
}


