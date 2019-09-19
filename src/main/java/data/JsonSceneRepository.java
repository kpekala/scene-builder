package data;

import com.google.gson.Gson;
import data.model.scene.SceneModel;

import java.io.*;

public class JsonSceneRepository implements SceneRepository {
    public void save(SceneModel sceneModel) {
        String path = getPathToJsonFile(sceneModel.getFileName());
        File file = new File(path);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
            gson.toJson(sceneModel, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public SceneModel load(String fileName) throws FileNotFoundException {
        String path = getPathToJsonFile(fileName);
        File file = new File(path);
        if(!file.exists()){
            throw new FileNotFoundException();
        }else{
            FileReader fileReader = new FileReader(path);
            Gson gson = new Gson().newBuilder().create();
            return gson.fromJson(fileReader,SceneModel.class);
        }
    }

    private String getPathToJsonFile(String fileName){
        return "src/main/resources/maps/" + fileName + ".json";
    }
}
