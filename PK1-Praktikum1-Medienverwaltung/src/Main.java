public class Main {

    public static void main(String[] args) {

        System.out.println(new Audio("Hey", 2009, "Tet", 120).equals(new Audio("Hey", 2009, "Test", 120)));
        System.out.println(new Audio("Hey", 2009, "Tet", 120).hashCode());
        System.out.println(new Audio("Hey", 2009, "Tet", 120).hashCode());
        System.out.println(new Audio("Hey", 2009, "Tet", 120).hashCode());
        new Bild("Bild 1", 1999, "Test");
        new Audio("Hey", 2010, "Tet", 119).druckeDaten();
        System.out.println(new Audio("Hey", 2010, "Tet", 119).alter());
    }
}
