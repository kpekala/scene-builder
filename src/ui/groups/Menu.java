package ui.groups;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.text.Text;
import ui.base.BaseGroup;

public class Menu extends BaseGroup {

    private Text textChooseScene;

    public Menu(Controller controller) {
        super(controller);

        initNodes();
    }

    private void initNodes() {
        textChooseScene = new Text();
    }
}
