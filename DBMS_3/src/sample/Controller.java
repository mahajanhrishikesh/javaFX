package sample;

import Connectivity.connectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class Controller implements Initializable {
    public TextField uFld;
    public TextField pFld;
    public Button lgnBtn;


    public void login(ActionEvent actionEvent) throws Exception {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHomepage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) )

        connectionClass ConnectionClass = new connectionClass();
        Connection connection = ConnectionClass.getConnection();

        String loginsql = "";
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
