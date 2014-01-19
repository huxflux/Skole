package Oving_4;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static javax.swing.JOptionPane.showInputDialog;

public class SkrivInnToillj {
    public static void main(String[] args) throws Exception {
        String databasedriver = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(databasedriver);  // laster inn driverklassen

        String databasenavn = "jdbc:derby://localhost:1527/oving_db;user=db;password=db";

        Connection forbindelse = DriverManager.getConnection(databasenavn);

        Statement setning = forbindelse.createStatement();

        String navnLest = showInputDialog("Skriv inn navn: ");
        String isbnLest = showInputDialog("Skriv inn ISBN: ");
        //String eksemplarLest = showInputDialog("Sriv inn eksemplarnummer: ");

        if(setning.executeUpdate("update eksemplar set laant_av = '" + navnLest + "' where isbn = '" + isbnLest + "' and eks_nr = 1 and laant_av is null") == 0) {
            System.out.println("Ikke registrert!");
        } else {
            System.out.println("Registering vellykket!");
        }
        setning.close();
        forbindelse.close();
    }
}