package Oving_14;

import java.util.ArrayList;

abstract class Tribune implements java.lang.Comparable<Tribune>, java.io.Serializable{
    private final String tribuneNavn;
    private final int kapasitet;
    private final int pris;
    private static final long serialVersionUID = 12413513L;

    public Tribune(String tribuneNavn, int kapasitet, int pris) {
        this.tribuneNavn = tribuneNavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }
    public String getTribuneNavn(){
        return tribuneNavn;
    }
    public int getKapasitet(){
        return kapasitet;
    }
    public int getPris(){
        return pris;
    }

    public abstract int finnAntallSolgte();
    public int finnInntekt() {
        return pris * finnAntallSolgte();
    }
    public abstract ArrayList<Billett> kjøpBilletter(String[] navn);
    public abstract ArrayList<Billett> kjøpBilletter(int antall);

    public String toString(){
        return getTribuneNavn() + " har " + getKapasitet() + " plasser \n" + finnAntallSolgte() + " solgte billetter \n" + "Billettpris " + getPris() + "\n" + finnInntekt()+ " " + "NOK\n";
    }

    public int compareTo(Tribune annaObjekt){
        int a = this.finnInntekt();
        int b = annaObjekt.finnInntekt();
        return (a < b) ? -1 : 1;
    }
}