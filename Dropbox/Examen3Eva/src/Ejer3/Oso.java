/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer3;

import javax.swing.JDialog;

/**
 *
 * @author eDanivaro
 */
public class Oso extends JDialog{
    String nombre = "";
    String poder = "";
    public Oso(String nombre, String poder) {
		this.nombre = nombre;
		this.poder = poder;
	}

    @Override
    public String toString() {
        return "Oso{" + "nombre=" + nombre + ", poder=" + poder + '}';
    }
    
}
