import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.List;

import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;

public class Main extends Application {

    static AnchorPane root = new AnchorPane();
    static Scene scene = new Scene(root);
    static final int FPS = 60;
    static List<GameObject> gameObjects = new LinkedList<>();
    public static void main(String[] args) {
        launch(args);
    }

    public static void addGameObject(GameObject obj) {
        gameObjects.add(obj);
        root.getChildren().add(obj.img);
    }

    @Override
    public void start(Stage primaryStage) {
        addGameObject(new Zombie(100, 100));
        Timeline timeline = new Timeline();
        timeline.setCycleCount(-1);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis((double) 1000/FPS), e -> {
            for (GameObject obj: gameObjects) {
                obj.update();
            }
        }));
        timeline.play();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}