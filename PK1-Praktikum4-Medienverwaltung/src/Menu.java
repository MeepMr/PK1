import javax.swing.*;
import java.util.InputMismatchException;

public class Menu {

    private final Medienverwaltung m;
    protected boolean exit = false;

    public Menu(Medienverwaltung m){

        this.m = m;
    }

    public void prntMenu(){

        System.out.println( "Medienverwaltung: \n" +
                            "\n" +
                            "1. Audio aufnehmen\n" +
                            "2. Bild aufnehmen\n" +
                            "3. Zeige alle Medien\n" +
                            "4. Zeige neues Medium\n" +
                            "5. Bereche durschnittliches Erscheinungsjahr\n" +
                            "6. Beenden");
    }

    public void action(int iSelection) {

        switch (iSelection){

            case 1: addMedium(1); break;
            case 2: addMedium(0); break;
            case 3: m.zeigeMedien(); break;
            case 4: m.sucheNeuesMedium(); break;
            case 5: System.out.println("Durchschnittliches Erscheinungsjahr: " + m.berechneErscheinungsjahr()); break;
            case 6: this.exit = true; break;
            default: System.out.println(iSelection + " Err");break;
        }
    }

    private void addMedium(int iSelection) {

        String [] strings = {"Titel", "Interpret", "Ort", "Jahr", "Dauer"};
        int [] ints = new int[2];
        boolean error = false, bCut = true;
        int cntr = 0;

        do{

            if(iSelection == 0){

                switch (cntr){
                    case 0: strings[0] = eingabe("Titel"); break;
                    case 1: strings[2] = eingabe("Ort"); break;
                    case 2: strings[3] = eingabe("Jahr"); break;
                    default: bCut = false; break;
                }

                if(cntr == 2){

                    try {

                        ints[0] = Integer.parseInt(strings[3]);

                        cntr++;
                    } catch (InputMismatchException e) {

                        error("Jahr");
                    }
                } else {

                    cntr++;
                }

                if(strings[0] == null || strings[2] == null || strings[3] == null){

                    error = true;
                }
            } else if (iSelection == 1) {

                switch (cntr) {

                    case 0: strings[0] = eingabe("Titel"); break;
                    case 1: strings[1] = eingabe("Interpret"); break;
                    case 2: strings[3] = eingabe("Jahr"); break;
                    case 3: strings[4] = eingabe("Dauer"); break;
                    default: bCut = false; break;
                }

                if(cntr == 2 || cntr == 3){

                    try {
                        switch (cntr) {
                            case 2: ints[0] = Integer.parseInt(strings[3]); break;
                            case 3: ints[1] = Integer.parseInt(strings[4]); break;
                            default: break;
                        }

                        cntr++;
                    } catch (InputMismatchException e) {

                        switch (cntr) {
                            case 2: error("Jahr"); break;
                            case 3: error("Dauer"); break;
                        }
                    }
                } else {

                    cntr++;
                }

                if(strings[0] == null || strings[1] == null || strings[3] == null || strings[4] == null){

                    error = true;
                }
            }
        }while (!error && bCut);

        switch (iSelection) {
            case 0: m.aufnehmen(new Bild(strings[0], ints[0], strings[2])); break;
            case 1: m.aufnehmen(new Audio(strings[0],ints[0], strings[1], ints[1])); break;
        }
    }

    private String eingabe(String sText) {

        return JOptionPane.showInputDialog("Bitte " + sText + " eingeben: ");
    }

    private void error(String sError){

        JOptionPane.showMessageDialog(null,"Fehler bei der Eingabe von " + sError);
    }
}
