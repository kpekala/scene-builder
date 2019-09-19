package ui.fragments;

import controller.AppController;
import ui.base.BaseFragment;
import ui.nodes.Block;
import utils.GameUtils;
import utils.ScreenUtils;

import java.util.ArrayList;

public class GameScene extends BaseFragment{

    private static int START_X = 188;
    private static int WIDTH = ScreenUtils.WIDTH - START_X;
    private static int HEIGHT = ScreenUtils.HEIGHT - 130;

    private ArrayList<Block> blocks;

    public GameScene(AppController appController) {
        super(appController);
    }

    @Override
    public void initNodes() {
        blocks = new ArrayList<>();
        for(int i = 0; i< GameUtils.VERTICAL_BLOCKS_AMOUNT; i++){
            for(int j = 0; j< GameUtils.HORIZONTAL_BLOCKS_AMOUNT; j++){
                Block block = new Block(j, i);
                block.setOnMouseMoved(event -> {
                    if(event.isControlDown()){
                        appController.onBlockClicked(block);
                    }
                    if(event.isShiftDown()){
                        appController.onBlockNeedToRemove(block);
                    }
                });

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
        setMinWidth(WIDTH);
        setMinHeight(HEIGHT);
        setTranslateX(START_X);
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void addImageTo(Block block, String imageName){
        block.setImage(imageName);
    }


    public void removeImage(Block block) {
        block.removeImage();
    }
}
