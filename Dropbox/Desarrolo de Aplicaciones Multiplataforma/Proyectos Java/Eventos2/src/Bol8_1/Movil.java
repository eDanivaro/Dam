/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bol8_1;

import javax.swing.JFrame;

/**
 *
 * @author danivaro
 */
public class Movil {
    public static void main(String[] args) {
        TecladoMovil movil = new TecladoMovil();
        movil.setVisible(true);
        movil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        movil.setLocationRelativeTo(null);
        movil.setSize(180, 300);
    }
   
}
