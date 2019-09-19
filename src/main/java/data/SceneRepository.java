package data;

import data.model.scene.SceneModel;

import java.io.FileNotFoundException;

public interface SceneRepository {
    void save(SceneModel sceneModel);
    SceneModel load(String fileName) throws FileNotFoundException;
}
