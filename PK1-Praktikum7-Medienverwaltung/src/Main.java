import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Medienverwaltung m = new Medienverwaltung();
        Menu me = new Menu(m);
        Scanner sc = new Scanner(System.in);

        Bild b1 = new Bild("Bild 1", 1990, "Ort 1");
        Bild b2 = new Bild("Bild 2", 1992, "Ort 2");
        Bild b3 = new Bild("Bild 3", 1994, "Ort 3");
        Bild b4 = new Bild("Bild 4", 1996, "Ort 4");

        m.aufnehmen(b1);
        m.aufnehmen(b4);
        m.aufnehmen(b3);
        m.aufnehmen(b2);

        do {

            me.prntMenu();
            int c;
            try {

                c = sc.nextInt();
            } catch (InputMismatchException e) {

                System.out.println("Eingabe war keine Zahl");
                c = 0;
            }
            if(c >= 1 && c <= 9){
                me.action(c);
            }
        } while (!me.exit);

        sc.close();


        /*
        med.zeigeMedien();
        med.sucheNeuesMedium();
        System.out.println(med.berechneErscheinungsjahr());
        med.zeigeMedien();
         */
    }
}
