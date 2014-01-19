package Oving_5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LagVindu extends JFrame {
    JLabel vinduTekst = new JLabel("Morsom test med fonter, weeee. Blablalbal blal balblal");

    public LagVindu(String tittel) {
        setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(vinduTekst);

//        SansSerif, Serif, Monospaced og Dialog.

        JButton sansButton = new JButton("SansSerif");
        add(sansButton);
        JButton serifButton = new JButton("Serif");
        add(serifButton);
        JButton monoButton = new JButton("Monospaced");
        add(monoButton);
        JButton dialogButton = new JButton("Dialog");
        add(dialogButton);

        ButtonListener buttonListener = new ButtonListener();
        sansButton.addActionListener(buttonListener);
        serifButton.addActionListener(buttonListener);
        monoButton.addActionListener(buttonListener);
        dialogButton.addActionListener(buttonListener);

        pack();

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent hendelse) {
            JButton choosenButton = (JButton) hendelse.getSource();
            String buttonName = choosenButton.getText();

            if (buttonName.equals("SansSerif")) {
                Font nyFont = new Font("SansSerif", Font.BOLD, 12);
                vinduTekst.setFont(nyFont);
            } else if (buttonName.equals("Serif")) {
                Font nyFont = new Font("Serif", Font.BOLD, 12);
                vinduTekst.setFont(nyFont);
            } else if (buttonName.equals("Monospaced")) {
                Font nyFont = new Font("Monospaced", Font.BOLD, 12);
                vinduTekst.setFont(nyFont);
            } else {
                Font nyFont = new Font("Dialog", Font.BOLD, 12);
                vinduTekst.setFont(nyFont);
            }
        }

    }
}
public class Klient5_1 {
    public static void main(String[] args) {
        LagVindu test = new LagVindu("test");
        test.setVisible(true);

    }
}
