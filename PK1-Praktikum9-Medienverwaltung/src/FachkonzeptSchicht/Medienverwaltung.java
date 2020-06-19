package FachkonzeptSchicht;

import FachkonzeptSchicht.Exceptions.EmptyFileNameException;
import DatenhaltungsSchicht.Bild;
import DatenhaltungsSchicht.Medium;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Medienverwaltung{

    private ArrayList<Medium> list;

    public Medienverwaltung(){

         this.list = new ArrayList<>();
    }

    /*public void aufnehmen(Medium m){

        this.list.add(m);
    }

    public void zeigeMedien(){

        Collections.sort(list);
        for(Medium m : this.list){

            m.druckeDaten(System.out);
        }
    }*/

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
                String str = "";
                for(Medium m: this.list) {

                    //noinspection StringConcatenationInLoop
                    str += m.druckeDaten();
                }

                Medium.printData(fos, str);
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

    public Medium sucheNeuesMedium(){

        Collections.sort(list);
        Iterator<Medium> it = this.list.iterator();
        Medium last = new Bild("",0,"");

        if(it.hasNext()) {

            while(it.hasNext()){

                last = it.next();
            }

            return last;
        } else {

            return null;
        }
    }

    public void setList(ArrayList<Medium> list) {
        this.list = list;
    }

    public List<Medium> getList() {

        return this.list;
    }

   /* public Iterator<Medium> iterator() {
        return list.iterator();
    }*/
}
