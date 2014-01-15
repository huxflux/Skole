package Oving_3;

import java.util.ArrayList;

public class Rom {
    ArrayList<Reservasjon> romOversikt = new ArrayList<Reservasjon>();

    public Rom(int test) {
        Reservasjon r1 = new Reservasjon(new Tidspunkt(200302011000L), new Tidspunkt(200302011100L), new Kunde("cock", "555"));
    }
}
