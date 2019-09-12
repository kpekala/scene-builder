package ui.nodes;

import javafx.scene.image.ImageView;
public class Block extends ImageView {

    public int indexX;
    public int indexY;
    public int imageSize = 26;

    public Block(int indexX, int indexY){
        this.indexX = indexX;
        this.indexY = indexY;

        setX(indexX * imageSize);
        setY(indexY * imageSize);
        setFitHeight(imageSize);
        setFitHeight(imageSize);
        setImage(null);
    }
}
