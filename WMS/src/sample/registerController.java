package sample;

import Connectivity.connectivityClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class registerController {

    public Label debugLabel;

    public Button goBackBtn;
    public Button registerFarmerBtn;

    public TextField uname;
    public TextField pass;
    public TextField city;

    public void registerFarmer(ActionEvent actionEvent) throws IOException {

        String username = uname.getText();
        String password = pass.getText();
        String cityname = city.getText();

        String sql = "INSERT INTO FARMER VALUES(NULL,'"+cityname+"','"+username+"','"+password+"');";

        connectivityClass connectivityClass = new connectivityClass();
        Connection connection = connectivityClass.getConnection();

        try{
            connection.createStatement().executeUpdate(sql);
            debugLabel.setText("You have been added as a user!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void goBack(ActionEvent actionEvent) throws IOException {

        Parent view = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(view);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();

    }


}
