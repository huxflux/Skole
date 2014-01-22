package Oving_6;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.*;

class LagValutaVindu extends JFrame {

    private JLabel tekst = new JLabel("Velg fravaluta og tilvaluta fra listene");
    private JLabel tekstTomt = new JLabel("");
    private DefaultListModel listeinnhold = new DefaultListModel();
    private JList valutaListe = new JList(listeinnhold);
    private JList valutaListe2 = new JList(listeinnhold);
    private ArrayList<Valuta> valutaListeMain = new ArrayList<Valuta>();

    public LagValutaVindu(String tittel) {
        valutaListeMain.add(new Valuta("Euro",8.10, 1));
        valutaListeMain.add(new Valuta("US Dollar", 6.23, 1));
        valutaListeMain.add(new Valuta("Britiske pund", 12.27, 1));
        valutaListeMain.add(new Valuta("Svenske kroner", 88.96, 100));
        valutaListeMain.add(new Valuta("Danske kroner", 108.75, 100));
        valutaListeMain.add(new Valuta("Yen", 5.14, 100));
        valutaListeMain.add(new Valuta("Islandske kroner", 9.16, 100));
        valutaListeMain.add(new Valuta("Norske kroner", 100, 100));
        listeinnhold.addElement("Ny valuta");
        listeinnhold.addElement("---------");
        String tempString = "";
        for (int i = 0; i < valutaListeMain.size(); i++) {
            listeinnhold.addElement(valutaListeMain.get(i).getValutaNavn());
        }
                setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(tekst, BorderLayout.NORTH);
        add(new ListePanel(), BorderLayout.WEST);
        add(new ListePanel2(), BorderLayout.EAST);
        pack();
    }

    private class ListePanel extends JPanel {
        public ListePanel() {
            valutaListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane rullefeltMedListe = new JScrollPane(valutaListe);
            add(rullefeltMedListe);
            valutaListe.addListSelectionListener(new ListeboksLytter());
        }
    }

    private class ListePanel2 extends JPanel {
        public ListePanel2() {
            valutaListe2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane rullefeltMedListe2 = new JScrollPane(valutaListe2);
            add(rullefeltMedListe2, BorderLayout.EAST);
            valutaListe2.addListSelectionListener(new ListeboksLytter());
        }
    }

    private class ListeboksLytter implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent hendelse) {
            int valg = valutaListe.getSelectedIndex();
            int valg2 = valutaListe2.getSelectedIndex();
            if (valg == 0 || valg2 == 0) {
                String nyValuta = showInputDialog("Navn paa valuta: ");
                double nyKurs = Double.parseDouble(showInputDialog("Ny kurs: "));
                int nyEnhet = Integer.parseInt(showInputDialog("Ny enhet i forhold til NOK"));

                if (nyValuta != null && nyKurs != 0) {
                    listeinnhold.addElement(nyValuta);
                    valutaListe.clearSelection();
                    valutaListe2.clearSelection();
                    valutaListeMain.add(new Valuta(nyValuta, nyKurs, nyEnhet));
                }
            } else {
                if (valg > 0 && valg2 > 0) {
                    String test = showInputDialog("Oppgi beløp:");
                    double iNok = Integer.parseInt(test) * (valutaListeMain.get(valg - 2).getKursNorskeKroner() / valutaListeMain.get(valg - 2).getEnhet());
                    showMessageDialog(null, iNok * (valutaListeMain.get(valg2-2).getEnhet() / valutaListeMain.get(valg2-2).getKursNorskeKroner()));
                    }
                    valutaListe2.clearSelection();
            }
        }
    }
}


class Klient_6 {
    public static void main(String[] args) {
        LagValutaVindu vindu = new LagValutaVindu("Valutakalkulator");
        vindu.setVisible(true);
    }
}

