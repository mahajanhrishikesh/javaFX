package dbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class farmer_reg_controller {


    public Button submitBtn;
    public TextField phone_no;
    public TextField f_name;
    public TextField PASS;
    public TextField USERNAME;

    public void goBackHome(ActionEvent actionEvent) throws IOException {
        Parent home_View = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        Scene home_ViewScene = new Scene(home_View);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(home_ViewScene);
        mainwindow.show();
    }

    public void submitFarmerDetails(ActionEvent actionEvent) {



    }
}
