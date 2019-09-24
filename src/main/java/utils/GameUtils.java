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
        blockChars.put("sand0",'(');
        blockChars.put("sand1",'^');
        blockChars.put("sand2",'&');
        blockChars.put("sand3",'*');
        blockChars.put("sand4",')');
        blockChars.put("ground-grass0",')');
        blockChars.put("ground-grass1",'_');
        blockChars.put("ground-grass2",'-');
        blockChars.put("ground-grass3",'=');
        blockChars.put("chest1",'+');
        blockChars.put("chest2",'[');
        blockChars.put("bed0",';');
        blockChars.put("bed1",':');
        blockChars.put("wall0",'/');
        blockChars.put("wall1",'?');
        blockChars.put("wall2",'.');
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
        imageMap.put("sand0","assets/sand0.png");
        imageMap.put("sand1","assets/sand1.png");
        imageMap.put("sand2","assets/sand2.png");
        imageMap.put("sand3","assets/sand3.png");
        imageMap.put("sand4","assets/sand4.png");
        imageMap.put("ground-grass0","assets/ground-grass0.png");
        imageMap.put("ground-grass1","assets/ground-grass1.png");
        imageMap.put("ground-grass2","assets/ground-grass2.png");
        imageMap.put("ground-grass3","assets/ground-grass3.png");
        imageMap.put("chest1","assets/chest1.png");
        imageMap.put("chest2","assets/chest2.png");
        imageMap.put("bed0","assets/bed0.png");
        imageMap.put("bed1","assets/bed1.png");
        imageMap.put("wall0","assets/wall0.png");
        imageMap.put("wall1","assets/wall1.png");
        imageMap.put("wall2","assets/wall2.png");
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
