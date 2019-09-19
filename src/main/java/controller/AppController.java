package controller;

import controller.transforms.BlocksTransform;
import controller.transforms.SceneTransform;
import data.JsonSceneRepository;
import data.SceneRepository;
import data.model.BlockModel;
import data.model.scene.SceneModel;
import ui.fragments.GameScene;
import ui.fragments.ImagePicker;
import ui.fragments.Menu;
import ui.main.App;
import ui.nodes.Block;

import java.io.FileNotFoundException;
import java.util.List;

public class AppController {

    private String pickedImage = "";

    private final App app;
    private Menu menu;
    private GameScene gameScene;
    private ImagePicker imagePicker;

    private SceneRepository sceneRepository = new JsonSceneRepository();
    private SceneTransform sceneTransform = new SceneTransform();
    private BlocksTransform blocksTransform = new BlocksTransform();

    public AppController(App app){
        this.app = app;
    }

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

    public void onLoadButtonClicked(String fileName){
        if(fileName.isEmpty()){
            return;
        }
        try {
            SceneModel sceneModel = sceneRepository.load(fileName);
            List<BlockModel> blockModels = blocksTransform.fromTextsRowsToBlockModels(sceneModel.getBlocks());
            gameScene.updateBlocks(blockModels);

        } catch (FileNotFoundException e) {
            app.showDialog("Errer when loading file","File with given name doesn't exist!");
        }
    }
}
