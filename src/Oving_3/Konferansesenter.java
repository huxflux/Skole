package Oving_3;

import java.util.ArrayList;


public class Konferansesenter {

    private ArrayList<Rom> rom = new ArrayList<Rom>();

    /**
     * Reserver rom, gitt tidspunkt fra og til, antall personer samt navn og
     * telefonnummer til kunden. Her skal romnummer ikke vaere et parameter,
     * metoden skal selv finne et rom som er ledig og med plass til det
     * oppgitte antallet personer
     */

    public boolean reserverRom(long tidspunktFra, long tidspunktTil, int antallPersoner, String navnPerson, String tlf) {
        for (int i = 0; i < rom.size(); i++) {
            if (rom.get(i).reserverRommet(tidspunktFra, tidspunktTil, antallPersoner, navnPerson, tlf)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Register et nytt rom med romnummer og st0rrelse (ikke tillatt dersom rom
     * med dette nummeret finnes fra f0r av)
     *
     * return FALSE
     */

    public boolean registrerRom(int romNummer, int antallPlasser) {
        if (!finnRom(romNummer)) {
            rom.add(new Rom(romNummer, antallPlasser));
            return true;
        }
        return false;
    }

    /**
     * Finn antall rom
     */

    public int finnAntRom() {
        return rom.size();
    }

    /**
     * Finn et bestem rom, gitt indeks
     */

    public int finnRomIndeks(int indeks) {
        return rom.get(indeks).getRomNummer();
    }

    public boolean finnRom(int romNummer) {
        for (int i = 0; i < rom.size(); i++) {
            if (rom.get(i).getRomNummer() == romNummer) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finn et bestemt rom, gitt romnr
     */

    public String undersokRom(int romNummer) {
        if (finnRom(romNummer)) {
            for (int i = 0; i < rom.size(); i++) {
                if (rom.get(i).getRomNummer() == romNummer) {
                    return "Romnummer: " + rom.get(i).getRomNummer() + " Antall plasser: " + rom.get(i).getAntallPlasser() + "\n" + rom.get(i).toString();
                }
            }
//            return "Ingen reservasjoner paa dette rommet";
        }
        return "Rommet finnes ikke";
    }

    public String infoAlleRom() {
        String tempString = "";
        for (int i = 0; i < rom.size(); i++) {
            tempString += undersokRom(rom.get(i).getRomNummer());
        }
        return tempString;
    }
    /**
     * toString
     */

}
