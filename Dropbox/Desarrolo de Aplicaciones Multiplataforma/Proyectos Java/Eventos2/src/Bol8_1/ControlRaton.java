package Bol8_1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author danivaro
 */
public class ControlRaton extends JFrame implements ActionListener, ItemListener, KeyListener, MouseListener, MouseMotionListener {
    
    JButton botonIzquierdo;
    JButton botonDerecho;
    
    JLabel lblTeclas;
    
    JFrame fSecundario;
    
    JComboBox combo;
    
    Color color = Color.red;
    
    VentanaColor secundario;
    
    boolean cambiarTitulo;
    
    VentanaColor ventanaColor;
    
    public ControlRaton() {
        super();
        this.setLayout(null);
        this.setTitle("Control de Ratón");
        this.setFocusable(true);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Deseas cerrar el programa?", "Eventos Teclado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.OK_OPTION) {
                    e.getWindow().dispose();
                }
            }
        });
        
        botonIzquierdo = new JButton("Izquierdo");
        botonIzquierdo.setSize(100, 20);
        botonIzquierdo.setLocation(128, 50);
        botonIzquierdo.addActionListener(this);
        botonIzquierdo.addItemListener(this);
        botonIzquierdo.addMouseListener(this);
        botonIzquierdo.addMouseMotionListener(this);
        this.add(botonIzquierdo);
        
        botonDerecho = new JButton("Derecho");
        botonDerecho.setSize(100, 20);
        botonDerecho.setLocation(248, 50);
        botonDerecho.addActionListener(this);
        botonDerecho.addItemListener(this);
        botonDerecho.addMouseListener(this);
        botonDerecho.addMouseMotionListener(this);
        this.add(botonDerecho);
        
        lblTeclas = new JLabel("HOLA");
        lblTeclas.setText("Tecla");
        lblTeclas.setSize(180, 20);
        lblTeclas.setLocation(220, 100);
        lblTeclas.addKeyListener(this);
        lblTeclas.setFocusable(true);
        this.add(lblTeclas);
        
        secundario = new VentanaColor(this);
        
        cambiarTitulo = new Boolean(false);
        
        ventanaColor = new VentanaColor(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == botonIzquierdo) {
            botonIzquierdo.setBackground(Color.blue);
            botonIzquierdo.setForeground(Color.WHITE);
        }
        if (me.getSource() == botonDerecho) {
            botonDerecho.setBackground(Color.blue);
            botonDerecho.setForeground(Color.WHITE);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        
        if (me.getButton() == 1) {
            botonIzquierdo.setBackground(Color.blue);
            botonIzquierdo.setForeground(Color.white);
        }
        if (me.getButton() == 3) {
            botonDerecho.setBackground(Color.blue);
            botonDerecho.setForeground(Color.white);
        }
        if (me.getSource() == botonIzquierdo) {
            botonIzquierdo.setBackground(Color.red);
        }
        if (me.getSource() == botonDerecho) {
            botonDerecho.setBackground(Color.red);
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == 1) {
            botonIzquierdo.setBackground(null);
            botonIzquierdo.setForeground(null);
        }
        if (me.getButton() == 3) {
            botonDerecho.setBackground(null);
            botonDerecho.setForeground(null);
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
//        this.setTitle(String.format("Posición X:%d Y:%d", me.getX(), me.getY()));
//        super.setTitle(String.format("Posición X:%d Y:%d", me.getX(), me.getY()));

        if (me.getSource() == botonIzquierdo) {
            botonIzquierdo.setForeground(color);
            botonIzquierdo.setBackground(null);
        }
        if (me.getSource() == botonDerecho) {
            botonDerecho.setForeground(color);
            botonDerecho.setBackground(null);
        }
    }
    
    @Override
    public void mouseExited(MouseEvent me) {
        botonIzquierdo.setBackground(null);
        botonIzquierdo.setForeground(null);
        botonDerecho.setBackground(null);
        botonDerecho.setForeground(null);
        this.setTitle("Control de Ratón");
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent me) {
        if (cambiarTitulo == false) {
            this.setTitle(String.format("Posición X:%d Y:%d", me.getX(), me.getY()));
        }
        if (cambiarTitulo == true) {
//            this.setTitle(String.format("Titulo:",ventanaColor.titulo));
            this.setTitle(ventanaColor.titulo.toString());
            this.setTitle(String.format("" + ventanaColor.titulo));
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
//        if (ke.getKeyCode() == KeyEvent.VK_C && KeyEvent.CTRL_MASK != 0) {
//            fSecundario = new JFrame();
//            fSecundario.setVisible(true);
//            combo = new JComboBox();
//            fSecundario.add(combo);
//        }
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        this.lblTeclas.setText(String.format("Codigo: %d Tecla: %s", ke.getKeyCode(), ke.getKeyChar()));
        if (ke.getKeyCode() == KeyEvent.VK_C && KeyEvent.CTRL_MASK != 0) {
            secundario.combo.addItemListener(this);
            secundario.setDefaultCloseOperation(HIDE_ON_CLOSE);
            secundario.setLocationRelativeTo(null);
            secundario.setSize(640, 256);
            secundario.combo.getSelectedItem();
            secundario.setVisible(true);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
        
        lblTeclas.setText("Teclas");
    }
    
}
