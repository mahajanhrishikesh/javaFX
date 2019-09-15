package JavaFX;

import connectivity.connectionClass;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    public TextField fname;
    public TextField lname;
    public Button subname;
    public Label statlabel;

    public void button(ActionEvent actionEvent) {

        connectionClass ConnectionClass = new connectionClass();
        Connection connection = ConnectionClass.getConnection();

        String sql = "INSERT INTO USER VALUES('"+fname.getText()+"')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statlabel.setText(fname.getText());
    }
}
