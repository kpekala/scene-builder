package controller.transforms;

import data.model.BlockModel;
import data.model.scene.SceneModel;
import ui.nodes.Block;
import utils.GameUtils;

import java.util.ArrayList;
import java.util.List;

public class BlocksTransform {
    public List<BlockModel> fromTextsRowsToBlockModels(List<String> blockRows){
        ArrayList<BlockModel> blockModels = new ArrayList<>();
        for(int y=0; y< GameUtils.VERTICAL_BLOCKS_AMOUNT; y++){
            String row = blockRows.get(y);
            for(int x =0; x<GameUtils.HORIZONTAL_BLOCKS_AMOUNT; x++){
                char imageChar = row.charAt(x);
                String imageName = GameUtils.getImageName(imageChar);
                blockModels.add(new BlockModel(imageName, x, y));
            }
        }
        return blockModels;
    }
}
