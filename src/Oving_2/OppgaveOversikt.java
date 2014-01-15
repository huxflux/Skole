package Oving_2;

import java.util.ArrayList;

public class OppgaveOversikt {
    ArrayList<Student> studenter = new ArrayList<Student>();

    public boolean regNyStudent(String navn) {
        if (finnesNavn(navn)) {
            return false;
        }
        studenter.add(new Student(navn, 0));
        return true;
    }

    public int finnAntStud() {
        return studenter.size();
    }

    public int finnAntOppgaver(String navn) {
        if (!finnesNavn(navn)) {
            return -1;
        }
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < studenter.size(); i++) {
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
        for (int i = 0; i < studenter.size(); i++) {
            if (studenter.get(i).getNavn().equals(alleNavn[i])) {
                studenter.get(i).setAntOppg(studenter.get(i).getAntOppg() + økning);
                return true;
            }
        }
        return false;
    }

    public String[] finnAlleNavn() {
        String[] alleNavn = new String[studenter.size()];
        for (int i = 0; i < studenter.size(); i++) {
            alleNavn[i] = studenter.get(i).getNavn();
        }
        return alleNavn;
    }

    public String toString() {
        String stringArray = "";
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < studenter.size(); i++) {
            stringArray += "Navn: " + alleNavn[i] + ", Oppg. løst: " + studenter.get(i).getAntOppg() + "\n";
        }
        stringArray += "antStud: " + studenter.size();
        return stringArray;
    }

    public boolean finnesNavn(String navn) {
        String[] alleNavn = finnAlleNavn();
        for (int i = 0; i < studenter.size(); i++) {
            if (alleNavn[i].equals(navn)) {
                return true;
            }
        }
        return false;
    }
}

