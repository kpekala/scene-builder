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
        blockChars.put("empty",'#');
        blockChars.put("trunk",'t');
        blockChars.put("brick",'b');
        blockChars.put("stone",'s');
        blockChars.put("dirt",'d');
        blockChars.put("stone_top",'2');
        blockChars.put("stone_left",'1');
        blockChars.put("stone_right",'3');
        blockChars.put("floor1",'4');
        blockChars.put("floor2",'5');
        blockChars.put("grass1",'6');
        blockChars.put("grass2",'7');
        blockChars.put("leafs",'8');
        blockChars.put("stone1",'9');
        blockChars.put("stone2",'@');
        blockChars.put("door1",'!');
        blockChars.put("door2",'$');
        blockChars.put("door3",'%');
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
        imageMap.put("floor1","assets/floor1.png");
        imageMap.put("floor2","assets/floor2.png");
        imageMap.put("grass1","assets/grass1.png");
        imageMap.put("grass2","assets/grass2.png");
        imageMap.put("leafs","assets/leafs.png");
        imageMap.put("stone1","assets/stone1.png");
        imageMap.put("stone2","assets/stone2.png");
        imageMap.put("door1","assets/door1.png");
        imageMap.put("door2","assets/door2.png");
        imageMap.put("door3","assets/door3.png");
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
