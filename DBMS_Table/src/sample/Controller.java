package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import connectivity.connectivityClass;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TableView<ModelTable> warehouseTable;
    public TableColumn<ModelTable, String> w_id;
    public TableColumn<ModelTable, String> w_name;
    public TableColumn<ModelTable, String> plotno;
    public TableColumn<ModelTable, String> city;
    public TableColumn<ModelTable, String> capacity;
    public Button switchScene;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        connectivityClass ConnectionClass = new connectivityClass();
        Connection connection = ConnectionClass.getConnection();

        String sql = "SELECT w_id,w_name,plotno, city, capacity FROM WAREHOUSE";

        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);

            while(rs.next()) {
                oblist.add(new ModelTable(
                        rs.getString("w_id"),
                        rs.getString("w_name"),
                        rs.getString("plotno"),
                        rs.getString("city"),
                        rs.getString("capacity")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        w_id.setCellValueFactory(new PropertyValueFactory<>("w_id"));
        w_name.setCellValueFactory(new PropertyValueFactory<>("w_name"));
        plotno.setCellValueFactory(new PropertyValueFactory<>("plotno"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));


        warehouseTable.setItems(oblist);
    }

    public void changeSceneButtonPushed(ActionEvent actionEvent) throws IOException {
        Parent newViewParent = FXMLLoader.load(getClass().getResource("newpane.fxml"));
        Scene newViewScene = new Scene(newViewParent);

        //This line gets the stage info
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(newViewScene);
        window.show();
    }
}
