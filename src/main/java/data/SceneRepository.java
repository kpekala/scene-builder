package data;

import data.model.scene.SceneModel;

public interface SceneRepository {
    void save(SceneModel sceneModel);
    SceneModel load(String fileName);
}
