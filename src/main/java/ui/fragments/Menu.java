package ui.fragments;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ui.base.BaseFragment;
import utils.Colors;
import utils.ScreenUtils;
import utils.Styles;

public class Menu extends BaseFragment {

    private static int WIDTH = 200;
    private static int HEIGHT = ScreenUtils.HEIGHT;

    private Text textChooseScene;
    private TextField fieldSceneName;
    private Button buttonLoad;
    private Button buttonSave;

    private VBox vBox;

    public Menu(Controller controller) {
        super(controller);
    }

    @Override
    public void initFragment() {
        setMinHeight(HEIGHT);
    }

    public void appendNodes(){
        vBox.getChildren().addAll(textChooseScene, fieldSceneName, buttonLoad, buttonSave);
        getChildren().add(vBox);
    }

    public void initNodes() {
        textChooseScene = new Text(0, 200, "Type a map:");
        textChooseScene.setFont(Styles.bigFont);

        fieldSceneName = new TextField();

        buttonLoad = new Button("Load");
        buttonLoad.setFont(Styles.mediumFont);
        buttonLoad.setMinWidth(100);

        buttonSave = new Button("Save");
        buttonSave.setFont(Styles.mediumFont);
        buttonSave.setMinWidth(100);

        vBox = new VBox(16);
        vBox.setBackground(new Background(new BackgroundFill(
                Color.web(Colors.LIGHT), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(new Insets(20, 20, 0 ,20));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setMinHeight(HEIGHT);
    }
}
