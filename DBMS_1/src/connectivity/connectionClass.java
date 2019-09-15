package connectivity;
import java.sql.Connection;
import java.sql.DriverManager;


public class connectionClass {
public Connection connection;
    public Connection getConnection(){

        String dbName = "Tutorial";
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
