package GUISchicht;

import DatenhaltungsSchicht.Audio;
import DatenhaltungsSchicht.Medium;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class AudioErfassungView  extends Stage {

    private final Stage stage;
    private final Audio audio;
    private final ObservableList<Medium> list;

    public AudioErfassungView(Audio audio, Stage stage, ObservableList<Medium> list){

        this.list = list;
        this.stage = stage;
        this.audio = audio;
    }

    public void showView(){

        /*this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);*/

        GridPane gridPaneAudio = new GridPane();

        Label lTitel = new Label("Titel:");
        Label lInterpret = new Label("Ort:");
        Label lJahr = new Label("Aufnahmejahr:");
        Label lDauer = new Label("Dauer:");

        TextField tfTitel = new TextField(audio.getTitel());
        TextField tfInterpret = new TextField(audio.getInterpret());
        TextField tfJahr = new TextField(""+audio.getJahr());
        TextField tfDauer = new TextField(""+audio.getDauer());


        Button b3 = new Button("Neu");
        Button b4 = new Button("Abbrechen");

        gridPaneAudio.add(lTitel, 0,0);
        gridPaneAudio.add(tfTitel, 1,0, 2, 1);
        gridPaneAudio.add(lInterpret, 0,1);
        gridPaneAudio.add(tfInterpret, 1, 1, 2, 1);
        gridPaneAudio.add(lJahr, 0,2);
        gridPaneAudio.add(tfJahr,1,2, 2, 1);
        gridPaneAudio.add(lDauer, 0,3);
        gridPaneAudio.add(tfDauer,1,3,2,1);
        gridPaneAudio.add(b3, 2,4);
        gridPaneAudio.add(b4, 3,4);

        Scene scene = new Scene(gridPaneAudio);
        this.setScene(scene);
        this.show();


        b3.setOnAction(actionEvent -> {
            audio.setInterpret(tfInterpret.getText());
            audio.setTitel(tfTitel.getText());
            try {
                audio.setJahr(Integer.parseInt(tfJahr.getText()));
                audio.setDauer(Integer.parseInt(tfDauer.getText()));
                System.out.println(audio.druckeDaten());
                list.add(audio);
                close();
            } catch (NumberFormatException e){
                MessageView messageView = MessageView.create(AudioErfassungView.this.stage, "Error", "Ungültige Eingabe");
                messageView.showView();
            }
        });

        b4.setOnAction(actionEvent -> close());

    }
}
