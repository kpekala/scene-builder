package ui.fragments;

import controller.AppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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

    public Menu(AppController appController) {
        super(appController);
    }

    @Override
    public void initFragment() {
        setMinHeight(HEIGHT);
        setMinWidth(WIDTH);
    }

    public void initNodes() {
        textChooseScene = new Text(0, 200, "Type a map:");
        textChooseScene.setFont(Styles.bigFont);

        fieldSceneName = new TextField();

        buttonLoad = buildButton("Load");
        buttonSave = buildButton("Save");

        initClickListeners();

        vBox = new VBox(16);
        vBox.setStyle("-fx-background-color: " + Colors.getGrey(0.8));
        vBox.setPadding(new Insets(20, 20, 0 ,20));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setMinHeight(HEIGHT);
    }

    public void appendNodes(){
        vBox.getChildren().addAll(textChooseScene, fieldSceneName, buttonLoad, buttonSave);
        getChildren().add(vBox);
    }

    private Button buildButton(String text){
        Button button = new Button(text);
        button.setFont(Styles.mediumFont);
        button.setMinWidth(100);
        return button;
    }

    private void initClickListeners() {
        buttonSave.setOnMouseClicked(event -> {
            appController.onSaveButtonClicked(fieldSceneName.getText().trim());
        });
        buttonLoad.setOnMouseClicked(event -> {
            appController.onLoadButtonClicked(fieldSceneName.getText().trim());
        });
    }


}
