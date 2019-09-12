package utils;

public class Assets {
    public static void loadImage(String path){
        System.out.println(ClassLoader.getSystemClassLoader().getResource("assets/brick.png").toString());
    }
}
