package data.model.scene;

import javafx.scene.Scene;
import ui.nodes.Block;
import utils.GameUtils;

import java.util.ArrayList;

public class SceneModel {
    private ArrayList<String> blocks = new ArrayList<>();
    private String fileName;

    public SceneModel(){
        for(int i = 0; i< GameUtils.VERTICAL_BLOCKS_AMOUNT; i++){
            StringBuilder builder = new StringBuilder("");

            for (int j=0; j<GameUtils.HORIZONTAL_BLOCKS_AMOUNT; j++) {
                builder.append(' ');
            }
            blocks.add(builder.toString());
        }
    }

    public void changeBlockAt(int x, int y, Character blockChar){
        StringBuilder builder = new StringBuilder(blocks.get(y));
        builder.setCharAt(x,blockChar);
        blocks.set(y, builder.toString());
    }

    public void printSceneToConsole(){
        for(String row: blocks){
            System.out.println(row);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
