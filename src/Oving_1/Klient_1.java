package Oving_1;

public class Klient_1 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Monolith Burgers", 1989);
        System.out.println(restaurant.toString());

        restaurant.setNavnRestaurant("Phleebut");
        restaurant.reserverBord("Roger Wilco", 3);
        restaurant.reserverBord("Vohaul", 1);
        restaurant.reserverBord("Two guys from Andromeda", 1);
        restaurant.reserverBord("Larry Laffer", 2);
        System.out.println(restaurant.toString());

        restaurant.frigiBordNavn("Roger Wilco");
        System.out.println(restaurant.toString());

      //  String navnPerson = "Larry Laffer";
      //  int[] temp = restaurant.hvilkeBordNavn(navnPerson);
      //  System.out.print(navnPerson + " Har reservert bord: ");
      //  for (int i = 0; i < temp.length; i++) {
      //      System.out.print(i + ", ");
      // }
        // faaeeen
    }

}
