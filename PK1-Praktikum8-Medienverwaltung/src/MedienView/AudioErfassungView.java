package MedienView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Medien.Audio;

import javax.swing.*;


public class AudioErfassungView  extends Stage {

    private Stage stage;
    private Scene scene;
    private GridPane gridPane;
    private Audio audio;

    public AudioErfassungView(Audio audio, Stage stage){

        this.stage = stage;
        this.audio = audio;
    }

    public void showView(){

        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);

        gridPane = new GridPane();

        Label lTitel = new Label("Titel:");
        Label lInterpret = new Label("Ort:");
        Label lJahr = new Label("Aufnahmejahr:");
        Label lDauer = new Label("Dauer:");

        TextField tfTitel = new TextField();
        TextField tfInterpret = new TextField();
        TextField tfJahr = new TextField();
        TextField tfDauer = new TextField();

        Button b1 = new Button("Neu");
        Button b2 = new Button("Abbrechen");

        gridPane.add(lTitel, 0,0);
        gridPane.add(tfTitel, 1,0, 2, 1);
        gridPane.add(lInterpret, 0,1);
        gridPane.add(tfInterpret, 1, 1, 2, 1);
        gridPane.add(lJahr, 0,2);
        gridPane.add(tfJahr,1,2, 2, 1);
        gridPane.add(lDauer, 0,3);
        gridPane.add(tfDauer,1,3,2,1);
        gridPane.add(b1, 2,4);
        gridPane.add(b2, 3,4);

        scene = new Scene(gridPane);
        this.setScene(scene);
        this.show();


        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                audio.setInterpret(tfInterpret.getText());
                audio.setTitel(tfTitel.getText());
                try {
                    audio.setJahr(Integer.parseInt(tfJahr.getText()));
                    audio.setDauer(Integer.parseInt(tfDauer.getText()));
                    close();
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ungültige Eingabe");
                }
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                close();
            }
        });

    }
}
