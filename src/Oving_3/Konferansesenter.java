package Oving_3;

import java.util.ArrayList;

public class Konferansesenter {
    ArrayList<Rom> rom = new ArrayList<Rom>();

    /**
     * Reserver rom, gitt tidspunkt fra og til, antall personer samt navn og
     * telefonnummer til kunden. Her skal romnummer ikke vaere et parameter,
     * metoden skal selv finne et rom som er ledig og med plass til det
     * oppgitte antallet personer
     */
    public boolean reserverRom(long tidspunktFra, long tidspunktTil, int antallPerson, String navnKunde, String tlfKunde) {
        return false;
    }

    /**
     * Register et nytt rom med romnummer og st0rrelse (ikke tillatt dersom rom
     * med dette nummeret finnes fra f0r av)
     */
    public boolean regNyttRom(int romNummer, int storrelse) {
        return false;
    }

    /**
     * Finn antall rom
     */
    public int getAntallRom() {
        return 0;
    }

    /**
     * Finn et bestem rom, gitt indeks
     */
    public int getIndeksRom() {
        return 0;
    }

    /**
     * Finn et bestemt rom, gitt romnr
     */
    public int getRom() {
        return 0;
    }

}
