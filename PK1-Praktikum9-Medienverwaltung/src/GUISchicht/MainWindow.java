package GUISchicht;

import DatenhaltungsSchicht.Audio;
import DatenhaltungsSchicht.Bild;
import DatenhaltungsSchicht.Medium;
import FachkonzeptSchicht.Medienverwaltung;
import GUISchicht.EventHandler.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainWindow extends Application {

    static Medienverwaltung mv;
    private final int width = 711;

    public void start(Stage primaryStage){

        mv = new Medienverwaltung();
        ObservableList<Medium> obList = FXCollections.observableArrayList(mv.getList());
        obList.addListener((ListChangeListener<Medium>) change -> {

            while(change.next()) {

                if(change.wasAdded()) {
                    mv.getList().addAll(change.getAddedSubList());
                }
            }
        });

        Bild b1 = new Bild("Bild 1", 1990, "Ort 1");
        obList.add(b1);
        Audio a1 = new Audio("Audio1", 1234,"Interpret",234);
        obList.add(a1);

        MenuBar mbMenu = menuBar(primaryStage, obList);

        ListView<Medium> lvMedien= listViewMedien();



        lvMedien.setItems(obList);

        GridPane gpMain = new GridPane();
        gpMain.add(mbMenu, 0,0,1,1);
        gpMain.add(lvMedien, 0,1,2,1);

        int height = 400;
        Scene sc = new Scene(gpMain, width, height);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    private ListView<Medium> listViewMedien() {
        ListView<Medium> lvMedien= new ListView<>();
        lvMedien.setFixedCellSize(25);
        lvMedien.setPrefWidth(width);
        return lvMedien;
    }

    private MenuBar menuBar(Stage primaryStage, ObservableList<Medium> obList) {

        MenuBar mb = new MenuBar();

        Menu mDatei = menuDatei(primaryStage);
        Menu mMedium = menuMedium(primaryStage, obList);
        Menu mAnzeige = menuAnzeige(primaryStage);
        mb.getMenus().addAll(mDatei, mMedium, mAnzeige);
        mb.setPrefWidth(width);

        return mb;
    }

    private Menu menuAnzeige(Stage primaryStage) {

        Menu menu = new Menu("Anzeige");

        MenuItem miErscheinungsjahr = new MenuItem("Erscheinungsjahr");
        miErscheinungsjahr.setOnAction(new ErscheinungsJahrHandler(mv, primaryStage));


        MenuItem miNeustesMedium = new MenuItem("Neustes Medium");
        miNeustesMedium.setOnAction(new NewMediaHandler(mv, primaryStage));

        menu.getItems().addAll(miErscheinungsjahr, miNeustesMedium);
        return menu;
    }

    private Menu menuMedium (Stage primaryStage, ObservableList<Medium> obList) {

        Menu menu = new Menu("Medium");

        MenuItem miAudio = new MenuItem("Audio hinzufügen");
        miAudio.setOnAction(new NewAudioHandler(primaryStage, obList));

        MenuItem miBild = new MenuItem("Bild hinzufügen");
        miBild.setOnAction(new NewBildHandler(primaryStage, obList));

        menu.getItems().addAll(miAudio, miBild);
        return menu;
    }

    private Menu menuDatei(Stage primaryStage) {

        Menu menu = new Menu("Datei");

        MenuItem miLaden = new MenuItem("Laden");
        miLaden.setOnAction(new LadenHandler(mv));

        MenuItem miSpeichern = new MenuItem("Speichern");
        miSpeichern.setOnAction(new SpeichernHandler(mv));

        SeparatorMenuItem miSeparator1 = new SeparatorMenuItem();

        MenuItem miMedienListe = new MenuItem("Medienliste in Datei");
        miMedienListe.setOnAction(new ToDateiHandler(mv));

        SeparatorMenuItem miSeparator2 = new SeparatorMenuItem();

        MenuItem miBeenden = new MenuItem("Beenden");
        miBeenden.setOnAction(new ExitHandler(primaryStage));

        menu.getItems().addAll(miLaden, miSpeichern, miSeparator1, miMedienListe, miSeparator2, miBeenden);

        return menu;
    }
}
