
package Ejercicio1B;

import java.io.*;
import javax.swing.JFrame;
import java.util.*;

/**
 *
 * @author danivaro
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        ArchivosTexto archivo = new ArchivosTexto();
        archivo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        archivo.setResizable(true);
        archivo.setLocationRelativeTo(null);
        archivo.setSize(600, 400);
        archivo.setVisible(true);

    }
}
