package GUISchicht.EventHandler;

import DatenhaltungsSchicht.Audio;
import DatenhaltungsSchicht.Medium;

import GUISchicht.AudioErfassungView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class NewAudioHandler implements EventHandler<ActionEvent> {

    final private Stage stage;
    private final ObservableList<Medium> list;

    public NewAudioHandler(Stage stage, ObservableList<Medium> list){

        this.stage = stage;
        this.list = list;
//        this.aew = new AudioErfassungView(new Audio(), this.stage, this.list);
    }

    /*public NewAudioHandler(Stage stage, Audio a, ObservableList<Medium> list){

        this.stage = stage;
        this.list = list;
    }*/

    @Override
    public void handle(ActionEvent actionEvent) {

        AudioErfassungView aew = new AudioErfassungView(new Audio(), this.stage, this.list);
        aew.showView();
    }
}
