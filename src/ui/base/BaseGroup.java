package ui.base;

import controller.Controller;
import javafx.scene.Group;

public class BaseGroup extends Group {

    protected Controller controller;

    public BaseGroup(Controller controller){
        this.controller = controller;
    }
}
