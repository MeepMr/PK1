public class Bild extends Medium {

    private final String ort;

    public Bild (String titel, int jahr, String ort){

        super(titel, jahr);
        this.ort = ort;
    }

    @Override
    public void druckeDaten() {
        System.out.println("ID = " + super.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr() + " in " + this.ort);
    }

    @Override
    public boolean equals(Object o){

        if(super.equals(o)) {

            Bild bild = (Bild) o;

            return (bild.ort.equals(ort));
        } else return false;
    }
}
