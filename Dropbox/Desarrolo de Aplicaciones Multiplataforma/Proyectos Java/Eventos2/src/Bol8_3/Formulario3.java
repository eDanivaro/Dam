/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bol8_3;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author danivaro
 */
public class Formulario3 extends JFrame implements ActionListener, ListSelectionListener {

    JList lista;
    JComboBox combo;
    JButton anhadir;
    JButton quitar;
    JButton traspasarDer;
    JButton traspasaIzq;
    JTextField texto;
    JLabel lblUno;
    JLabel lblDos;
    JLabel lblTres;

    JScrollPane scrollVentana;

    public Formulario3() {
        super();
        this.setLayout(null);

        lista = new JList();
//        lista.setSize(200, 400);
//        lista.setLocation(30, 60);
//        lista.setBorder(new LineBorder(Color.black));
        lista.setModel(new DefaultListModel());
//        lista.setSelectionModel(single);
        lista.addListSelectionListener(this);
//        this.add(lista);

        combo = new JComboBox();
        combo.setSize(200, 30);
        combo.setLocation(260, 220);
        this.add(combo);

        anhadir = new JButton("Añadir");
        anhadir.setToolTipText("Pulsa aquí para añadir");
        anhadir.setSize(100, 30);
        anhadir.setLocation(260, 120);
        anhadir.addActionListener(this);
        this.add(anhadir);

        quitar = new JButton("Quitar");
        quitar.setToolTipText("Pulsa aquí para eliminar un elemento");
        quitar.setSize(100, 30);
        quitar.setLocation(260, 160);
        quitar.addActionListener(this);
        this.add(quitar);

        texto = new JTextField("");
        texto.setToolTipText("Escribe aquí los que quieras añadir...");
        texto.setSize(200, 30);
        texto.setLocation(260, 60);
        texto.addActionListener(this);
        this.add(texto);

        lblDos = new JLabel();
        lblDos.setToolTipText("Lista...");
        lblDos.setText("Lista provisional");
        lblDos.setSize(180, 30);
        lblDos.setLocation(30, 30);
        this.add(lblDos);

        lblUno = new JLabel("Texto");
        lblUno.setSize(100, 30);
        lblUno.setLocation(260, 30);
        this.add(lblUno);

        scrollVentana = new JScrollPane(lista);
        scrollVentana.setSize(200, 400);
        scrollVentana.setLocation(30, 60);
        this.add(scrollVentana);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == texto) {

        }
        if (ae.getSource() == anhadir) {
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        String s = "Elementos seleccionados: ";
        if (lista.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado nada", "Error", WIDTH);
        } else {
            for (Object item : lista.getSelectedValuesList()) {
                s += (String) item + " ";
            }
        }
        if (lista.getSelectedIndex() > 1) {
//            combo.add( lista.getSelectedIndex());
        }
    }

}
