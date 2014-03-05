package Oving_12;

public class TestKlient {
        public static void main(String[] args) throws Exception{
            MedlemsArkiv medlemsArkiv = new MedlemsArkiv();

            Personalia kunta = new Personalia("Kunta", "Kinta", "kunta@zimbabwe.bw", "kunta");
            Personalia larry = new Personalia("Larry", "Laffer", "allowe@sierra.com", "Ken sent me");
            Personalia roger = new Personalia("Roger", "Wilco", "rogerwilco@spacejanitor.sarien.sf", "two guys from andromeda");

            Dato dato = new Dato("01012014");
            Dato dato2 = new Dato("14022014");

            /* legger til nye medlemmer */
            int medlNrKunta = medlemsArkiv.nyMedlem(kunta, dato);
            int medlNrLarry = medlemsArkiv.nyMedlem(larry, dato);
            int medlNrRoger = medlemsArkiv.nyMedlem(roger, dato);
            System.out.println(medlemsArkiv);

            /* registrerer poeng og oppdaterer medlemmene */
            medlemsArkiv.registrerPoeng(medlNrKunta, 1);
            medlemsArkiv.registrerPoeng(medlNrLarry, 30000);
            medlemsArkiv.registrerPoeng(medlNrRoger, 74000);
            medlemsArkiv.sjekkMedlemmer(dato2);
            System.out.println(medlemsArkiv);

            /* legger til poeng oppdaterer medlemmene */
            medlemsArkiv.registrerPoeng(medlNrKunta, 74999);
            medlemsArkiv.registrerPoeng(medlNrLarry, 30000);
            medlemsArkiv.registrerPoeng(medlNrRoger, 10000);
            medlemsArkiv.sjekkMedlemmer(dato2);
            System.out.println(medlemsArkiv);
        }
    }
