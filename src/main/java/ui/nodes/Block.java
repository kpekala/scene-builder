package ui.nodes;

import data.model.BlockModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.ImagePathGenerator;

public class Block extends ImageView {

    public int indexX;
    public int indexY;
    public int imageSize = 26;
    public int originalImageSize = 30;
    public String imageName = "empty";

    public Block(int indexX, int indexY){
        this.indexX = indexX;
        this.indexY = indexY;

        setX(indexX * imageSize);
        setY(indexY * imageSize);


        double scale = (double) imageSize/originalImageSize;
        setScaleX(scale);
        setScaleY(scale);

        setImage(new Image("/assets/empty.png"));
    }

    public void setImage(String imageName){
        this.imageName = imageName;
        setImage(new Image(ImagePathGenerator.getPath(imageName)));
    }

    public void removeImage(){
        imageName = "empty";
        setImage(new Image("/assets/empty.png"));
    }

    public boolean equals(BlockModel blockModel){
        return indexX == blockModel.indexX && indexY == blockModel.indexY;
    }
}