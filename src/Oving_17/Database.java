package Oving_17;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection forbindelse;

    public Database (String dbDriver, String dbNavn) throws Exception {
        try {
            Class.forName(dbDriver);
            forbindelse = DriverManager.getConnection(dbNavn);
        } catch (Exception e) {
            System.out.println("Noe gikk til HELVETE i konstrukt0ren");
            lukkForbindelse();
        }
    }

    /* Denne metoden skal lukke forbindelsen som ble satt opp i konstruktøren. */
    public void lukkForbindelse() throws Exception {
        try {
            forbindelse.close();
        } catch (SQLException e) {
            System.out.println("Fikk ikke lukket Database");
}
}

    /* Denne metoden skal registrere en ny tittel og samtidig eksemplar nummer 1 av denne tittelen */
    public boolean regNyBok(Bok nyBok) {
        /* insert into boktittel(isbn, forfatter, tittel) values(<isbn>, <forfatter>, <tittel>)
        insert into eksemplar(isbn, eks_nr) values (<isbn>, 1); */

        int eks_nr = 1; /* wtf, hver bok skal ha eget eks_nr */

        /* maa sjekke om ISBN finnes fra f0r av */

        if (!sjekkIsbn(nyBok.getIsbn())) {
            String sqlsetn = ("insert into boktittel(isbn, forfatter, tittel) values(" +"'" + nyBok.getIsbn() + "', '" + nyBok.getForfatter() + "', '" + nyBok.getTittel() + "')");
            String sqlsetn2 = ("insert into eksemplar(isbn, eks_nr) values ('" + nyBok.getIsbn() + "', 1)");
            try {
                Statement setning = forbindelse.createStatement();
                forbindelse.setAutoCommit(false);
                setning.executeUpdate(sqlsetn);
                setning.executeUpdate(sqlsetn2);
                forbindelse.commit();
                forbindelse.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    forbindelse.rollback();
                } catch (SQLException f) {
                    e.printStackTrace();
                }
                System.out.println("Feil i regNyBok");
            }
            return true; /* Ny bok registrert */
        }
        return false; /* Ikke registrert, ISBN finnes fra f0r av */

    }

    /* Denne metoden skal registrere et nytt eksemplar av en tittel som allerede skal være registrert i databasen. */
    public int regNyttEksemplar(String isbn) {
        /* insert into eksemplar(isbn, eks_nr) values (<isbn>, <eks_nr>); */
        ResultSet res = null;

        String ordneMaksEksNr = "select MAX(eks_nr) as neste_eks_nr from eksemplar where isbn = '" + isbn + "'";


        try {
            Statement setning = forbindelse.createStatement();
            res = setning.executeQuery(ordneMaksEksNr); // finn maks eks_nr for gitt isbn
            //int eks_nr = setning.executeQuery(maksEksNr); // legg maks eks_nr i
            res.next();
            int maks = res.getInt("neste_eks_nr") + 1;
            String sqlsetn = ("insert into eksemplar(isbn, eks_nr) values ('" + isbn + "', " + maks + ")");
            setning.executeUpdate(sqlsetn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Feil i regNyttEksemplar");
        }

        return 0;
    }

    /* Denne metoden skal registrere at ei bok er utlånt. Kolonnen utlånt for det aktuelle eksemplaret skal settes lik navnet til låneren. */
    public boolean lånUtEksemplar(String isbn, String navn, int eksNr) {
        String sqlsetn = "update eksemplar set laant_av = " + "'" + navn + "'" + " where isbn = " + "'"+ isbn +"'" + " and eks_nr = " + eksNr;
        try {
            Statement setning = forbindelse.createStatement();
            setning.executeUpdate(sqlsetn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Det er FEL i laantUtEksemplar");
        }
        return false;
    }

    /*  Gaar gjennom Database og sjekker ISBN
        Finner ISBN: return true;
        Finner ikke ISBN: return false;
     */
    public boolean sjekkIsbn(String isbn) {
        String sqlsetning = "select isbn from boktittel";
        System.out.println(sqlsetning);


        String isbnStuff = null;
        ResultSet res = null;
        Statement setning = null;
        try {
            setning = forbindelse.createStatement();
            res = setning.executeQuery(sqlsetning);
            while (res.next()) {
                isbnStuff = res.getString("isbn");
                if (isbnStuff.compareTo(isbn) == 0) {
                    System.out.println("Bokji finnast fra für af");
                    return true;
                }
                System.out.println(isbnStuff);
//                isbnListe.add(isbnStuff);
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Noget gikk til helvett med ISBN");
        }
        return false;
    }
}