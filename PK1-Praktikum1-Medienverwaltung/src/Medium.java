import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium {

    private static int cntr;
    private final int id;
    private final String titel;
    private final int jahr;

    public Medium(String titel, int jahr){

        this.titel = titel;
        this.jahr = jahr;
        this.id = cntr++;
    }

    public int alter(){

        return LocalDate.now().getYear() - jahr;
    }

    public abstract void druckeDaten();

    public String getTitel() {
        return titel;
    }

    public int getJahr() {
        return jahr;
    }

    public int getId() {

        return id;
    }

    public int hashCode(){

        return Objects.hash(titel, jahr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medium medium = (Medium) o;
        return  jahr == medium.jahr &&
                titel.equals(medium.titel);
    }
}
