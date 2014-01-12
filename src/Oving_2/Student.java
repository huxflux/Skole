package Oving_2;

public class Student {
    private final String navn;
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void setAntOppg(int antOppg) {
        if (antOppg < 0) {
            throw new IllegalArgumentException("Ugyldig verdi");
        }
        this.antOppg = antOppg;

    }

    public String toString() {
        return ("navn: " + navn + "\n" + "antOppg: " + antOppg);
    }
}
