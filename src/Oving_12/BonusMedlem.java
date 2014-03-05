package Oving_12;

public class BonusMedlem {
    private final int medlNr;
    private final Personalia pers;
    private final Dato innmeldtDato;
    private int poeng = 0;

    public BonusMedlem (int medlNr, Personalia pers, Dato innmeldtDato, int poeng) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
        this.poeng = poeng;
    }

    public BonusMedlem(int medlNr, Personalia pers, Dato innmeldtDato) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
    }

    public int getMedlnr() {
        return medlNr;
    }

    public Personalia getPers() {
        return pers;
    }

    public Dato getInnmeldtDato() {
        return innmeldtDato;
    }

    public int getPoeng() {
        return poeng;
    }

//    Dummyshit
    public int finnKvalPoeng(Dato dato) {
        return (innmeldtDato.dagerForskjell(dato) > 365) ? 0 : poeng;
    }
//    Dummyshit
    public boolean okPassord(String passord) {
      return pers.okPassord(passord);
    }

//    Dummyshit
    public void registrerPoeng(int poeng) {
        this.poeng += poeng;
        return;
    }
    public String toString(){
        return medlNr + ": " + pers.getFornavn() + " " + pers.getEtternavn() + " " + "ble registrert " + innmeldtDato + " og har " + poeng + " poeng";
    }

}
