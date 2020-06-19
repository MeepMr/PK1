package GUISchicht.EventHandler;

import FachkonzeptSchicht.Medienverwaltung;
import GUISchicht.MessageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ErscheinungsJahrHandler implements EventHandler<ActionEvent> {

    final private Medienverwaltung medienverwaltung;
    final Stage stage;

    public ErscheinungsJahrHandler(Medienverwaltung mv, Stage stage) {

        this.medienverwaltung = mv;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        double dJahr = medienverwaltung.berechneErscheinungsjahr();
        MessageView messageView = MessageView.create(this.stage, "Erscheinungsjahr", "Durchschnittliches Erscheinungsjahr: " + dJahr);
        messageView.showView();
    }
}
