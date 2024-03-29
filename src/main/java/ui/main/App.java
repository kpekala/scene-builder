package ui.main;

import controller.AppController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import ui.fragments.GameScene;
import ui.fragments.ImagePicker;
import ui.fragments.Menu;
import utils.ScreenUtils;

public class App extends Application {

    private AppController appController = new AppController(this);

    private Menu menu;
    private GameScene scene;
    private ImagePicker imagePicker;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GameScene builder");

        menu = new Menu(appController);
        scene = new GameScene(appController);
        imagePicker = new ImagePicker(appController);

        appController.initViews(menu,scene,imagePicker);

        Group root = new Group();

        root.getChildren().add(menu);
        root.getChildren().add(scene);
        root.getChildren().add(imagePicker);

        Scene scene = new Scene(root, ScreenUtils.WIDTH, ScreenUtils.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showDialog(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);

        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
