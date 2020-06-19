package GUISchicht.EventHandler;

import DatenhaltungsSchicht.Medium;
import DatenhaltungsSchicht.Serializierung;
import FachkonzeptSchicht.Medienverwaltung;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class LadenHandler implements EventHandler<ActionEvent> {

    final private Medienverwaltung mv;
    final private Serializierung serializierung = new Serializierung();

    public LadenHandler(Medienverwaltung mv) {

        this.mv = mv;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("Loading Handled");
        mv.setList((ArrayList<Medium>) serializierung.laden());
    }
}
