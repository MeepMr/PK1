package GUISchicht.EventHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ExitHandler implements EventHandler<ActionEvent> {

    private final Stage stage;

    public ExitHandler(Stage stage) {

        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("Exit Handled");
        stage.close();
    }
}
