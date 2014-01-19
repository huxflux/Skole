package Oving_3;

import java.util.ArrayList;

public class Rom {
    private ArrayList<Reservasjon> reservasjon = new ArrayList<Reservasjon>();
    int romNummer = 0;
    int antallPlasser = 0;

    public Rom(int romNummer, int antallPlasser) {
        this.romNummer = romNummer;
        this.antallPlasser = antallPlasser;
    }

    public boolean reserverRommet (long tidspunktFra, long tidspunktTil, int antallPerson, String navnKunde, String tlfKunde) {
        Tidspunkt tidFra = new Tidspunkt(tidspunktFra);
        Tidspunkt tidTil = new Tidspunkt(tidspunktTil);
        if (antallPlasser >= antallPerson) {
            if (reservasjon.isEmpty()) {
                reservasjon.add(new Reservasjon(tidFra, tidTil, new Kunde(navnKunde, tlfKunde)));
                return true;
                }
            } else {
            return false;
        }

        for (int i = 0; i < reservasjon.size(); i++) {
            if (reservasjon.get(i).overlapp(tidFra, tidTil)) {
                return false;
            }
        }

        for (int i = 0; i < reservasjon.size(); i++) {
            if (!reservasjon.get(i).overlapp(tidFra, tidTil)) {
                reservasjon.add(new Reservasjon(tidFra, tidTil, new Kunde(navnKunde, tlfKunde)));
                return true;
            }
            return false;
        }
    return false;
    }

    public int getRomNummer() {
        return romNummer;
    }

    public int getAntallPlasser() {
        return antallPlasser;
    }

    public String toString() {
        String tempString = "";
        for (int i = 0; i < reservasjon.size(); i++) {
            tempString += reservasjon.get(i).toString() + "\n";
        }
        return tempString;
    }

    /**
     *
     * Et lite testprogram.
     * Test 1: F0rste reservasjon i et rom.
     * Test 2: Andre reservasjon i et rom.
     * Test 3: Sjekke om et gitt overlapp virkelig overlapper.
     */

    public static void main(String[] args) {
        Rom romTest1 = new Rom(1, 5);

        if (romTest1.reserverRommet(201403081000L, 201403081200L, 3, "John Inge", "5556969")) {
            System.out.println("Forste rom reservert, test 1 SUCCESS!");
        }
        if (romTest1.reserverRommet(201403081200L, 201403081400L, 3, "John Inge", "345345")) {
            System.out.println("Rom reservert, test 2 SUCCESS!");
        }
        if (!romTest1.reserverRommet(201403081000L, 201403081200L, 3, "Da da", "534534")) {
            System.out.println("Det overlapper, test 3 SUCCESS!");
        }
    }
}