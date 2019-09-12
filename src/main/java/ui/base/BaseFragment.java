package ui.base;

import controller.Controller;
import javafx.scene.layout.Pane;

public abstract class BaseFragment extends Pane {

    protected Controller controller;

    public BaseFragment(Controller controller){
        this.controller = controller;

        initFragment();
        initNodes();
        appendNodes();
    }

    public abstract void initNodes();
    public abstract void appendNodes();
    public abstract void initFragment();

}
