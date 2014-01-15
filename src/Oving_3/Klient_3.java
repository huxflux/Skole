package Oving_3;

import static javax.swing.JOptionPane.*;

public class Klient_3 {
    public static void main(String[] args) {
        Konferansesenter konferansesenter = new Konferansesenter();

        String[] menuOptions = {"Reg. rom", "Reserver rom", "Info rom", "All info", "Avslutt"};
        String tempString = "";
        String navnKunde = "";
        String tlfKunde = "";
        int romNummer = 0;
        int storrelse = 0;
        long tidspunktFra = 0;
        long tidspunktTil = 0;
        int antallPerson = 0;
        boolean yayOrNay = true;

        do {
            switch(showOptionDialog(null, "", "Ken sent me", 0, PLAIN_MESSAGE, null, menuOptions, menuOptions[0])) {
                case 0:
                    romNummer = Integer.parseInt(showInputDialog(null, "Romnummer:"));
                    storrelse = Integer.parseInt(showInputDialog(null, "Antall plasser"));
                    konferansesenter.regNyttRom(romNummer, storrelse);
                    showMessageDialog(null, "Rom " + romNummer + " registrert med " + storrelse + " plasser");
                    break;
                case 1:
                    tidspunktFra = Long.parseLong(showInputDialog(null, "Tidspunkt fra (yyyymmddhhmm)"));
                    tidspunktTil = Long.parseLong(showInputDialog(null, "Tidspunkt til (yyyymmddhhmm"));
                    antallPerson = Integer.parseInt(showInputDialog(null, "Antall personer"));
                    navnKunde = showInputDialog(null, "Navn paa kunde");
                    tlfKunde = showInputDialog(null, "Tlf. kunde");
                    konferansesenter.reserverRom(tidspunktFra, tidspunktTil, antallPerson, navnKunde, tlfKunde);

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                default:
                    yayOrNay = false;
                    break;
            }


        } while (yayOrNay);
    }
}
