/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author eDanivaro
 */
public class DatosOsos extends JDialog implements ActionListener{
    
    JLabel lblNombre, lblPoderes;
    JTextField txfNombre, txfPoder;
    JList<String> lstPoderes;
    DefaultListModel<String> listaModelo = new DefaultListModel<>();
    Timer crono;
    
    public DatosOsos(Formulario f) {
        super(f);
        this.setLayout(new FlowLayout());
        
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setSize(100, 30);
        this.add(lblNombre);
        
        txfNombre = new JTextField(12);
        txfNombre.setSize(100, 30);
        this.add(txfNombre);
        
        lblPoderes = new JLabel("Poderes: ");
        lblPoderes.setSize(100, 30);
        this.add(lblPoderes);
        
        txfPoder= new JTextField(12);
        txfPoder.setSize(100, 30);
        this.add(txfPoder);
        
        lstPoderes = new JList<>();
        lstPoderes.setSize(100, 30);
        lstPoderes.setToolTipText("Lista de poderes");
        
        listaModelo.addElement("Vomito");
        listaModelo.addElement("Vomito pegajoso");
        
        lstPoderes.setModel(listaModelo);
        lstPoderes.setSelectedIndex(0);
        this.add(lstPoderes);
        
        crono = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        crono.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    class AdaptadorRaton extends MouseAdapter{

        @Override
        public void mouseMoved(MouseEvent me) {
            crono.restart();
        }
        
    }
    
    class AdaptadorTeclado extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent ke) {
            crono.restart();
        }
        
    }
    
}
