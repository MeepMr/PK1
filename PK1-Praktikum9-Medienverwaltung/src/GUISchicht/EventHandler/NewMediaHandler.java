package GUISchicht.EventHandler;

import DatenhaltungsSchicht.Medium;
import FachkonzeptSchicht.Medienverwaltung;
import GUISchicht.MessageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class NewMediaHandler implements EventHandler<ActionEvent> {

    private final Medienverwaltung mv;
    private final Stage stage;

    public NewMediaHandler (Medienverwaltung mv, Stage stage) {

        this.mv = mv;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Medium newMedium = mv.sucheNeuesMedium();
        MessageView messageView = MessageView.create(this.stage, "Error", newMedium.druckeDaten());
        messageView.showView();


    }
}
