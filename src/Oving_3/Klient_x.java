package Oving_3;

import static javax.swing.JOptionPane.*;

public class Klient_x {
    public static void main(String[] args) {
        Konferansesenter konferansesenter = new Konferansesenter();
        String[] menuOptions = {"Reg. rom", "Res. rom", "Ant. rom", "Info rom", "All info", "Avslutt"};
        boolean yayOrNot = true;
        int romNummer = 0;
        int antallPlasser = 0;
        long tidspunktFra = 0L;
        long tidspunktTil = 0L;
        int antallPersoner = 0;
        String navnPerson = "";
        String tlf = "";

        do {
            switch (showOptionDialog(null, "", "Restaurant", 0, PLAIN_MESSAGE, null, menuOptions, menuOptions[0])) {
                case 0:
                    romNummer = Integer.parseInt(showInputDialog(null, "Romnummer"));
                    antallPlasser = Integer.parseInt(showInputDialog(null, "Antall plasser"));
                    if (konferansesenter.registrerRom(romNummer, antallPlasser)) {
                        showMessageDialog(null, "Rom registrert");
                        break;
                    }
                    showMessageDialog(null, "Rommet finnes fra f0r av");
                    break;
                case 1:
                    tidspunktFra = Long.parseLong(showInputDialog(null, "Tidspunkt fra (YYYYMMDDHHMM"));
                    tidspunktTil = Long.parseLong(showInputDialog(null, "Tidspunkt til (YYYYMMDDHHMM"));
                    antallPersoner = Integer.parseInt(showInputDialog(null, "Antall personer"));
                    navnPerson = showInputDialog(null, "Navn kunde");
                    tlf = showInputDialog(null, "Tlf");
                    if (konferansesenter.reserverRom(tidspunktFra, tidspunktTil, antallPersoner, navnPerson, tlf)) {
                        showMessageDialog(null, "Rom registrert!");
                        break;
                    }
                    showMessageDialog(null, "Ingen ledige rom");
                    break;
                case 2:
                    showMessageDialog(null, "Antall rom: " + konferansesenter.finnAntRom());
                    break;
                case 3:
                    romNummer = Integer.parseInt(showInputDialog(null, "Romnummer"));
                    showMessageDialog(null, konferansesenter.undersokRom(romNummer));
                    break;
                case 4:
                    showMessageDialog(null, konferansesenter.infoAlleRom());
                    break;
                case 5:
                    yayOrNot = false;
                    break;
                default:
                    yayOrNot = false;
                    break;
            }
        } while (yayOrNot);
    }
}
