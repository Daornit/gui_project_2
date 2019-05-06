package project.Service;

import javafx.scene.layout.HBox;

public class MainBoxServices {
    // CONSTANT Side-Bar active class name
    private static final String ACTIVE = "active";

    public static boolean changeSideBarActiveItem(HBox currentActive, HBox hBox) {
        if(currentActive == hBox) return false;
        currentActive.getStyleClass().remove(ACTIVE);
        hBox.getStyleClass().add(ACTIVE);
        return true;
    }
}
