/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author eDanivaro
 */
public class Formulario extends JFrame implements ActionListener {

    JLabel lblCantidad;
    JTextField txfCantidad;
    JButton btnGenerar;
    JRadioButton rbAleatorio;
    JRadioButton rbOdenado;
    ButtonGroup btnGrupo;
    JLabel lblError;
    ImageIcon imgError;
    JPanel pnPanel;
    JButton btnJuegos;
    JButton[] arrayOsos;
    ImageIcon img;
    ArrayList<Oso> ositos;
//    ImageIcon img1 = new ImageIcon(System.getProperty("user.home") + "/images/1.png");
//    ImageIcon img2 = new ImageIcon(System.getProperty("user.home") + "/images/2.png");
//    ImageIcon img3 = new ImageIcon(System.getProperty("user.home") + "/images/3.png");
//    ImageIcon img4 = new ImageIcon(System.getProperty("user.home") + "/images/4.png");
    JMenuItem itemGuardar;
    JMenuItem itemSalir;
    JMenu mnuArchivo;
    JMenuBar barMenu;

    public Formulario() {
        super();
        this.setLayout(null);
        this.setTitle("War Bears Manager");

        lblCantidad = new JLabel("Cantidad");
        lblCantidad.setLocation(20, 0);
        lblCantidad.setSize(80, 30);
        lblCantidad.setToolTipText("lbl cantidad");
        this.add(lblCantidad);

        txfCantidad = new JTextField(3);
        txfCantidad.setLocation(20, 30);
        txfCantidad.setSize(80, 30);
        txfCantidad.setToolTipText("txf cantidad");
        this.add(txfCantidad);

        btnGenerar = new JButton("Generar Batallón");
        btnGenerar.setLocation(20, 60);
        btnGenerar.setSize(150, 30);
        btnGenerar.setToolTipText("botón generar");
        btnGenerar.addMouseListener(new adaptadorRaton());
        btnGenerar.addActionListener(this);
        this.add(btnGenerar);

        rbAleatorio = new JRadioButton("Aleatorio");
        rbAleatorio.setSize(100, 30);
        rbAleatorio.setLocation(200, 30);
        rbAleatorio.setSelected(true);
        this.add(rbAleatorio);
        rbOdenado = new JRadioButton("Ordenado");
        rbOdenado.setSize(100, 30);
        rbOdenado.setLocation(200, 60);
        this.add(rbOdenado);
        btnGrupo = new ButtonGroup();
        btnGrupo.add(rbAleatorio);
        btnGrupo.add(rbOdenado);

        imgError = new ImageIcon(System.getProperty("user.home") + "/images/error.png");
        lblError = new JLabel();
        lblError.setIcon(imgError);
        lblError.setSize(400, 300);
        lblError.setLocation(190, 90);
        lblError.setVisible(false);
        this.add(lblError);

        pnPanel = new JPanel();
        pnPanel.doLayout();
        pnPanel.setSize(300, 300);
        pnPanel.setLocation(30, 90);
        pnPanel.setBackground(Color.LIGHT_GRAY);
        pnPanel.setVisible(false);
        this.add(pnPanel);

        btnJuegos = new JButton();

        img = new ImageIcon();

        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.addActionListener(this);
        itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(this);
        
        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setMnemonic('A');
        mnuArchivo.add(itemGuardar);
        mnuArchivo.addSeparator();
        mnuArchivo.add(itemSalir);
        barMenu = new JMenuBar();
        barMenu.add(mnuArchivo);
        this.setJMenuBar(barMenu);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnGenerar) {
            try {
                int numero;
                numero = Integer.parseInt(txfCantidad.getText().trim());
                if (numero < 0 || numero > 25) {

                } else {
                    lblError.setVisible(false);
                    pnPanel.setVisible(true);
                    arrayOsos = new JButton[numero];
                    for (int i = 0; i < numero; i++) {
                        arrayOsos[i] = new JButton("PRUEBA");
                        pnPanel.add(arrayOsos[i]);
                        if (rbOdenado.isSelected()) {
                            for (int j = 0; j < 3; j++) {
                                mostrarMenu(j, i);
                            }
                        }
                        if (rbAleatorio.isSelected()) {
                            int numAleatorio;
                            numAleatorio = (int) (Math.random() * 3 + 1);
                            mostrarMenu(numAleatorio, i);
                        }
                        arrayOsos[i].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
//                                ositos = new ArrayList<Oso>;

                                DatosOsos secundario = new DatosOsos(Formulario.this);
                                secundario.setSize(250, 200);
                                secundario.setLocationRelativeTo(null);
                                secundario.setVisible(true);
                                secundario.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosing(WindowEvent we) {
                                        super.windowClosing(we); //To change body of generated methods, choose Tools | Templates.

                                    }

                                });

                            }
                        });
                    }
//                    pnPanel.doLayout();
//                    btnGenerar.setFocusable(false);
                    btnGenerar.setEnabled(false);
                }
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Valor incorrecto", "Error", WIDTH);
                lblError.setVisible(true);
            }
        }
        if(ae.getSource()==itemGuardar){
//            try (File archivo = new File("ositos.txt");
//                    File archivo = new File("ositos.txt");){
//            } catch (IOException ex) {
//                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        if (ae.getSource() == itemSalir) {
            System.exit(0);
        }
    }

    public void mostrarMenu(int j, int i) {
        switch (j) {
            case 1:
                arrayOsos[i].setIcon(new ImageIcon(System.getProperty("user.home") + "/images/1.png"));
                break;
            case 2:
                arrayOsos[i].setIcon(new ImageIcon(System.getProperty("user.home") + "/images/2.png"));
                break;
            case 3:
                arrayOsos[i].setIcon(new ImageIcon(System.getProperty("user.home") + "/images/3.png"));
                break;
            case 4:
                arrayOsos[i].setIcon(new ImageIcon(System.getProperty("user.home") + "/images/4.png"));
                break;
        }
    }

    class adaptadorRaton extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent me) {
            super.mouseEntered(me);
            if (me.getSource() == btnGenerar) {
                btnGenerar.setBackground(Color.RED);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            super.mouseExited(me);
            if (me.getSource() == btnGenerar) {
                btnGenerar.setBackground(null);
            }
        }
    }
}
