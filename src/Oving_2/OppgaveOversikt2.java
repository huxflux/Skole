package Oving_2;

public class OppgaveOversikt2 {
    private Student[] studenter = new Student[5];
    private int antStud = 0;

    public boolean regNyStudent(String navn) {
        if (finnesNavn(navn)) {
            return false;
        }
        studenter[antStud] = new Student(navn, 0);
        antStud++;

        if (studenter.length == antStud) {
            Student[] nyTab = new Student[studenter.length + 5];
            for (int i = 0; i < antStud; i++) {
                nyTab[i] = studenter[i];
            }
            studenter = nyTab;
        }
        return true;
    }

    public int finnAntStud() {
        return antStud;
    }

    public int finnAntOppgaver(String navn) {
        if (!finnesNavn(navn)) {
            return -1;
        }
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(alleNavn[i])) {
                return studenter[i].getAntOppg();
            }
        }
        return -1;
    }

    public boolean økAntOppg(String navn, int økning) {
        if (!finnesNavn(navn)) {
            return false;
        }
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(alleNavn[i])) {
                studenter[i].setAntOppg(studenter[i].getAntOppg() + økning);
                return true;
            }
        }
        return false;
    }

    public String[] finnAlleNavn() {
        String[] alleNavn = new String[antStud];
        for (int i = 0; i < antStud; i++) {
            alleNavn[i] = studenter[i].getNavn();
        }
        return alleNavn;
    }

    public String toString() {
        String stringArray = "";
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < antStud; i++) {
            stringArray += "Navn: " + alleNavn[i] + ", Oppg. løst: " + studenter[i].getAntOppg() + "\n";
        }
        stringArray += "antStud: " + antStud;
        return stringArray;
    }

    public boolean finnesNavn(String navn) {
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < antStud; i++) {
            if (alleNavn[i].equals(navn)) {
                return true;
            }
        }
        return false;
    }
}
