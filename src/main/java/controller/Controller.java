package controller;

import ui.fragments.GameScene;
import ui.fragments.ImagePicker;
import ui.fragments.Menu;
import ui.nodes.Block;

public class Controller {

    private String pickedImage = "";

    private Menu menu;
    private GameScene gameScene;
    private ImagePicker imagePicker;

    public void initViews(Menu menu, GameScene scene, ImagePicker imagePicker){
        this.menu = menu;
        this.gameScene = scene;
        this.imagePicker = imagePicker;
    }

    public void onBlockClicked(Block block){
        if(!pickedImage.isEmpty()){
            gameScene.addImageTo(block, pickedImage);
        }
    }

    public void onImageToPickClicked(String clickedImage){
        if(!clickedImage.equals(pickedImage)){
            imagePicker.notifyClickedItemChanged(pickedImage, clickedImage);
            pickedImage = clickedImage;
        }
    }
}
