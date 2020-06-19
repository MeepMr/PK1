import javax.swing.*;

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

            case 1: addAudio(); break;
            case 2: addBild(); break;
            case 3: m.zeigeMedien(); break;
            case 4: m.sucheNeuesMedium(); break;
            case 5: System.out.println("Durchschnittliches Erscheinungsjahr: " + m.berechneErscheinungsjahr()); break;
            case 6: this.exit = true; break;
            default: System.out.println(iSelection + " Err");break;
        }
    }

    private void addBild(){
        m.aufnehmen(new Bild(JOptionPane.showInputDialog("Bitte Titel eingeben:"),
                    Integer.parseInt(JOptionPane.showInputDialog("Bitte Jahr eingeben")),
                    JOptionPane.showInputDialog("Bitte Ort eingeben:")));
    }

    private void addAudio(){
        m.aufnehmen(new Audio(JOptionPane.showInputDialog("Bitte Titel eingeben:"),
                Integer.parseInt(JOptionPane.showInputDialog("Bitte Jahr eingeben")),
                JOptionPane.showInputDialog("Bitte Interpreten eingeben:"),
                Integer.parseInt(JOptionPane.showInputDialog("Bitte Dauer eingeben"))));

    }
}
