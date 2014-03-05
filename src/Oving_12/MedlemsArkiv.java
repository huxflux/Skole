package Oving_12;

import java.util.Random;
import java.util.ArrayList;

public class MedlemsArkiv {

//    Random randomGen = new Random();
    ArrayList<BonusMedlem> medlemmer = new ArrayList<BonusMedlem>();
    private final int SOLVMEDLEM = 25000 -1;
    private final int GULLMEDLEM = 75000 -1;

    public int finnPoeng(int medlNr, String passord) {
        for (int i = 0; i < medlemmer.size(); i++) {
            if (medlemmer.get(i).getMedlnr() == medlNr) {
                if (medlemmer.get(i).okPassord(passord)) {
                    return medlemmer.get(i).getPoeng();
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public int registrerPoeng(int medlNr, int poeng) {
        for (int i = 0; i < medlemmer.size(); i++) {
            if (medlemmer.get(i).getMedlnr() == medlNr) {
                medlemmer.get(i).registrerPoeng(poeng);
                return 1;
            }
        }
        return -1;
    }

    //Dummyshit
    public int nyMedlem(Personalia pers, Dato innmeldt) {
        int medlNr = finnLedigNr();
        if (medlNr == -1) {
            System.out.println("W T F!!");
        }
        BasicMedlem nyttMedlem = new BasicMedlem(medlNr, pers, innmeldt);
        medlemmer.add(nyttMedlem);
        return medlNr;
    }

    private int finnLedigNr(){
        Random random = new Random();
        int medlnr = random.nextInt(1000);
        for(BonusMedlem medlem : medlemmer){
            if(medlnr == medlem.getMedlnr()){ medlnr = random.nextInt(1000);}
        }
        return medlnr;
    }

    public void sjekkMedlemmer(Dato idag){
        for(BonusMedlem medlem : medlemmer){
            if(medlem instanceof BasicMedlem){
                if(medlem.finnKvalPoeng(idag) > GULLMEDLEM){
                    medlemmer.set(medlemmer.indexOf(medlem), new GullMedlem(medlem.getMedlnr(), medlem.getPers(), medlem.getInnmeldtDato(), medlem.getPoeng()));
                }
                else if(medlem.finnKvalPoeng(idag) > SOLVMEDLEM){
                    medlemmer.set(medlemmer.indexOf(medlem), new SoelvMedlem(medlem.getMedlnr(), medlem.getPers(), medlem.getInnmeldtDato(), medlem.getPoeng()));
                }
            }
            else if(medlem instanceof SoelvMedlem && medlem.finnKvalPoeng(idag) > GULLMEDLEM){
                medlemmer.set(medlemmer.indexOf(medlem), new GullMedlem(medlem.getMedlnr(), medlem.getPers(), medlem.getInnmeldtDato(), medlem.getPoeng()));
            }
        }
    }

    public String toString(){
        String tekst = "Medlemmer:\n";
        for(BonusMedlem medlem : medlemmer){
            tekst += medlem + "\n";
        }
        return tekst + medlemmer.size() + " medlemmer." + "\n";
    }
}