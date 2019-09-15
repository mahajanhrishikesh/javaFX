package dbms;

import javafx.scene.control.Label;
import java.lang.StringBuilder;

public class farmerViewController {

    public Label welcomeLabel;

    public void initData(currentUser user){
        String currentUsername = user.username;
        String currentPassword = user.password;

        welcomeLabel.setText("Welcome "+currentUsername+"!");
    }



}
