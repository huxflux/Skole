package Oving_12;

public class BasicMedlem extends BonusMedlem {
    public BasicMedlem(int medlNr, Personalia pers, Dato innmeldtDato) {
        super(medlNr, pers, innmeldtDato);
    }
    public String toString(){
        return super.toString() + " og er Basicmedlem.";
    }
}
