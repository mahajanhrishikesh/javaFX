package sample;

import connectivity.connectionClass;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

public class Controller {
    public Button insert;
    public TextField inFld;

    public void insertdb(ActionEvent actionEvent) {
        connectionClass connectionclass =new connectionClass();

        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO USER VALUES('"+inFld.getText()+"')";

        try {
            Statement statement =connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
