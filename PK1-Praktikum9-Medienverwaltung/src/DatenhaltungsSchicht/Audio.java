package DatenhaltungsSchicht;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Audio extends Medium implements Serializable {

    private  String interpret;
    private  int dauer;
    private static final long serialVersionUID = -729034045372955790L;

    public Audio() {

        super("Titel",0);
        this.interpret = "Interpret";
        this.dauer = 0;
    }

    public Audio (String titel, int jahr, String interpret, int dauer){

        super(titel, jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    public int getDauer() {
        return dauer;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    @Override
    public void druckeDaten (OutputStream stream) {

        String str = "ID = " + super.getId() + " \"" + super.getTitel() + "\" von " + this.interpret + " aus " + super.getJahr() + " Spieldauer: " + this.dauer + " sek.\n";
        printData(stream, str);
    }

    @Override
    public String druckeDaten () {

        return "ID = " + super.getId() + " \"" + super.getTitel() + "\" von " + this.interpret + " aus " + super.getJahr() + " Spieldauer: " + this.dauer + " sek.\n";
    }

    @Override
    public int hashCode(){

        return super.hashCode()+ Objects.hash(interpret, dauer);
    }

    @Override
    public boolean equals(Object o){

        if(super.equals(o)){

            Audio audio = (Audio) o;

            return (audio.dauer == dauer && audio.interpret.equals(interpret));
        } else return false;
    }

    @Override
    public String toString(){
        return "ID = " + super.getId() + " \"" + super.getTitel() + "\" von " + this.interpret + " aus " + super.getJahr() + " Spieldauer: " + this.dauer + " sek.\n";
    }
}
