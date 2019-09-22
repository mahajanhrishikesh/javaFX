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
import java.util.MissingFormatArgumentException;

public class detWarehouseController {
    public Label widLbl;
    public Label pincodeLbl;
    public Label wqiLbl;
    public Label nameLbl;
    public Label capLbl;
    public Label remCapLbl;
    public Label costLbl;

    public Button payBtn;
    public TextField matFld;
    public TextField spaceFld;
    public Label total;
    public Button backBtn;
    public TextField ndaysFld;
    public Button totalBtn;

    modelTable selectedwarehouse = null;
    Farmer currentfarmer = null;

    public void initData(modelTable currwarehouse, Farmer currfarmer) {
        selectedwarehouse = currwarehouse;
        currentfarmer = currfarmer;
        widLbl.setText(selectedwarehouse.WID);
        pincodeLbl.setText(selectedwarehouse.PINCODE);
        wqiLbl.setText(selectedwarehouse.WQI);
        nameLbl.setText(selectedwarehouse.NAME);
        capLbl.setText(selectedwarehouse.CAPACITY);
        remCapLbl.setText(selectedwarehouse.REMCAP);
        costLbl.setText(selectedwarehouse.COST);

    }

    public void setTotal(ActionEvent actionEvent){
        String material = matFld.getText();
        String space = spaceFld.getText();
        String days = ndaysFld.getText();
        int Total = Integer.parseInt(selectedwarehouse.COST) * Integer.parseInt(space) * Integer.parseInt(days);
        total.setText(""+Total+"");
    }

    public void placeOrder(ActionEvent actionEvent) {

        String material = matFld.getText();
        String space = spaceFld.getText();
        String days = ndaysFld.getText();
        connectivityClass connectivityClass = new connectivityClass();
        Connection connection = connectivityClass.getConnection();
        int Total = Integer.parseInt(selectedwarehouse.COST) * Integer.parseInt(space) * Integer.parseInt(days);
        total.setText(""+Total+"");
        String sql = "INSERT INTO STOCK VALUES (NULL, '"+material+"',"+space+",NOW(),"+days+","+currentfarmer.FID+", "+selectedwarehouse.WID+");";
        try {
            connection.createStatement().executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("farmerviewPage.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        farmerviewController controller = loader.getController();
        controller.initData(currentfarmer);

        //This line brings in the stage info
        Stage mainwindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        mainwindow.setScene(scene);
        mainwindow.show();
    }
}
