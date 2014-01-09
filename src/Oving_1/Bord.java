package Oving_1;

public class Bord {
    private int antallBord = 10;
    private String[] bordListe = new String[antallBord];

    public int getAntallLedigeBord() {
        int antallBord = 0;

        for (int i = 0; i < bordListe.length; i++) {
            if (bordListe[i] == null) {
                antallBord++;
            }
        }
        return antallBord;
    }

    public int getAntallOpptatteBord() {
        int antallBord = 0;

        for (int i = 0; i < bordListe.length; i++) {
            if (bordListe[i] != null) {
                antallBord++;
            }
        }
        return antallBord;
    }

    public void reserverBord(String navn) {
        boolean fantBord = false;
        int i = 0;
        while (!fantBord) {
            if (bordListe[i] == null) {
                bordListe[i] = navn;
                fantBord = true;
            }
            i++;
        }
    }

    public void frigiBord(int bordnummer) {
        bordListe[bordnummer] = null;
    }

    public int[] bordNavn(String navn) {
        int[] bordNummer = new int[antallBord];
        int u = 0;
        for (int i = 0; i < bordNummer.length; i++) {
            if (bordListe[i] != null) {
                if (bordListe[i].equals(navn)) {
                    bordNummer[u] = i;
                    u++;

                }
            }
        }
        return bordNummer;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < bordListe.length; i++) {
            if (bordListe[i] != null) {
                temp += "Bordnr. " + i + ": " + bordListe[i] + "\n";
            } else {
                temp += "Bordnr. " + i + ": " + "<ledig>" + "\n";
            }
        }
        return temp;
    }
}
