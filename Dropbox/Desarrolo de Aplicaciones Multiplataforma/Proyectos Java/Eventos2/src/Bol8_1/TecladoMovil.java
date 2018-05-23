/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bol8_1;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author danivaro
 */
public class TecladoMovil extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

    JMenuBar barraMenu;
    JMenu archivo;
    JMenu itemMovil;
    JMenuItem itemGrabar;
    JMenuItem itemLeer;

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

       itemGrabar = new JMenuItem("Grabar números");
      itemLeer = new JMenuItem("Leer números");

        JMenuItem reset = new JMenuItem();
        JMenuItem salir = new JMenu();
        
        itemArchivo = new JMenu("Archivo");
        itemMovil = new JMenu("Movil");
        
        barraMenu = new JMenuBar();
        barraMenu.setVisible(true);
        this.add(barraMenu);
        
        

        itemArchivo.add(itemGrabar);
        itemArchivo.add(itemLeer);
        itemMovil.add(reset);
        itemMovil.addSeparator();
        itemMovil.add(salir);
        barraMenu.add(itemArchivo);

        String almohadilla = "#";
        String cero = "0";
        String asterisco = "*";
        int cont = 0;

        boton = new JButton();
        boton.addMouseListener(this);

        lblNumero = new JTextField();
        this.add(lblNumero);

        for (int i = 0; i < botones.length; i++) {
            String nombreBoton = "boton" + i;
            int alto = 20;
            int ancho = 10;
            int separacion = 20;
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JButton();
                cont++;
                botones[i][j].setText("" + cont);
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
                this.add(botones[i][j]);
            }
        }

        lblNumero = new JTextField(9);
        this.add(lblNumero);

        butReset = new JButton();
        butReset.setText("Reset");
        butReset.addActionListener(this);
        this.add(reset);

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
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource().getClass() == JButton.class) {
            me.getComponent().setForeground(Color.green);
            me.getComponent().setFocusable(false);
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
        System.err.println("Me muevo...");
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        try {
            int numero = Integer.parseInt(String.format("%c", ke.getKeyChar()));
            lblNumero.setText(lblNumero.getText() + numero);
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
