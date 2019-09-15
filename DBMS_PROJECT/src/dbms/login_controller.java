package dbms;

import connectivity.connectivityClass;
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
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_controller {

    public TextField unameFld;
    public TextField passFld;
    public Button loginBtn;
    public Button registerBtn;
    public Label debugLabel;

    public void loginUser(ActionEvent actionEvent) throws IOException {

        String username = unameFld.getText();
        String password = passFld.getText();
        debugLabel.setText("Login Pressed with "+username+"");
        connectivityClass ConnectionClass = new connectivityClass();
        Connection connection = ConnectionClass.getConnection();

        String sql1 = "SELECT USERNAME FROM FARMER WHERE USERNAME ='"+unameFld.getText()+"';";

        try {
            ResultSet rsUsername = connection.createStatement().executeQuery(sql1);
            String tableUsername = null;
            String tablePassword = null;
            while (rsUsername.next()) {
                tableUsername = rsUsername.getString("USERNAME");
            }
            debugLabel.setText("Internal table username is: "+tableUsername+"");
            if (username.equals(tableUsername)) {
                debugLabel.setText("Username was a match");
                String sql2 = "SELECT PASS FROM FARMER WHERE USERNAME ='" + username + "'";

                ResultSet rsPassword = connection.createStatement().executeQuery(sql2);
                while(rsPassword.next()){
                    tablePassword = rsPassword.getString("PASS");
                }
                if (password.equals(tablePassword)) {

                    currentUser farmer = new currentUser(username, password);
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("farmerView.fxml"));
                    Parent farmerView = loader.load();
                    Scene farmerViewScene = new Scene(farmerView);

                    farmerViewController controller = loader.getController();

                    controller.initData(farmer);

                    //This line brings in the stage info
                    Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                    mainwindow.setScene(farmerViewScene);
                    mainwindow.show();
                } else {
                    debugLabel.setText("Wrong Combination of username password!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void registerUser(ActionEvent actionEvent) throws IOException {
        Parent farmer_reg_View = FXMLLoader.load(getClass().getResource("farmer_registration.fxml"));
        Scene farmer_reg_ViewScene = new Scene(farmer_reg_View);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(farmer_reg_ViewScene);
        mainwindow.show();
    }
}
