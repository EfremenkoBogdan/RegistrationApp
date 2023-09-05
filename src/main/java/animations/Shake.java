package animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake
{
    private TranslateTransition translateTransition;

    public Shake(Node node) {
        translateTransition = new TranslateTransition(Duration.millis(100), node);
        translateTransition.setFromX(0f);
        translateTransition.setFromY(0f);
        translateTransition.setByX(10f);

//        translateTransition.setByY(10f);
        translateTransition.setCycleCount(3);

    }
    public void playAnim(){
        translateTransition.playFromStart();
    }
}

