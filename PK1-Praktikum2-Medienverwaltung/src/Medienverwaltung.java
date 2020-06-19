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

        if(it.hasNext()) {

            it.next().druckeDaten();
        } else {

            System.out.println("Es existieren noch kiene Medien");
        }
    }

}
