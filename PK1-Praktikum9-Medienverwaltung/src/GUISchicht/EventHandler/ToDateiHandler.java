package GUISchicht.EventHandler;

import FachkonzeptSchicht.Medienverwaltung;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ToDateiHandler implements EventHandler<ActionEvent> {

    private final Medienverwaltung medienverwaltung;

    public ToDateiHandler(Medienverwaltung mv) {

        this.medienverwaltung = mv;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        medienverwaltung.writeData();
    }
}
