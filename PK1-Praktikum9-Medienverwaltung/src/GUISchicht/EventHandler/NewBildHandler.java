package GUISchicht.EventHandler;

import DatenhaltungsSchicht.Bild;
import DatenhaltungsSchicht.Medium;
import GUISchicht.BildErfassungView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class NewBildHandler implements EventHandler<ActionEvent> {

    final private Stage stage;
    private final ObservableList<Medium> list;

    public NewBildHandler (Stage stage, ObservableList<Medium> list) {

        this.stage = stage;
        this.list = list;
    }

    /*public NewBildHandler (Stage stage, Bild b, ObservableList<Medium> list) {

        this.stage = stage;
        this.list = list;
    }*/

    @Override
    public void handle(ActionEvent actionEvent) {

        BildErfassungView bew = new BildErfassungView(new Bild(), this.stage, this.list);
        bew.showView();
    }
}
