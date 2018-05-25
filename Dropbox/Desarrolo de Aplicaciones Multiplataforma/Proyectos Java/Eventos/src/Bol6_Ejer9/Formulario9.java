package Bol6_Ejer9;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author danivaro
 */
public class Formulario9 extends JFrame implements ActionListener {

    JLabel caja1;
    JLabel caja2;
    JLabel caja3;
    JLabel creditoActual;
    JLabel info;

    JButton juego;

//    ImageIcon img1 = new ImageIcon(Formulario9.class.getResource("img/Cherry-128.png"));
    ImageIcon img1 = new ImageIcon(Formulario9.class.getResource("imagenes/Cherry-128.png"));
    ImageIcon img2 = new ImageIcon(Formulario9.class.getResource("imagenes/Bananas-128.png"));
    ImageIcon img3 = new ImageIcon(Formulario9.class.getResource("imagenes/Diamond-128.png"));
    ImageIcon img4 = new ImageIcon(Formulario9.class.getResource("imagenes/Grapes-128.png"));
    ImageIcon img5 = new ImageIcon(Formulario9.class.getResource("imagenes/Lemon-128.png"));
    ImageIcon img6 = new ImageIcon(Formulario9.class.getResource("imagenes/Orange-128.png"));

    ArrayList<ImageIcon> colImagen = new ArrayList<>();

    double creditoInicio = 10;

    Timer cicloTirada;
    Timer cicloEtiqueta;

    int contCiclo;
    
    public Formulario9() {
        super();
        this.setTitle("Superminitragaperras");
        this.setLayout(null);

        //Etiquetas
        caja1 = new JLabel();
        //caja1.setVisible(true);
        caja1.setIcon(img1);
        caja1.setSize(128, 128);
        caja1.setLocation(20 + 130, 20);
        this.add(caja1);

        caja2 = new JLabel();
        caja2.setIcon(img1);
        caja2.setSize(128, 128);
        caja2.setLocation(128 + 130, 20);
        this.add(caja2);

        caja3 = new JLabel();
        caja3.setIcon(img1);
        caja3.setSize(128, 128);
        caja3.setLocation(248 + 130, 20);
        this.add(caja3);

        //Botones
        juego = new JButton();
        juego.setVisible(true);
        juego.setText("Jugar");
        juego.setSize(200, 100);
        juego.setLocation(230, 160);
        juego.addActionListener(this);
        this.add(juego);

        colImagen.add(img1);
        colImagen.add(img2);
        colImagen.add(img3);
        colImagen.add(img4);
        colImagen.add(img5);
        colImagen.add(img6);

        creditoActual = new JLabel("Credito: " + creditoInicio + " €");
        creditoActual.setSize(100, 50);
        creditoActual.setLocation(500, 300);
        this.add(creditoActual);

        cicloTirada = new Timer(1000, this);
        cicloTirada.start();

        info = new JLabel();
        info.setText("");
        info.setSize(120, 30);
        info.setLocation(130, 300);
//        info.setBorder(new LineBorder(Color.black));

        this.add(info);

    }

    public int aleatorio() {
        int random = (int) (Math.random() * 6 + 1);
        return random;
    }

    public Timer tirada() {
        cicloTirada = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contCiclo++;
                if (contCiclo % 2 == 0) {
                    info.setForeground(Color.blue);
                } else {
                    info.setForeground(Color.magenta);
                }
            }
        });
        return cicloTirada;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == juego) {
            if (cicloTirada.isRunning()) {
                cicloTirada.stop();
            }
            juego.setEnabled(false);
            //info.setText(cicloEtiqueta.toString());
            creditoInicio--;
            creditoActual.setText("Credito:" + creditoInicio);

            // FIXME
//            for (int i = 0; i < 3; i++) {
//                int random = aleatorio();
//                caja1.setIcon(colImagen.get(random - 1));
//            }
            int ramdon1 = aleatorio();
            int ramdon2 = aleatorio();
            int ramdon3 = aleatorio();
            if (ramdon1 == ramdon2 && ramdon2 == ramdon3) {
                creditoInicio += 10;
                cicloTirada.start();
            }
            if (ramdon1 == ramdon2 || ramdon1 == ramdon3 || ramdon2 == ramdon3) {
                creditoInicio += 2.5;
            }
            if (creditoInicio <= 0) {
                JOptionPane.showMessageDialog(null, "Has perdido!", "Fin de juego", WIDTH);
            } else {
                creditoActual.setText("Credito: " + creditoInicio + " €");
            }
            cicloTirada.stop();
            caja1.setIcon(colImagen.get(ramdon1 - 1));
            caja2.setIcon(colImagen.get(ramdon2 - 1));
            caja3.setIcon(colImagen.get(ramdon3 - 1));
            cicloTirada.isRunning();
            //cicloTirada.stop();
            juego.setEnabled(true);
//            for(ImageIcon i : colImagen){
//                aleatorio();
//            }
        }
    }

}
