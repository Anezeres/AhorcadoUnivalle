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
    
    private JLabel lblFondoAhorcado;

    public VistaAhorcado() {
    }
    
    public void configurarVistaAhorcado(){
        setVisible(true);
        setUndecorated(true);
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
        
        /* Inicializacion de imagenes */
        
        lblFondoAhorcado = new JLabel(imagenFondo);
        
        /* Configuración imagenes */
        
        lblFondoAhorcado.setBounds(0,0,1024,640);
        
        /* Se agregan labels al contenido general */
        
        jpContenidoGeneral.add(lblFondoAhorcado);
    }
    
    
    
    
    
    
}
