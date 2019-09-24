package ui.fragments;

import controller.AppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import ui.base.BaseFragment;
import ui.nodes.ImageToPick;
import utils.Colors;
import utils.GameUtils;
import utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class ImagePicker extends BaseFragment {

    private static int START_X = 188;
    private static int WIDTH = ScreenUtils.WIDTH - START_X;
    private static int HEIGHT = 130;

    private GridPane imagesGrid;
    private ArrayList<ImageToPick> imagesToPick;

    public ImagePicker(AppController appController) {
        super(appController);
    }

    @Override
    public void initNodes() {
        imagesGrid = new GridPane();
        imagesGrid.setPadding(new Insets(10, 10, 10 ,20));
        imagesGrid.setAlignment(Pos.CENTER_LEFT);
        imagesGrid.setMinWidth(WIDTH);
        imagesGrid.setMinHeight(HEIGHT);
        imagesGrid.setVgap(10);
        imagesGrid.setHgap(10);

        imagesToPick = new ArrayList<>();

        GameUtils.getImagePaths().forEach((imageName, imagePath) -> {
            ImageToPick image = new ImageToPick(imageName);
            image.setOnMouseClicked(event -> appController.onImageToPickClicked(image.name));

            imagesToPick.add(image);
        });
    }

    @Override
    public void appendNodes() {
        Iterator<ImageToPick> imageIterator = imagesToPick.iterator();
        for(int y = 0; y<2; y++){

            for(int x=0; x<16; x++){
                if(imageIterator.hasNext()){
                    ImageToPick nextImage = imageIterator.next();
                    GridPane.setConstraints(nextImage.getImageWrapper(),x,y);
                    imagesGrid.getChildren().add(nextImage.getImageWrapper());
                }
            }
        }
        getChildren().add(imagesGrid);
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
