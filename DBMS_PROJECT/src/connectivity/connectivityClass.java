package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectivityClass {
    public Connection connection;

    public Connection getConnection() {
        String dbName = "warehouse";
        String uname = "dbmsguy";
        String password = "wpurocks";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,uname,password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
