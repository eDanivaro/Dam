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
import javax.swing.AbstractListModel;
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
    DefaultListModel<String> modelList = new DefaultListModel<String>();
//    AbstractListModel<String> abstractModel = new AbstractListModel<String>() {
//        @Override
//        public int getSize() {
//            System.out.println("");
//        }
//
//        @Override
//        public String getElementAt(int i) {
//            System.out.println("");
//        }
//    };
    JComboBox combo;
    JButton btnAnhadir;
    JButton btnQuitar;
    JButton btnTraspasarDer;
    JButton btnTraspasaIzq;
    JTextField txfTexto;
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
//        lista.setModel(new DefaultListModel());
//        lista.setSelectionModel(single);
//        lista.addListSelectionListener(this);
//        this.add(lista);
        lista.setModel(modelList);

        combo = new JComboBox();
        combo.setSize(200, 30);
        combo.setLocation(260, 220);
        lista.setVisibleRowCount(5);
//        lista.addListSelectionListener((ListSelectionListener) this);
        add(new JScrollPane(lista));
        this.add(combo);

        btnAnhadir = new JButton("Añadir");
        btnAnhadir.setToolTipText("Pulsa aquí para añadir");
        btnAnhadir.setSize(100, 30);
        btnAnhadir.setLocation(260, 120);
        btnAnhadir.addActionListener(this);
        this.add(btnAnhadir);

        btnQuitar = new JButton("Quitar");
        btnQuitar.setToolTipText("Pulsa aquí para eliminar un elemento");
        btnQuitar.setSize(100, 30);
        btnQuitar.setLocation(260, 160);
        btnQuitar.addActionListener(this);
        this.add(btnQuitar);

        txfTexto = new JTextField("");
        txfTexto.setToolTipText("Escribe aquí los que quieras añadir...");
        txfTexto.setSize(200, 30);
        txfTexto.setLocation(260, 60);
        txfTexto.addActionListener(this);
        this.add(txfTexto);

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

        if (ae.getSource() == txfTexto || ae.getSource() == btnAnhadir) {
            if (txfTexto.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Campo vacio", "Advertencia", WIDTH);
            } else {
                modelList.addElement(txfTexto.getText());
                txfTexto.setText("");
            }
        }

        if (ae.getSource() == btnQuitar) {
//            modelList.getListDataListeners().
//            lista.getListSelectionListeners();
            String s = "Elementos seleccionados: ";
            if (lista.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado nada", "Error", WIDTH);
                for (Object item : lista.getSelectedValuesList()) {
                    s = s + (String) item + " ";
                }
            }

            if (lista.getSelectedIndices().length != 0) {
                JOptionPane.showMessageDialog(null, "Entra", "", WIDTH);
                for (int i = 0; i < modelList.getSize(); i++) {
//                lista.removeElementAt(lista.getSelectedIndex());
                    if (lista.isSelectedIndex(i)) {
                        modelList.removeElement(i);
                        JOptionPane.showConfirmDialog(null, "Aquí tambien", "Info", WIDTH);
                    }
                            lista.setModel(modelList);

                }

            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        String s = "Elementos seleccionados: ";
        if (lista.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado nada", "Error", WIDTH);
        } else {
            for (Object item : lista.getSelectedValuesList()) {
                s = s + (String) item + " ";
            }
        }

        if (lista.getSelectedIndex() > 1) {
            int n = lista.getSelectedIndex();
//            int selectIndex[] = new int[];
//            int[] getSelectedIndices(lista.getSelectedIndices());
            lista.getSelectedIndices();

            modelList.addElement(s);
//    C        combo.add(n);

        }
    }
}
