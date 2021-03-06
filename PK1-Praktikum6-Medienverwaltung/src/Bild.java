import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Bild extends Medium implements Serializable {

    private  String ort;
    private static final long serialVersionUID = -729034045372955690L;

    public Bild (String titel, int jahr, String ort){

        super(titel, jahr);
        this.ort = ort;
    }

    @Override
    public void druckeDaten(OutputStream stream) {

        String str = "ID = " + super.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr() + " in " + this.ort + "\n";
        super.printData(stream, str);

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
}
