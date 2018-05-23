/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bol8_1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author danivaro
 */
public class VentanaColor extends JDialog {

    JTextField titulo;
    JComboBox combo;
    Color[] colores;

    public VentanaColor(ControlRaton f) {

//        super(f);
        super(f, true);// true: modal; false: no modal
        this.setTitle("Configuración ventana principal");
        this.setLayout(new FlowLayout());

        titulo = new JTextField(40);
        titulo.setToolTipText("Escoge un título");
        titulo.setSize(100, 30);
        titulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f.setTitle(titulo.getText());
                f.cambiarTitulo=true;
            }
        });

        //colores[] = new Color();
        
        combo = new JComboBox();
        combo.setSize(80, 30);
        combo.addItem("Rojo");
        combo.addItem("Azul");
        combo.addItem("Morado");
        combo.addItem("Amarillo");
//        Color[] colores =new Color();
        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getSource() == combo) {

                    if (combo.getSelectedItem() == "Rojo") {
                        f.color = Color.red;
//                        f.botonIzquierdo.setForeground(color);
//                        f.botonDerecho.setForeground(color);
                    }
                    if (combo.getSelectedItem() == "Azul") {
                        f.color = Color.blue;
//                        f.botonIzquierdo.setForeground(color);
//                        f.botonDerecho.setForeground(color);
                    }
                    if (combo.getSelectedItem() == "Morado") {
                        f.color = Color.magenta;
//                        f.botonIzquierdo.setForeground(color);
//                        f.botonDerecho.setForeground(color);
                    }
                    if (combo.getSelectedItem() == "Amarillo") {
                        f.color = Color.yellow;
//                        f.botonIzquierdo.setForeground(color);
//                        f.botonDerecho.setForeground(color);
                    }
                }
            }
        });

        this.add(combo);
        this.add(titulo);

    }

}
