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
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

public class loginController {

    public Label debugLabel;

    public TextField uname;
    public TextField pass;

    public Button loginFarmerBtn;
    public Button loginWarehouseOwnerBtn;
    public Button registerFarmerBtn;

    public void loginFarmer(ActionEvent actionEvent) {

        String username = uname.getText();
        String password = pass.getText();

        connectivityClass connectionClass = new connectivityClass();
        Connection connection= connectionClass.getConnection();

        String sql = "SELECT USERNAME FROM FARMER WHERE USERNAME = '"+username+"';";

        try{
            ResultSet rs = connection.createStatement().executeQuery(sql);
            String tableUsername = null;
            String tablePassword = null;
            String tableCity = null;
            while(rs.next()){
                tableUsername = rs.getString("USERNAME");
            }

            if(username.equals(tableUsername)){
                sql = "SELECT FID, PASSWORD, CITY FROM FARMER WHERE USERNAME = '"+tableUsername+"';";

                rs = connection.createStatement().executeQuery(sql);
                while(rs.next()){
                    String tableFid = rs.getString("FID");
                    tablePassword = rs.getString("Password");
                    tableCity = rs.getString("city");
                    if(tablePassword.equals(password))
                    {
                        Farmer farmer = new Farmer(tableFid,username, password, tableCity);
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("farmerviewPage.fxml"));
                        Parent farmerView = loader.load();
                        Scene farmerViewScene = new Scene(farmerView);

                        farmerviewController controller = loader.getController();

                        controller.initData(farmer);

                        //This line brings in the stage info
                        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                        mainwindow.setScene(farmerViewScene);
                        mainwindow.show();
                    }
                    else{
                        debugLabel.setText("FooBar");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void loginW(ActionEvent actionEvent) {

        String username = uname.getText();
        String password = pass.getText();

        connectivityClass connectionClass = new connectivityClass();
        Connection connection= connectionClass.getConnection();

        String sql = "SELECT USERNAME FROM WAREHOUSE_OWNER WHERE USERNAME = '"+username+"';";

        try{
            ResultSet rs = connection.createStatement().executeQuery(sql);
            String tableUsername = null;
            String tablePassword = null;
            String tableCity = null;
            while(rs.next()){
                tableUsername = rs.getString("USERNAME");
            }
            debugLabel.setText("No such user exists!");
            if(username.equals(tableUsername)){
                sql = "SELECT PASSWORD, CITY,WID FROM WAREHOUSE_OWNER WHERE USERNAME = '"+tableUsername+"';";

                rs = connection.createStatement().executeQuery(sql);
                while(rs.next()){
                    tablePassword = rs.getString("Password");
                    tableCity = rs.getString("City");
                    String tableWid = rs.getString("Wid");
                    if(tablePassword.equals(password))
                    {
                        WarehouseOwner warehouseOwner = new WarehouseOwner(username, password, tableCity, tableWid);
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("warehouseownerviewPage.fxml"));
                        Parent view = loader.load();
                        Scene scene = new Scene(view);

                        warehouseownerviewController controller = loader.getController();

                        controller.initData(warehouseOwner);

                        //This line brings in the stage info
                        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                        mainwindow.setScene(scene);
                        mainwindow.show();
                    }
                    else{
                        debugLabel.setText("Wrong username password combination");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void registerFarmer(ActionEvent actionEvent) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("registerPage.fxml"));
        Scene scene = new Scene(view);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }
}
