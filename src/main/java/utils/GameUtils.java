package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GameUtils {

    public static int HORIZONTAL_BLOCKS_AMOUNT = 46;
    public static int VERTICAL_BLOCKS_AMOUNT = 26;
    public static int BLOCKS_AMOUNT = HORIZONTAL_BLOCKS_AMOUNT*VERTICAL_BLOCKS_AMOUNT;

    private static HashMap<String, String> imagePaths = generateImagePaths();

    private static HashMap<String, Character> blockChars = generateBlockChars();

    private static HashMap<String, Character> generateBlockChars() {
        HashMap<String, Character> blockChars = new HashMap<>();
        blockChars.put("trunk",'t');
        blockChars.put("brick",'b');
        blockChars.put("stone",'s');
        blockChars.put("dirt",'d');
        blockChars.put("stone_top",'2');
        blockChars.put("stone_left",'1');
        blockChars.put("stone_right",'3');
        blockChars.put("empty",'#');
        return blockChars;
    }


    private static HashMap<String, String> generateImagePaths(){
        HashMap<String, String> imageMap = new HashMap<>();
        imageMap.put("stone","assets/stone0.png");
        imageMap.put("trunk","assets/trunk.png");
        imageMap.put("brick","assets/brick.png");
        imageMap.put("dirt","assets/dirt.png");
        imageMap.put("stone_top","assets/stone_top.png");
        imageMap.put("stone_left","assets/stone_left.png");
        imageMap.put("stone_right","assets/stone_right.png");
        imageMap.put("empty","assets/empty.png");
        return imageMap;
    }

    public static String getImagePath(String imageName){
        return imagePaths.get(imageName);
    }

    public static char getBlockChar(String imageName){
        return blockChars.get(imageName);
    }

    public static String getImageName(char c) {
        return blockChars.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), c))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }

    private static HashMap<String, Character> getBlockChars() {
        return blockChars;
    }


    public static HashMap<String, String> getImagePaths(){
        return imagePaths;
    }

}
