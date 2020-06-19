import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class BildErfassungView  extends Stage {

    private Stage stage;
    private Scene scene;
    private GridPane gridPane;

    public BildErfassungView(Bild bild, Stage stage){

        this.stage = stage;
    }

    public void showView(){

        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);

        gridPane = new GridPane();

        Label lTitel = new Label("Titel:");
        Label lOrt = new Label("Ort:");
        Label lJahr = new Label("Aufnahmejahr:");

        TextField tfTitel = new TextField();
        TextField tfOrt = new TextField();
        TextField tfJahr = new TextField();

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

        scene = new Scene(gridPane);
        this.setScene(scene);
        this.show();
    }
}
