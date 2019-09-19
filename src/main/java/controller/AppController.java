package controller;

import controller.transforms.SceneTransform;
import data.JsonSceneRepository;
import data.SceneRepository;
import data.model.scene.SceneModel;
import ui.fragments.GameScene;
import ui.fragments.ImagePicker;
import ui.fragments.Menu;
import ui.nodes.Block;

import java.util.List;

public class AppController {

    private String pickedImage = "";

    private Menu menu;
    private GameScene gameScene;
    private ImagePicker imagePicker;

    private SceneRepository sceneRepository = new JsonSceneRepository();
    private SceneTransform sceneTransform = new SceneTransform();

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

    public void onBlockNeedToRemove(Block block){
        if(!pickedImage.isEmpty()){
            gameScene.removeImage(block);
        }
    }

    public void onImageToPickClicked(String clickedImage){
        if(!clickedImage.equals(pickedImage)){
            imagePicker.notifyClickedItemChanged(pickedImage, clickedImage);
            pickedImage = clickedImage;
        }
    }

    public void onSaveButtonClicked(String fileName){
        if(fileName.isEmpty()){
            return;
        }
        List<Block> blocks = gameScene.getBlocks();
        SceneModel sceneModel = sceneTransform.toModel(blocks, fileName);
        sceneRepository.save(sceneModel);
    }
}
