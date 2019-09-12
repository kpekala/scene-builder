package ui.fragments;

import controller.Controller;
import ui.base.BaseFragment;
import ui.nodes.Block;
import utils.GameUtils;

import java.util.ArrayList;

public class GameScene extends BaseFragment{

    private ArrayList<Block> blocks;

    public GameScene(Controller controller) {
        super(controller);

        setTranslateX(188);
    }

    @Override
    public void initNodes() {
        blocks = new ArrayList<>();

        for(int i = 0; i< GameUtils.VERTICAL_BLOCKS_AMOUNT; i++){
            for(int j = 0; j< GameUtils.HORIZONTAL_BLOCKS_AMOUNT; j++){
                Block block = new Block(j, i);
                blocks.add(block);
            }
        }
    }

    @Override
    public void appendNodes() {
        getChildren().addAll(blocks);
    }

    @Override
    public void initFragment() {

    }


}
