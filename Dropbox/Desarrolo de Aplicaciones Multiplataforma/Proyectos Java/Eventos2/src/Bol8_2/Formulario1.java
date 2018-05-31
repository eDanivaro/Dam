package Bol8_2;

import Bol8_1.*;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danivaro
 */
public class Formulario1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlRaton f = new ControlRaton();
        f.setSize(480, 240);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}
