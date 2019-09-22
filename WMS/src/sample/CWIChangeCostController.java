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
import java.sql.SQLException;

public class CWIChangeCostController {

    public Button capBtn;
    public Button remCapBtn;
    public Button costBtn;
    public Button backBtn;

    public TextField capFld;
    public TextField remCapFld;
    public TextField costFld;

    WarehouseOwner warehouseOwner;

    public void initData(WarehouseOwner warehouseOwner1){
        warehouseOwner = warehouseOwner1;
    }

    Connectivity.connectivityClass connectivityClass = new connectivityClass();
    Connection connection = connectivityClass.getConnection();

    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("warehouseownerviewPage.fxml"));
        Parent farmerView = loader.load();
        Scene farmerViewScene = new Scene(farmerView);

        warehouseownerviewController controller = loader.getController();

        controller.initData(warehouseOwner);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(farmerViewScene);
        mainwindow.show();
    }

    public void changeCapacity(ActionEvent actionEvent) throws SQLException{
        String sql = "UPDATE WAREHOUSE SET CAPACITY = "+capFld.getText()+" WHERE WID = "+warehouseOwner.wid+"";

        connection.createStatement().executeUpdate(sql);
    }

    public void changeRemCap(ActionEvent actionEvent) throws SQLException {
        String sql = "UPDATE WAREHOUSE SET REMCAP = "+remCapFld.getText()+" WHERE WID = "+warehouseOwner.wid+"";

        connection.createStatement().executeUpdate(sql);
    }

    public void changeCost(ActionEvent actionEvent) throws SQLException{
        String sql = "UPDATE WAREHOUSE SET COST = "+costFld.getText()+" WHERE WID = "+warehouseOwner.wid+"";

        connection.createStatement().executeUpdate(sql);
    }

}
