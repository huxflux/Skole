package Oving_14;

import java.util.*;
import java.io.*;

public class MeineKlient {
    public static void main(String args[]) {
        //                           tribunenavn, kapasitet, pris       tribunenavn, kapasitet, pris       tribunenavn, pris, x rad, y rad    tribunenavn, pris, x rad, y rad
        Tribune[] stadion = {new Staa("Ståplass_1", 10000, 100), new Staa("Ståplass_2", 5000, 100), new Sitte("Sitteplass", 250, 50, 50), new VIP("VIP", 450, 10, 10)};

        /* Staaplass_1 */
        stadion[0].kjøpBilletter(30);
        String[] navn = {"Roger Wilco", "Larry Laffer", "Al Lowe", "Ken Williams"};
        stadion[0].kjøpBilletter(navn);

        /* Staaplass_2 */
        stadion[1].kjøpBilletter(10);
        String[] navn2 = {"Kunta Kinte", "Tarzan", "Fantomet"};
        stadion[1].kjøpBilletter(navn2);

        /* Sitteplass */
        stadion[2].kjøpBilletter(50);
        String[] navn3 = {"Kongen", "Dronningen", "Presten"};
        stadion[2].kjøpBilletter(navn3);

        /* VIP */
        String[] navn4 = {"Kristoffmisbruker Robin", "Nazi Nøff", "Ole Brum"};      // her maa du oppgi navn, ellers ingen V I P!
        stadion[3].kjøpBilletter(navn4);

        /* Skrive ut billetter */
        for (int i = 0; i < stadion.length; i++) {
            for (int j = 0; j < stadion[i].finnAntallSolgte(); j++) {
                System.out.println("1 billett paa " + stadion[i].getTribuneNavn());
            }
        }

        /* Sortere tribune */
        System.out.println();
        Arrays.sort(stadion, Collections.reverseOrder());

        for (int i = 0; i < stadion.length; i++) {
            System.out.println(stadion[i]);
        }

        /* Mekke fil */
        try {
            FileOutputStream fil = new FileOutputStream("c:\\coding\\tribune.ser");
            ObjectOutputStream ut = new ObjectOutputStream(fil);

            for (int i = 0; i < stadion.length; i++) {
                ut.writeObject(stadion[i]);
            }
            ut.close();
            fil.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}