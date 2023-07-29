package graphing_calculator;

import javafx.animation.AnimationTimer;

public class MyAnimationTimer extends AnimationTimer {
    @Override
    public void handle(long now) {
        StartSceneController.loader.main.updateScreen();
    }
}
