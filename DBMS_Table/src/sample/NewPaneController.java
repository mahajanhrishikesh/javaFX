package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class NewPaneController {

    public Button chgScnBtn;

    public void changeSceneButtonPushed(ActionEvent actionEvent) throws IOException {
        Parent backtomain = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene backtomainScene = new Scene(backtomain);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(backtomainScene);
        mainwindow.show();

    }
}
