package GUISchicht;

import DatenhaltungsSchicht.Bild;
import DatenhaltungsSchicht.Medium;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BildErfassungView  extends Stage {

    private final Stage stage;
    private final Bild bild;
    private final ObservableList<Medium> list;


    public BildErfassungView(Bild bild, Stage stage, ObservableList<Medium> list){

        this.list = list;
        this.stage = stage;
        this.bild = bild;
    }

    public void showView(){

/*        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);*/

        GridPane gridPane = new GridPane();

        Label lTitel = new Label("Titel:");
        Label lOrt = new Label("Ort:");
        Label lJahr = new Label("Aufnahmejahr:");

        TextField tfTitel = new TextField(bild.getTitel());
        TextField tfOrt = new TextField(bild.getOrt());
        TextField tfJahr = new TextField("" + bild.getJahr());

        Button b1 = new Button("Neu");
        Button b2 = new Button("Abbrechen");

        gridPane.add(lTitel, 0,0);
        gridPane.add(tfTitel, 1,0, 2, 1);
        gridPane.add(lOrt, 0,1);
        gridPane.add(tfOrt, 1, 1, 2, 1);
        gridPane.add(lJahr, 0,2);
        gridPane.add(tfJahr,1,2, 2, 1);
        gridPane.add(b1, 2,4);
        gridPane.add(b2, 3,4);

        Scene scene = new Scene(gridPane);
        this.setScene(scene);
        this.show();


        b1.setOnAction(actionEvent -> {
            bild.setOrt(tfOrt.getText());
            bild.setTitel(tfTitel.getText());
            try {
                bild.setJahr(Integer.parseInt(tfJahr.getText()));
                System.out.println(bild.druckeDaten());
                list.add(bild);
                close();
            } catch (NumberFormatException e) {
                MessageView messageView = MessageView.create(stage, "Error", "Ungültige Eingabe");
                messageView.showView();
            }
        });

        b2.setOnAction(actionEvent -> close());

    }

/*
    public Bild getBild() {
        return bild;
    }
*/
}
