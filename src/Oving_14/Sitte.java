package Oving_14;

import java.util.ArrayList;

class Sitte extends Tribune{
    private int[] antOpptatt;
    private int rekkeLengde;
    private static final long serialVersionUID = 12413513L;

    public Sitte(String tribuneNavn, int pris, int x, int y){
        super(tribuneNavn, x * y, pris);
        antOpptatt = new int[y];
        rekkeLengde = x;
    }
    public int finnAntallSolgte(){
        int solgte = 0;
        for(int opptatte : antOpptatt){
            solgte += opptatte;
        }
        return solgte;
    }
//    public int finnInntekt(){
//        return getPris() * finnAntallSolgte();
//    }

    private int ledig(int antall){
        int rekke = -1;
        for(int i = 0; i < antOpptatt.length; i++){
            if((antOpptatt[i] + antall) <= rekkeLengde) rekke = i;
        }
        return rekke;
    }

    public ArrayList<Billett> kjøpBilletter(String[] navn){
        int rekke = ledig(navn.length);
        if (rekke < 0) {
            throw new IllegalArgumentException("DET E FOILLTJ FOR F!");
        }
        ArrayList<Billett> billetter = new ArrayList<Billett>();
//        for(String tilskuer : navn){
            for (int i = 0; i < navn.length; i++) {
                antOpptatt[rekke]++;
                billetter.add(new SitteplassBillett(getTribuneNavn(), getPris(), rekke, antOpptatt[rekke]));
            }
        return billetter;
    }
    public ArrayList<Billett> kjøpBilletter(int antall){
        int rekke = ledig(antall);

        if(rekke < 0){
            throw new IllegalArgumentException("DET E FOILLTJ FOR F!");
        }

        ArrayList<Billett> billetter = new ArrayList<Billett>();
        for(int i = 0; i < antall; i++){
            antOpptatt[rekke]++;
            billetter.add(new SitteplassBillett(getTribuneNavn(), getPris(), rekke, antOpptatt[rekke]));
        }
        return billetter;
    }
}