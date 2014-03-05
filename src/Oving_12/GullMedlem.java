package Oving_12;

public class GullMedlem extends BonusMedlem {
    public GullMedlem(int medlNr, Personalia pers, Dato innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato, poeng);
    }
    public void registrerPoeng(int poeng) {
        poeng *= 1.5;
        super.registrerPoeng((int) poeng);
    }

    public String toString(){
        return super.toString() + " og er Goilljmedlem.";
    }
}
