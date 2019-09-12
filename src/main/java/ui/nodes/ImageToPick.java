package ui.nodes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import utils.ImagePathGenerator;

public class ImageToPick extends ImageView {

    public String name;
    public StackPane imageWrapper;

    public ImageToPick(String name){

        this.name = name;
        try {
            String path = ImagePathGenerator.getPath(name);
            setImage(new Image(path));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            setScaleX(2);
            setScaleY(2);
            initWrapper();
        }
    }

    private void initWrapper() {
        imageWrapper = new StackPane();
        imageWrapper.setMaxHeight(66);
        imageWrapper.setMinHeight(66);
        imageWrapper.setMinWidth(66);
        imageWrapper.setMaxWidth(66);
        imageWrapper.getChildren().add(this);
    }

    public void changeToClicked(){
        imageWrapper.setStyle("-fx-background-color: red");
    }

    public void changeToNotClicked(){
        imageWrapper.setStyle("");
    }

}
