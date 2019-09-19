package ui.base;

import controller.AppController;
import javafx.scene.layout.Pane;

public abstract class BaseFragment extends Pane {

    protected AppController appController;

    public BaseFragment(AppController appController){
        this.appController = appController;

        initFragment();
        initNodes();
        appendNodes();
    }

    public abstract void initNodes();
    public abstract void appendNodes();
    public abstract void initFragment();

}
