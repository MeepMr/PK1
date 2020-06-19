package DatenhaltungsSchicht;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Bild extends Medium implements Serializable {

    private  String ort;
    private static final long serialVersionUID = -729034045372955690L;

    public Bild () {

        super("Titel",0);
        this.ort = "Ort";
    }

    public Bild (String titel, int jahr, String ort){

        super(titel, jahr);
        this.ort = ort;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public void druckeDaten(OutputStream stream) {

        String str = "ID = " + super.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr() + " in " + this.ort + "\n";
        printData(stream, str);

    }

    @Override
    public String druckeDaten () {

        return "ID = " + super.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr() + " in " + this.ort + "\n";
    }

    @Override
    public int hashCode(){

        return super.hashCode()+ Objects.hash(ort);
    }

    @Override
    public boolean equals(Object o){

        if(super.equals(o)) {

            Bild bild = (Bild) o;

            return (bild.ort.equals(ort));
        } else return false;
    }

    @Override
    public String toString() {
        return "ID = " + super.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr() + " in " + this.ort + "\n";
    }
}
