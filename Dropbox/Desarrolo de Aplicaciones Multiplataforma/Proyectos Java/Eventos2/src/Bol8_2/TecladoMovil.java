/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bol8_2;

import Bol8_1.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author danivaro
 */
public class TecladoMovil extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

    JMenuBar barraMenu;
    JMenu archivo;
    JMenu movil;
    JMenu otros;

    JMenuItem itemGrabar;
    JMenuItem itemLeer;

    JMenuItem reset;
    JMenuItem salir;

    JMenuItem itemAcerca;

    JButton boton;
    JButton butReset;

    JButton botones[][] = new JButton[3][4];

    JTextField lblNumero;

    Color pulsado;
    Color sinPulsar;

    public TecladoMovil() {
        super();
        this.setTitle("Movil");
        this.addMouseMotionListener(this);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        addKeyListener(this);

        itemGrabar = new JMenuItem("Grabar números");
        itemGrabar.addActionListener(this);
        itemLeer = new JMenuItem("Leer números");
        itemLeer.addActionListener(this);
        reset = new JMenuItem("Reset");
        reset.addActionListener(this);
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        itemAcerca = new JMenuItem("Acerca de...");
        itemAcerca.addActionListener(this);

        archivo = new JMenu("Archivo");
        archivo.setMnemonic('A');
        movil = new JMenu("Movil");
        movil.setMnemonic('M');
        otros = new JMenu("Otros");
        otros.setMnemonic('O');

        barraMenu = new JMenuBar();
        barraMenu.setVisible(true);
        this.add(barraMenu);

        archivo.add(itemGrabar);
        archivo.add(itemLeer);
        movil.add(reset);
        movil.addSeparator();
        movil.add(salir);
        otros.add(itemAcerca);

        barraMenu.add(archivo);
        barraMenu.add(movil);
        barraMenu.add(otros);

        String almohadilla = "#";
        String cero = "0";
        String asterisco = "*";
        int cont = 0;

        boton = new JButton();
        boton.addMouseListener(this);

        for (int i = 0; i < botones.length; i++) {
            String nombreBoton = "boton" + i;
            int alto = 20;
            int ancho = 10;
            int separacion = 20;
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JButton();
                cont++;
                botones[i][j].setText("" + cont);
                botones[i][j].setSize(80, 80);
                if (cont > 9) {
                    switch (j) {
                        case 1:
                            botones[i][j].setText("#");
                            break;
                        case 2:
                            botones[i][j].setText("0");
                            break;
                        case 3:
                            botones[i][j].setText("*");
                            break;
                    }
//                botones[i][j].setSize(ancho,alto);
//                botones[i][j].setLocation(ancho+separacion, alto);
                }
                botones[i][j].addMouseListener(this);
                botones[i][j].setName(String.format("%s", cont));
                botones[i][j].addKeyListener(this);
                this.add(botones[i][j]);
            }
        }

        lblNumero = new JTextField(12);
        lblNumero.setEditable(false);
        this.add(lblNumero);

        butReset = new JButton();
        butReset.setText("Reset");
        butReset.addActionListener(this);
        this.add(butReset);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butReset) {
            lblNumero.setText("");
            if (ae.getSource().getClass() == JButton.class) {
                for (int i = 0; i <= botones.length; i++) {
                    for (int j = 0; j <= botones.length; j++) {
                        botones[i][j].setForeground(null);
                        botones[i][j].setFocusable(true);
                    }
                }
            }
        }
        if (ae.getSource() == itemGrabar) {
            JFileChooser seleccion = new JFileChooser("Grabar archivo");
            seleccion.setAcceptAllFileFilterUsed(false);
            seleccion.addChoosableFileFilter(new FileNameExtensionFilter("txt", "txt"));
            int escoge = seleccion.showSaveDialog(this);
            if (escoge == 1) {
                try {
                    FileReader file = new FileReader("");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TecladoMovil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (ae.getSource() == itemLeer) {
            JFileChooser seleccion = new JFileChooser("Abrir archivo");
            seleccion.setAcceptAllFileFilterUsed(false);
            seleccion.addChoosableFileFilter(new FileNameExtensionFilter("txt", "txt"));
            int escoge = seleccion.showOpenDialog(this);
            if (escoge == 1) {
                seleccion.getSelectedFile();
                try {
                    FileReader file = new FileReader("");

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TecladoMovil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (ae.getSource() == itemAcerca) {
            JOptionPane.showMessageDialog(null, "Versión Agenda 1.0", "Información", JOptionPane.DEFAULT_OPTION);
        }
        if (ae.getSource() == reset) {
            lblNumero.setText("");
            if (ae.getSource().getClass() == JButton.class) {
                for (int i = 0; i <= botones.length; i++) {
                    for (int j = 0; j <= botones.length; j++) {
                        botones[i][j].setForeground(null);
                        botones[i][j].setFocusable(true);
                    }
                }
            }
        }
        if (ae.getSource() == salir) {
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource().getClass() == JButton.class) {
            me.getComponent().setForeground(Color.green);
            me.getComponent().setFocusable(false);
            lblNumero.setText(lblNumero.getText() + me.getComponent().getName());
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        me.getComponent().setForeground(null);

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource().getClass() == JButton.class) {
            me.getComponent().setForeground(Color.blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource().getClass() == JButton.class) {
            if (me.getComponent().isFocusable()) {
                me.getComponent().setForeground(null);
            } else {
                me.getComponent().setForeground(Color.green);
            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        System.err.println("");
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if (me.getSource().getClass() == JButton.class) {
            me.getComponent().setForeground(Color.blue);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        try {
            int numero = Integer.parseInt(String.format("%c", ke.getKeyChar()));
            lblNumero.setText(lblNumero.getText() + numero);
            System.err.println("Número"+numero);
        } catch (NumberFormatException numberFormatException) {
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getComponent().getClass() == JButton.class) {

        }
    }

}
