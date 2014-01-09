package Oving_1;

import static javax.swing.JOptionPane.*;

public class Klient_1 {
    public static void main(String[] args) {
        String[] testOption = {"Navn", "Etableringsaar", "Reserver bord", "Frigi bord", "Hvilke bord har", "Vis info"};
        String navnRestaurant = "";
        String navnPerson = "";
        String tempString = "";
        int antallBord = 0;
        int etableringsaar = 0;
        int elFinito = 0;

        navnRestaurant = showInputDialog("Navn paa restaurant");
        etableringsaar = Integer.parseInt(showInputDialog("Etableringsaar"));

        Restaurant restaurant = new Restaurant(navnRestaurant, etableringsaar);

        do {
            switch (showOptionDialog(null, "", "Restaurant", 0, PLAIN_MESSAGE, null, testOption, testOption[0])) {
                case 0:
                    restaurant.setNavnRestaurant(showInputDialog("Navn paa Restaurant"));
                    break;
                case 1:
                    restaurant.setEtableringsAar(Integer.parseInt(showInputDialog("Velg etableringsaar")));
                    break;
                case 2:
                    navnPerson = showInputDialog("Navn paa person");
                    antallBord = Integer.parseInt(showInputDialog("Antall bord"));
                    restaurant.reserverBord(navnPerson, antallBord);
                    break;
                case 3:
                    restaurant.frigiBordNavn(showInputDialog("Navn paa person"));
                    break;
                case 4:
                    navnPerson = showInputDialog("Navn paa person");
                    int[] temp = restaurant.hvilkeBordNavn(navnPerson);
                    tempString = (navnPerson + " har reservert bord: ");
                    for (int i = 0; i < temp.length; i++) {
                        if (temp[i] != 0) {
                            tempString += (temp[i] + " ");
                        }
                    }
                    showMessageDialog(null, tempString);
                    break;
                case 5:
                    showMessageDialog(null, restaurant.toString());
                    break;
                default:
                    elFinito = -1;
            }
        } while (elFinito != -1);
    }
}
