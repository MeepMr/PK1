package GUISchicht.EventHandler;

import DatenhaltungsSchicht.Serializierung;
import FachkonzeptSchicht.Medienverwaltung;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SpeichernHandler implements EventHandler<ActionEvent> {

    final private Medienverwaltung mv;
    final private Serializierung serializierung = new Serializierung();

    public SpeichernHandler (Medienverwaltung mv) {

        this.mv = mv;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        serializierung.speichern(mv.getList());
    }
}
