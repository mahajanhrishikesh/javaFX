package dbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class removeStockController {
    public Button backBtn;
    public TextField qtyFld;
    public MenuButton matdd;
    public Button rsBtn;


    public void removeStock(ActionEvent actionEvent) {

    }

    public void backToFV(ActionEvent actionEvent) throws IOException {
        Parent farmer_reg_View = FXMLLoader.load(getClass().getResource("farmerView.fxml"));
        Scene farmer_reg_ViewScene = new Scene(farmer_reg_View);

        //This line brings in the stage info
        Stage mainwindow = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(farmer_reg_ViewScene);
        mainwindow.show();
    }
}
