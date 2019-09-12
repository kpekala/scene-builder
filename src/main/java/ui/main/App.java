package ui.main;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.fragments.GameScene;
import ui.fragments.Menu;
import utils.ScreenUtils;

public class App extends Application {

    private Controller controller = new Controller();

    private Menu menu;
    private GameScene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GameScene builder");

        menu = new Menu(controller);
        scene = new GameScene(controller);

        Group root = new Group();

        root.getChildren().add(menu);
        root.getChildren().add(scene);

        Scene scene = new Scene(root, ScreenUtils.WIDTH, ScreenUtils.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
