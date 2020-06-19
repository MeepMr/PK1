import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Medienverwaltung {

    ArrayList<Medium> list;

    public Medienverwaltung(){

         this.list = new ArrayList<>();
    }

    public void aufnehmen(Medium m){

        this.list.add(m);
    }

    public void zeigeMedien(){

        Collections.sort(list);
        for(Medium m : this.list){

            m.druckeDaten(System.out);
        }
    }

    public void writeData() {

        int check = 0;
        String sName;

        do {

            sName = JOptionPane.showInputDialog("Bitte Dateinamen eingeben");

            try {

                if (sName == null) {

                    return;
                } else if (sName.equals("")) {

                    throw new EmptyFileNameException();
                } else {

                    check = 1;
                }
            } catch (EmptyFileNameException e) {

                int choice = JOptionPane.showConfirmDialog(null,"Dateiname ist leer. Neuen Namen eingeben?");
                if(choice != 0) {

                    return;
                }
            }
        } while (check == 0);

            try(FileOutputStream fos = new FileOutputStream("/home/mrmeep/"+sName)){

                Collections.sort(list);
                for(Medium m: this.list) {

                    m.druckeDaten(fos);
                }
            } catch (IOException e) {

                System.out.println("Error finding File");
            }
    }

    public double berechneErscheinungsjahr(){

        Iterator<Medium> it = this.list.iterator();
        int cntr = 0;
        int value = 0;
        while (it.hasNext()){

            value += it.next().getJahr();
            cntr++;
        }

        if(cntr == 0) {
            return 0;
        } else {

            return value/(float)cntr;
        }
    }

    public void sucheNeuesMedium(){

        Collections.sort(list);
        Iterator<Medium> it = this.list.iterator();
        Medium last = new Bild("",0,"");

        if(it.hasNext()) {

            while(it.hasNext()){

                last = it.next();
            }

            last.druckeDaten(System.out);
        } else {

            System.out.println("Es existieren noch kiene Medien");
        }
    }

}
