import java.io.OutputStream;
import java.util.Objects;

public class Audio extends Medium {

    private final String interpret;
    private final int dauer;

    public Audio (String titel, int jahr, String interpret, int dauer){

        super(titel, jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    @Override
    public void druckeDaten (OutputStream stream) {

        String str = "ID = " + super.getId() + " \"" + super.getTitel() + "\" von " + this.interpret + " aus " + super.getJahr() + " Spieldauer: " + this.dauer + " sek.";
        super.printData(stream, str);
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
}
