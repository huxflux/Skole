package Oving_4;

/*
 * VisDatabaseClient.java
 *
 * Programmet kopler seg til databasetjener, og henter ut innholdet i tabellen Person.
 *
 */
import static javax.swing.JOptionPane.*;

import java.sql.*;
class VisDatabaseClient {
  public static void main(String[] args) throws Exception {
    String isbn = null;
    String databasedriver = "org.apache.derby.jdbc.ClientDriver";
    Class.forName(databasedriver);  // laster inn driverklassen

    String databasenavn = "jdbc:derby://localhost:1527/Oving_db;user=db;password=db";
    Connection forbindelse = DriverManager.getConnection(databasenavn);

    Statement setning = forbindelse.createStatement();

    isbn = showInputDialog(null, "Tast inn ISBN nummer");
    ResultSet res = setning.executeQuery("select forfatter, tittel from boktittel where isbn = " + "'" + isbn + "'");
        res.next();
        String forfatter = res.getString("forfatter");
        String tittel = res.getString("tittel");
        res.close();
        ResultSet res2 = setning.executeQuery("select count(*) antall from eksemplar where isbn = '" + isbn + "'");
        res2.next();
        int num = res2.getInt("antall");
        res2.close();
        System.out.println("Navn: " + forfatter + "\nTittel: " + tittel + "\nAntall: " + num);


        setning.close();
        forbindelse.close();
    }
}

/* Utskrift fra programmet:
100: Ole Hansen
101: Anne Grethe �s
102: Jonny Hansen
*/