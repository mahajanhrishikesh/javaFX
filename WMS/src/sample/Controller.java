package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    public Button enterBtn;


    public void enter(ActionEvent actionEvent) throws IOException {

        Parent view = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(view);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();

    }
}
