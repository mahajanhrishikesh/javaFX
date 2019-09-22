package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class farmerviewController {

    public Label welcomeLabel;
    public Label cityLabel;

    public Button addStockBtn;
    public Button viewStockBtn;
    public Button withdrawStockBtn;
    public Button logoutBtn;



    Farmer farmer = null;

    public void initData(Farmer currfarmer)
    {
        farmer = currfarmer;
        welcomeLabel.setText("Welcome "+farmer.username+" !");
        cityLabel.setText(farmer.city);
    }

    public void addStock(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addStockPage.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        addStockController controller = loader.getController();
        controller.initData(farmer);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }

    public void withdrawStock(ActionEvent actionEvent) throws IOException{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("withdrawStockPage.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        withdrawStockController controller1 = loader.getController();
        controller1.initData(farmer);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        farmer = null;
        Parent view = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(view);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }
}
