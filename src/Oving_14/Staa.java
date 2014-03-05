package Oving_14;

import java.util.ArrayList;

class Staa extends Tribune {
    private int antSolgteBilletter;
    private static final long serialVersionUID = 12413513L;

    public Staa(String tribuneNavn, int kapasitet, int pris){
        super(tribuneNavn, kapasitet, pris);
        antSolgteBilletter = 0;
    }
//    public boolean selgStaa(int antBiletter){`
//        return antSolgteBilletter++ <= getKapasitet() ? true : false;
//    }

    public int finnAntallSolgte(){
        return antSolgteBilletter;
    }
//    public int finnInntekt(){
//        return getPris() * antSolgteBilletter;
//    }

    public ArrayList<Billett> kjøpBilletter(String[] navn){
        if((navn.length + antSolgteBilletter) > getKapasitet()){
            throw new IllegalArgumentException("DET E FOILLTJ FOR F!");
        }
        ArrayList<Billett> billetter = new ArrayList<Billett>();
//        for(String tilskuer : navn){
            for (int i = 0; i < navn.length; i++) {
            billetter.add(new StaaplassBillett(getTribuneNavn(), getPris()));
            antSolgteBilletter++;
        }
        return billetter;
    }
    public ArrayList<Billett> kjøpBilletter(int antall){
        if((antall + antSolgteBilletter) > getKapasitet()){
            throw new IllegalArgumentException("DET E FOILLTJ FOR F!");
        }
        ArrayList<Billett> billetter = new ArrayList<Billett>();
        for(int i = 0; i < antall; i++){
            billetter.add(new StaaplassBillett(getTribuneNavn(), getPris()));
            antSolgteBilletter++;
        }
        return billetter;
    }
}







