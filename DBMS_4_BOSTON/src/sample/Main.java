package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Label label1 = new Label("Welcome to the first scene");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        //layout1 - children are placed in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200,300);

        //button2
        Button button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        //layout2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 200,300);

        window.setScene(scene1);
        window.setTitle("window fun");
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
