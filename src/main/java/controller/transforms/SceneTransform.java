package controller.transforms;

import data.model.scene.SceneModel;
import ui.nodes.Block;
import utils.GameUtils;

import java.util.List;

public class SceneTransform {
    public  SceneModel toModel(List<Block> blocks, String fileName){
        SceneModel sceneModel = new SceneModel();
        for (Block block: blocks){
            char blockChar = getBlockChar(block.imageName);
            sceneModel.changeBlockAt(block.indexX, block.indexY, blockChar);
        }
        sceneModel.setFileName(fileName);
        return sceneModel;
    }

    private char getBlockChar(String imageName){
        return GameUtils.blockChars.get(imageName);
    }
}
