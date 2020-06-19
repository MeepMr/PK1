import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Test extends Application {

    public void start(Stage primaryStage) throws Exception{

        BildErfassungView b = new BildErfassungView(null, primaryStage);

        Pane x = new Pane();
        Scene sc = new Scene(x, 100,100);
        primaryStage.setScene(sc);
        primaryStage.show();

        b.showView();
    }
}
