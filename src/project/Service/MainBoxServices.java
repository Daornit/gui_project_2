package project.Service;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainBoxServices {
    // CONSTANT Side-Bar active class name
    private static final String ACTIVE = "active";

    public static boolean changeSideBarActiveItem(HBox currentActive, HBox hBox) {
        if(currentActive == hBox) return false;
        currentActive.getStyleClass().remove(ACTIVE);
        hBox.getStyleClass().add(ACTIVE);
        return true;
    }

    public static void setTimer(Label timer) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            timer.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
