import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Medienverwaltung m = new Medienverwaltung();
        Menu me = new Menu(m);
        Scanner sc = new Scanner(System.in);

        do {

            me.prntMenu();
            int c = sc.nextInt();
            if(c >= 1 && c <= 6){
                me.action(c);
            }
        } while (!me.exit);

        /*
        Bild b1 = new Bild("Bild 1", 1990, "Ort 1");
        Bild b2 = new Bild("Bild 2", 1992, "Ort 2");
        Bild b3 = new Bild("Bild 3", 1994, "Ort 3");
        Bild b4 = new Bild("Bild 4", 1996, "Ort 4");


        Medienverwaltung med = new Medienverwaltung();

        med.aufnehmen(b1);
        med.aufnehmen(b4);
        med.aufnehmen(b3);
        med.aufnehmen(b2);

        med.zeigeMedien();
        med.sucheNeuesMedium();
        System.out.println(med.berechneErscheinungsjahr());
        med.zeigeMedien();
         */
    }
}
