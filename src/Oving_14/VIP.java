package Oving_14;

import java.util.ArrayList;

class VIP extends Tribune{
    private String[][] tilskuer;
    private static final long serialVersionUID = 12413513L;

    public VIP(String tribuneNavn, int pris, int x, int y){
        super(tribuneNavn, x * y, pris);
        tilskuer = new String[x][y];
    }

    private int ledig(int antall){
        int rekke = -1;
        for(int i = 0; i < tilskuer.length; i++){
            if(antall <= tilskuer[i].length && tilskuer[i][0] == null) rekke = i;
        }
        return rekke;
    }

    public ArrayList<Billett> kjøpBilletter(String[] navn){
        int rekke = ledig(navn.length);
        if(rekke < 0){
            throw new IllegalArgumentException("DET E FOILLTJ FOR FAEN!!");
        }
        ArrayList<Billett> billetter = new ArrayList<Billett>();

        for(int i = 0; i < navn.length; i++){
            tilskuer[rekke][i] = navn[i];
            billetter.add(new SitteplassBillett(getTribuneNavn(), getPris(), rekke, i));
        }
        return billetter;
    }
    public ArrayList<Billett> kjøpBilletter(int antall){
        throw new IllegalArgumentException("Eh, can I haz namez cheezeburgerz pl0x, wtf");
    }
//    public int finnInntekt(){
//        return finnAntallSolgte()*getPris();
//    }
    public int finnAntallSolgte(){
        int antall = 0;
        for(int r = 0; r < tilskuer.length; r++){
            for(int c = 0; c < tilskuer[r].length; c++){
                if(tilskuer[r][c] != null) antall ++;
            }
        }
        return antall;
    }
}
