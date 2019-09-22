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

public class withdrawStockController implements Initializable {

    public TableView<wsTable> withdrawTable;
    public TableColumn<wsTable, String> col_sid;
    public TableColumn<wsTable, String> col_mat;
    public TableColumn<wsTable, String> col_name;
    public TableColumn<wsTable, String> col_cost;
    public TableColumn<wsTable, String> col_space;
    public TableColumn<wsTable, String> col_sd;
    public TableColumn<wsTable, String> col_ed;

    public Button backBtn;
    public Button withdrawBtn;

    public Label debugLabel;
    int id;

    Farmer currentFarmer = new Farmer(null,null,null,null);
    String sql = null;

    connectivityClass connectivityClass = new connectivityClass();
    Connection connection = connectivityClass.getConnection();

    public void initData(Farmer newFarmer){
        currentFarmer = newFarmer;
        id = Integer.parseInt(currentFarmer.FID);
        //debugLabel.setText(currentFarmer.FID);
        sql = "SELECT STOCK.SID, STOCK.MATERIAL, WAREHOUSE.NAME, STOCK.SPACE, WAREHOUSE.COST*STOCK.SPACE*STOCK.DAYS AS COST, STOCK.ADD_DATE, DATE_ADD(STOCK.ADD_DATE, INTERVAL STOCK.DAYS DAY) AS END_DATE FROM STOCK INNER JOIN WAREHOUSE ON STOCK.WID = WAREHOUSE.WID WHERE STOCK.FID = "+currentFarmer.FID+";";
    }

    ObservableList<wsTable> oblist = FXCollections.observableArrayList();

    public void goBack(ActionEvent actionEvent) throws IOException {
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

    public void withdraw(ActionEvent actionEvent){
        wsTable selectedStock = withdrawTable.getSelectionModel().getSelectedItem();

        String deleteSql = "DELETE FROM STOCK WHERE SID = "+selectedStock.SID+";";

        try {
            connection.createStatement().executeUpdate(deleteSql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Platform.runLater(()-> {
                    try {
                        ResultSet rs = connection.createStatement().executeQuery(sql);

                        while (rs.next()) {
                            oblist.add(new wsTable(
                                    rs.getString("SID"),
                                    rs.getString("MATERIAL"),
                                    rs.getString("NAME"),
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
        col_name.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        col_space.setCellValueFactory(new PropertyValueFactory<>("SPACE"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("COST"));
        col_sd.setCellValueFactory(new PropertyValueFactory<>("ADD_DATE"));
        col_ed.setCellValueFactory(new PropertyValueFactory<>("END_DATE"));

        withdrawTable.setItems(oblist);
    }
}
