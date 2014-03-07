package Oving_17;

public class TestKlient {
    public static void main(String[] args) throws Exception{
        String dbDriver = "org.apache.derby.jdbc.ClientDriver";
        String dbNavn = "jdbc:derby://localhost:1527/Oving_db;user=db;password=db";

        Bok bok1 = new Bok("3413", "Ich bin eine berlinerbolle", "Djon Djincho");
        Bok bok2 = new Bok("666", "HEIL HITLAHHHH", "J0rgen Hitler");

        System.out.println("sk");
        Database database = new Database(dbDriver, dbNavn);
        database.regNyBok(bok1);
//        database.lukkForbindelse();
        database.regNyBok(bok2);
        database.lukkForbindelse();
    }
}
