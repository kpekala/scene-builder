package utils;

import java.util.HashMap;

public class GameUtils {

    public static int HORIZONTAL_BLOCKS_AMOUNT = 46;
    public static int VERTICAL_BLOCKS_AMOUNT = 26;
    public static int BLOCKS_AMOUNT = HORIZONTAL_BLOCKS_AMOUNT*VERTICAL_BLOCKS_AMOUNT;

    public static HashMap<String, String> imagesMap = getImagesMap();

    private static HashMap<String, String> getImagesMap(){
        HashMap<String, String> imageMap = new HashMap<>();
        imageMap.put("stone","assets/stone0.png");
        imageMap.put("trunk","assets/trunk.png");
        imageMap.put("brick","assets/brick.png");
        imageMap.put("dirt","assets/dirt.png");
        return imageMap;
    }
}
