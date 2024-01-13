import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.List;

import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;

public class Main extends Application {
    static final int FPS = 60;

    static ImageView background = new ImageView();

    static List<GameObject> gameObjects = new LinkedList<>();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        Image bg = new Image("file:Frontyard.png");
        background.setImage(bg);
        root.getChildren().add(background);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(-1);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis((double) 1000/FPS), e -> {
            // Run every frame :3'
        }));
        timeline.play();


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}