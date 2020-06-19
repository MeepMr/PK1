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

            m.druckeDaten();
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

            last.druckeDaten();
        } else {

            System.out.println("Es existieren noch kiene Medien");
        }
    }

}
