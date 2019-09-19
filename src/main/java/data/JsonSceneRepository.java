package data;

import com.google.gson.Gson;
import data.model.scene.SceneModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonSceneRepository implements SceneRepository {
    public void save(SceneModel sceneModel) {

        String path = "src/main/resources/maps/" + sceneModel.getFileName() + ".json";
        File file = new File(path);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            Gson gsonBuilder = new Gson().newBuilder().create();
            gsonBuilder.toJson(sceneModel, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public SceneModel load(String fileName) {
        return null;
    }
}
