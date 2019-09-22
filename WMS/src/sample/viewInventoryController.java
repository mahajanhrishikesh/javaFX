package sample;

import Connectivity.connectivityClass;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class viewInventoryController implements Initializable {


    Connectivity.connectivityClass connectivityClass = new connectivityClass();
    Connection connection = connectivityClass.getConnection();

    public TableView<wareTable> warehouseTable;
    public TableColumn<wareTable, String> col_sid;
    public TableColumn<wareTable, String> col_mat;
    public TableColumn<wareTable, String> col_cost;
    public TableColumn<wareTable, String> col_space;
    public TableColumn<wareTable, String> col_sd;
    public TableColumn<wareTable, String> col_ed;

    WarehouseOwner currentWarehouseOwner;
    String sql;

    public void initData(WarehouseOwner warehouseOwner){
        currentWarehouseOwner = warehouseOwner;
        int id = Integer.parseInt(currentWarehouseOwner.wid);
        //debugLabel.setText(currentFarmer.FID);
        sql = "SELECT STOCK.SID, STOCK.MATERIAL, STOCK.SPACE, WAREHOUSE.COST*STOCK.SPACE*STOCK.DAYS AS COST, STOCK.ADD_DATE, DATE_ADD(STOCK.ADD_DATE, INTERVAL STOCK.DAYS DAY) AS END_DATE FROM STOCK INNER JOIN WAREHOUSE ON STOCK.WID = WAREHOUSE.WID WHERE WAREHOUSE.WID = "+ currentWarehouseOwner.wid+";";
    }

    ObservableList<wareTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Platform.runLater(()-> {
                    try {
                        ResultSet rs = connection.createStatement().executeQuery(sql);

                        while (rs.next()) {
                            oblist.add(new wareTable(
                                    rs.getString("SID"),
                                    rs.getString("MATERIAL"),
                                    rs.getString("SPACE"),
                                    rs.getString("COST"),
                                    rs.getString("ADD_DATE"),
                                    rs.getString("END_DATE")
                            ));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );

        col_sid.setCellValueFactory(new PropertyValueFactory<>("SID"));
        col_mat.setCellValueFactory(new PropertyValueFactory<>("MATERIAL"));
        col_space.setCellValueFactory(new PropertyValueFactory<>("SPACE"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("COST"));
        col_sd.setCellValueFactory(new PropertyValueFactory<>("ADD_DATE"));
        col_ed.setCellValueFactory(new PropertyValueFactory<>("END_DATE"));

        warehouseTable.setItems(oblist);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("warehouseownerviewPage.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        warehouseownerviewController controller = loader.getController();
        controller.initData(currentWarehouseOwner);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }

}
