package Oving_1;

public class Restaurant {
    private String navnRestaurant = "";
    private int etableringsAar = 0;
//    private Bord bordRestaurant = new Bord();
    Bord bordRestaurant = null;
    public Restaurant(String navnRestaurant, int etableringsAar, int antallBord) {
        this.navnRestaurant = navnRestaurant;
        this.etableringsAar = etableringsAar;
        this.bordRestaurant = new Bord(antallBord);
    }

    public String getNavnRestaurant() {
        return navnRestaurant;
    }

    public void setNavnRestaurant(String navnRestaurant) {
        this.navnRestaurant = navnRestaurant;
    }

    public int getEtableringsAar() {
        return etableringsAar;
    }

    public void setEtableringsAar(int etableringsAar) {
        this.etableringsAar = etableringsAar;
    }

    public int getAlder() {
    java.util.GregorianCalendar dagensDato = new java.util.GregorianCalendar();
        return dagensDato.get(java.util.Calendar.YEAR) - etableringsAar;
    }

    public int getAntallLedigeBord() {
        return bordRestaurant.getAntallLedigeBord();
    }

    public int getAntallOpptatteBord() {
        return bordRestaurant.getAntallOpptatteBord();
    }

    public void reserverBord(String navn, int antallBord) {
        for (int i = 0; i < antallBord; i++) {
            bordRestaurant.reserverBord(navn);
        }
    }

    public void frigiBordNavn(String navn) {
        int[] bordNummerListe = hvilkeBordNavn(navn);
        for (int i = 0; i < bordNummerListe.length; i++) {
            System.out.println("bordnummerliste: " + bordNummerListe[i]);
            bordRestaurant.frigiBord(bordNummerListe[i]);
        }
    }

    public int[] hvilkeBordNavn(String navn) {
        int[] bordNummerListe = bordRestaurant.bordNavn(navn);
        return bordNummerListe;
    }

    public String toString() {
        String infoString = "";
        infoString = "Navn: " + getNavnRestaurant() + "\n";
        infoString += "Etableringsaar: " + getEtableringsAar() + "\n";
        infoString += "Alder: " + getAlder() + "\n";
        infoString += "Antall ledige bord: " + getAntallLedigeBord() + "\n";
        infoString += "Antall opptatte bord: " + getAntallOpptatteBord() + "\n";
        infoString += bordRestaurant.toString();
        return infoString;
    }
}
