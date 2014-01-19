package Oving_5;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import javax.swing.*;

class LagVindu2 extends JFrame {

    private JTextField belop = new JTextField(15);
    private JLabel resultat = new JLabel("Resultatet av omregningen kommer her", JLabel.CENTER);

    public LagVindu2(String tittel) {
        setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());
         /*
     * Argumentene til GridLayout() er: antall rader, antall kolonner,
     * horisontal avstand mellom rutene, vertikal avstand mellom rutene
     * de to siste i antall piksler
     */
        setLayout(new GridLayout(3, 1, 5, 5));
        JLabel belopTekst = new JLabel("Belop:", JLabel.RIGHT);
        add(belopTekst);
        add(belop);
//        JLabel resultat = new JLabel("Resultatet av omregningen kommer her", JLabel.CENTER);
        add(resultat);
        JButton svenskKnapp = new JButton("Til svensk.");
        add(svenskKnapp);
        JButton norskKnapp = new JButton("Til norsk.");
        add(norskKnapp);
        pack();

        ButtonListener buttonListener = new ButtonListener();
        svenskKnapp.addActionListener(buttonListener);
        norskKnapp.addActionListener(buttonListener);

        pack();
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent hendelse) {
            JButton choosenButton = (JButton) hendelse.getSource();
            String buttonName = choosenButton.getText();
            double nyttBelop = 0;
            boolean number = true;

            if (buttonName.equals("Til svensk.")) {
                try {
                    nyttBelop = Double.parseDouble(belop.getText()) * 0.95;
                } catch (NumberFormatException e) {
                    resultat.setText("Gimme a r3al numbahhh");
                    number = false;
                }
                if (number) {
                    String stringBelop = String.valueOf(nyttBelop);
                    resultat.setText(stringBelop + " svenske kroner.");
                    number = true;

                }
            } else {
                try {
                    nyttBelop = Double.parseDouble(belop.getText()) * 1.05;
                } catch (NumberFormatException e) {
                    resultat.setText("Gimma a r3al numbahhh");
                    number = false;
                }
                if (number) {
                    String stringBelop = String.valueOf(nyttBelop);
                    resultat.setText(stringBelop + " norske kroner");
                    number = true;
                }
            }

            }
        }
    }
public class Klient5_2 {
    public static void main(String[] args) {
        LagVindu2 lagVindu2 = new LagVindu2("Valutakalkulator");
        lagVindu2.setVisible(true);
    }
}