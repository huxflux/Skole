package Oving_12;

public class SoelvMedlem extends BonusMedlem {
    public SoelvMedlem(int medlNr, Personalia pers, Dato innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato, poeng);
    }

    public void registrerPoeng(int poeng) {
        poeng *= 1.2;
        super.registrerPoeng((int) poeng);
    }
    public String toString(){
        return super.toString() + " og er Soelvmedlem.";
    }
}
