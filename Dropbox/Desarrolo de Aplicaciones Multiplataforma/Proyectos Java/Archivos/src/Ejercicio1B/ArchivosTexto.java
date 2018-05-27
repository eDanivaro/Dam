package Ejercicio1B;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author danivaro
 */
public class ArchivosTexto extends JFrame implements ActionListener {

    // Etiquetas
    JLabel ruta1;
    JLabel ruta2;

    // Cajones
    JTextField origen;
    JTextField destino;

    // Botones
    JButton copiar;
    JButton borrar;

    // Archivos
    File original;
    File copia;

    RandomAccessFile archivoOrigen;
    RandomAccessFile archivoDestino;

    String pathOrigen;

    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;

    // Constructor
    public ArchivosTexto() {

        super();
        this.setLayout(new FlowLayout());
        this.setTitle("Gestión de archivos V 1.0");
        String path = null;

        ruta1 = new JLabel("Ruta origen");
        ruta1.setToolTipText("Introduce la ruta completa de la ubicación...");
        this.add(ruta1);

        origen = new JTextField(40);
        origen.setVisible(true);
        origen.addActionListener(this);
        this.add(origen);

        ruta2 = new JLabel("Ruta destino");
        ruta2.setToolTipText("Introduce la ruta completa de destino");
        this.add(ruta2);

        destino = new JTextField(40);
//        destino.scrollRectToVisible(rctngl);
        destino.setVisible(true);
        destino.addActionListener(this);
        this.add(destino);

        copiar = new JButton("Copiar");
        copiar.setToolTipText("Copiar el archivo seleccionado...");
        copiar.addActionListener(this);
        this.add(copiar);

        borrar = new JButton("Borrar");
        borrar.setToolTipText("Borrar el archivo deseado...");
        borrar.addActionListener(this);
        this.add(borrar);

        //f = new File(path);
        original = new File("Archivo original"); // Creamos un objeto file
        //System.out.println(f.getAbsolutePath()); // Llamamos al método que devuelve la ruta absoluta

        copia = new File("");

    }

    private static void bytesEscribeEnFile(byte[] bFile, String copia) {

        try (FileOutputStream fileOuputStream = new FileOutputStream(copia)) {
            fileOuputStream.write(bFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.err.println("Oyente");
        try {
//            archivoOrigen = new RandomAccessFile(origen.getText().trim(), "r");
            if (e.getSource() == copiar) {
                original = new File(origen.getText().trim(), "r");
                if (origen == null) {
                    JOptionPane.showMessageDialog(copiar, "El campo ruta origen está vacio");
                }
                //byte[] secuenciaBytes = new byte[(int) archivoOrigen.length()];
                // FIXME controlar error
                byte aux;
                for (int i = 0; (int) original.length() >= i; i++) {
                    copia = new File(origen.getText().trim(), "rw");
                    String file;
//                    pathOrigen = new String(origen.getText());
//                    archivoDestino = new RandomAccessFile(pathOrigen);
                    //aux = original.readByte();
                    //aux = original.
                    //copia.writeByte(aux);
//                    archivoOrigen.
                    byte[] bFile = new byte[(int) copia.length()];

                    //read file into bytes[]
                    fileInputStream = new FileInputStream(pathOrigen);
                    fileInputStream.read(bFile);

                    //save bytes[] into a file
                    bytesEscribeEnFile(bFile, copia + origen.getText() + ".txt");

                    JOptionPane.showMessageDialog(null, "Finalizado", "Copia realizada", JOptionPane.INFORMATION_MESSAGE);

                }

//             while ((len = archivoOrigen.readByte()) > 0) {
//                    destino.write(secuenciaBytes, 0, secuenciaBytes.length);
//                }
            }
            if (e.getSource() == borrar) {
                if (origen == null) {
                    JOptionPane.showMessageDialog(borrar, "El campo de la ruta a borrar es nulo");
                }
                original = new File(origen.getText());
                original.delete();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ruta incorrecta", "Ventana de error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException ee) {

                }
            }
        }

    }
}
