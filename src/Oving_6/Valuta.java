package Oving_6;

public class Valuta {
    private String valutaNavn = "";
    private double kursNorskeKroner = 0;
    private int enhet = 0;

    public Valuta(String valutaNavn, double kursNorskeKroner, int enhet) {
        this.valutaNavn = valutaNavn;
        this.kursNorskeKroner = kursNorskeKroner;
        this.enhet = enhet;
    }

    public String getValutaNavn() {
        return valutaNavn;
    }

    public double getKursNorskeKroner() {
        return kursNorskeKroner;
    }

    public int getEnhet() {
        return enhet;
    }
}