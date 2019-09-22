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

public class warehouseownerviewController {

    WarehouseOwner warehouseOwner = null;
    public Label welcomeLabel;

    public Button logoutBtn;
    public Button viBtn;
    public Button cwiBtn;

    public void initData(WarehouseOwner currWarehouseOwner){
        warehouseOwner = currWarehouseOwner;
        welcomeLabel.setText("Welcome "+warehouseOwner.username+" !");
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        warehouseOwner = null;
        Parent view = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(view);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }

    public void viewInventory(ActionEvent actionEvent)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("viewInventoryPage.fxml"));
        Parent farmerView = loader.load();
        Scene farmerViewScene = new Scene(farmerView);

        viewInventoryController controller = loader.getController();

        controller.initData(warehouseOwner);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(farmerViewScene);
        mainwindow.show();
    }

    public void changeWDet(ActionEvent actionEvent) throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CWIChangeCostPage.fxml"));
        Parent farmerView = loader.load();
        Scene farmerViewScene = new Scene(farmerView);

        CWIChangeCostController controller = loader.getController();

        controller.initData(warehouseOwner);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(farmerViewScene);
        mainwindow.show();
    }

}
