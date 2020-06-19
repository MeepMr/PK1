import Medien.Audio;
import Medien.Bild;
import MedienView.AudioErfassungView;
import MedienView.BildErfassungView;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javax.sound.sampled.AudioFileFormat;

public class MainWindow extends Application {

    public void start(Stage primaryStage) throws Exception{

        Bild b1 = new Bild("Medien.Bild 1", 1990, "Ort 1");
        Audio a1 = new Audio("Audio1", 1234,"Interpret",234);

        BildErfassungView b = new BildErfassungView(b1, primaryStage);
        AudioErfassungView a = new AudioErfassungView(a1, primaryStage);

        MenuBar mbMenu = new MenuBar();

        Menu mDatei = new Menu("Datei");
        MenuItem miLaden = new MenuItem("Laden");
        MenuItem miSpeichern = new MenuItem("Speichern");
        SeparatorMenuItem miSeparator1 = new SeparatorMenuItem();
        MenuItem miMedienListe = new MenuItem("Medienliste in Datei");
        SeparatorMenuItem miSeparator2 = new SeparatorMenuItem();
        MenuItem miBeenden = new MenuItem("Beenden");
        mDatei.getItems().addAll(miLaden, miSpeichern, miSeparator1, miMedienListe, miSeparator2, miBeenden);

        Menu mMedium = new Menu("Medium");
        MenuItem miAudio = new MenuItem("Audio hinzufügen");
        MenuItem miBild = new MenuItem("Bild hinzufügen");
        mMedium.getItems().addAll(miAudio, miBild);

        Menu mAnzeige = new Menu("Anzeige");
        MenuItem miErscheinungsjahr = new MenuItem("Erscheinungsjahr");
        MenuItem miNeustesMedium = new MenuItem("Neustes Medium");
        mAnzeige.getItems().addAll(miErscheinungsjahr, miNeustesMedium);

        mbMenu.getMenus().addAll(mDatei, mMedium, mAnzeige);

        GridPane gpMain = new GridPane();
        gpMain.add(mbMenu, 0,0);

        Scene sc = new Scene(gpMain, 711,400);
        primaryStage.setScene(sc);
        primaryStage.show();

       // b.showView();
    }
}
