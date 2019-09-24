package ui.nodes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import utils.ImagePathGenerator;

public class ImageToPick extends ImageView {

    public String name;
    private StackPane imageWrapper;

    public ImageToPick(String name){

        this.name = name;
        try {
            String path = ImagePathGenerator.getPath(name);
            setImage(new Image(path));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            setScaleX(1.3);
            setScaleY(1.3);
            initWrapper();
        }
    }

    private void initWrapper() {
        int imageSize = (int) (getImage().getWidth() * getScaleX());
        int wrapperSize = imageSize + 4;
        imageWrapper = new StackPane();
        imageWrapper.setMaxHeight(wrapperSize);
        imageWrapper.setMinHeight(wrapperSize);
        imageWrapper.setMinWidth(wrapperSize);
        imageWrapper.setMaxWidth(wrapperSize);
        imageWrapper.getChildren().add(this);
    }

    public StackPane getImageWrapper() {
        return imageWrapper;
    }

    public void changeToClicked(){
        imageWrapper.setStyle("-fx-background-color: red");
    }

    public void changeToNotClicked(){
        imageWrapper.setStyle("");
    }

}
