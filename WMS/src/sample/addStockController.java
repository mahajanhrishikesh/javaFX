package sample;

import Connectivity.connectivityClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class addStockController implements Initializable {


    public TableView<modelTable> wTable;
    public TableColumn<modelTable,String> col_wid;
    public TableColumn<modelTable,String> col_pin;
    public TableColumn<modelTable,String> col_wqi;
    public TableColumn<modelTable,String> col_name;
    public TableColumn<modelTable,String> col_capacity;
    public TableColumn<modelTable,String> col_remcap;
    public TableColumn<modelTable,String> col_cost;

    public Button selBtn;
    public Button backBtn;

    public Label debugLabel;

    modelTable selectedwarehouse = null;
    Farmer currentFarmer = null;

    ObservableList<modelTable> oblist = FXCollections.observableArrayList();

    public void initData(Farmer current){
        currentFarmer = current;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        connectivityClass connectivityClass = new connectivityClass();
        Connection connection = connectivityClass.getConnection();

        String sql = "SELECT * FROM WAREHOUSE";

        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);

            while (rs.next()){
                oblist.add(new modelTable(
                        rs.getString("WID"),
                        rs.getString("PINCODE"),
                        rs.getString("WQI"),
                        rs.getString("NAME"),
                        rs.getString("CAPACITY"),
                        rs.getString("REMCAP"),
                        rs.getString("COST")
                ));
            }
        }
        catch (Exception e){

        }

        col_wid.setCellValueFactory(new PropertyValueFactory<>("WID"));
        col_pin.setCellValueFactory(new PropertyValueFactory<>("PINCODE"));
        col_wqi.setCellValueFactory(new PropertyValueFactory<>("WQI"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        col_capacity.setCellValueFactory(new PropertyValueFactory<>("CAPACITY"));
        col_remcap.setCellValueFactory(new PropertyValueFactory<>("REMCAP"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("COST"));

        wTable.setItems(oblist);

    }

    public void selectWarehouse(ActionEvent actionEvent) throws IOException{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("detWarehousePage.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        detWarehouseController controller = loader.getController();
        selectedwarehouse = wTable.getSelectionModel().getSelectedItem();
        if(selectedwarehouse == null){
            debugLabel.setText("Warehouse not selected!!");
        }
        controller.initData(selectedwarehouse, currentFarmer);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();

    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("farmerviewPage.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        farmerviewController controller = loader.getController();
        controller.initData(currentFarmer);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }
}
