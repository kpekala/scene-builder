package ui.fragments;

import controller.AppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import ui.base.BaseFragment;
import ui.nodes.ImageToPick;
import utils.Colors;
import utils.GameUtils;
import utils.ScreenUtils;

import java.util.ArrayList;

public class ImagePicker extends BaseFragment {

    private static int START_X = 188;
    private static int WIDTH = ScreenUtils.WIDTH - START_X;
    private static int HEIGHT = 130;

    private HBox hBox;
    private ArrayList<ImageToPick> imagesToPick;

    public ImagePicker(AppController appController) {
        super(appController);
    }

    @Override
    public void initNodes() {
        hBox = new HBox(24);

        hBox.setPadding(new Insets(20, 20, 20 ,20));
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setMinWidth(WIDTH);
        hBox.setMinHeight(HEIGHT);

        imagesToPick = new ArrayList<>();

        GameUtils.getImagePaths().forEach((imageName, imagePath) -> {
            ImageToPick image = new ImageToPick(imageName);
            image.setOnMouseClicked(event -> appController.onImageToPickClicked(image.name));

            imagesToPick.add(image);
        });
    }

    @Override
    public void appendNodes() {
        for(ImageToPick image: imagesToPick){
            hBox.getChildren().add(image.imageWrapper);
        }
        getChildren().addAll(hBox);
    }

    @Override
    public void initFragment() {
        setTranslateX(START_X);
        setTranslateY(ScreenUtils.HEIGHT - HEIGHT);
        setMinHeight(HEIGHT);
        setMinWidth(WIDTH);
        setStyle("-fx-background-color: " + Colors.getGrey(0.7));
    }

    public void notifyClickedItemChanged(String oldItem, String newItem){
        for(ImageToPick image: imagesToPick){
            if(oldItem.equals(image.name)){
                image.changeToNotClicked();
            }else if(newItem.equals(image.name)){
                image.changeToClicked();
            }
        }
    }
}
