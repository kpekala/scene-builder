package ui.main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Scene builder");

        Group root = new Group();
        Text text = new Text();
        text.setFont(new Font(30));
        text.setX(1);
        text.setY(1);
        text.setText("xdxdxd");
        root.getChildren().add(text);
        Group childrenRoot = new Group();
        Scene scene = new Scene(root, 1400, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
