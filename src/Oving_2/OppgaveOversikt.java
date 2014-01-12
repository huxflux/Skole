package Oving_2;

import java.util.ArrayList;

public class OppgaveOversikt {
    //    private Student[] studenter = new Student[5];
    ArrayList<Student> studenter = new ArrayList<Student>();
    private int antStud = 0;

    public boolean regNyStudent(String navn) {
        if (finnesNavn(navn)) {
            return false;
        }
//        studenter[antStud] = new Student(navn, 0);
        studenter.add(new Student(navn, 0));
        antStud++;
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
            if (studenter.get(i).getNavn().equals(alleNavn[i])) {
                return studenter.get(i).getAntOppg();
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
            if (studenter.get(i).getNavn().equals(alleNavn[i])) {
                studenter.get(i).setAntOppg(studenter.get(i).getAntOppg() + økning);
                return true;
            }
        }
        return false;
    }

    public String[] finnAlleNavn() {
        String[] alleNavn = new String[antStud];
        for (int i = 0; i < antStud; i++) {
            alleNavn[i] = studenter.get(i).getNavn();
        }
        return alleNavn;
    }

    public String toString() {
        String stringArray = "";
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < antStud; i++) {
            stringArray += "Navn: " + alleNavn[i] + ", Oppg. løst: " + studenter.get(i).getAntOppg() + "\n";
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

