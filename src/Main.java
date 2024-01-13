import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    static final int FPS = 60;
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(-1);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis((double) 1000/FPS)));
    }
}