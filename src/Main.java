import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.LinkedList;
import java.util.List;



public class Main extends Application {

    static AnchorPane root = new AnchorPane();
    static Scene scene = new Scene(root);
    static final int FPS = 60;

    static ImageView background = new ImageView();

    static List<GameObject> gameObjects = new LinkedList<>();
    static List<Zombie> zombies = new LinkedList<>();

    static Plant[][] plants = new Plant[5][9];
    public static void main(String[] args) {
        launch(args);
    }

    public static void addZombie(Zombie z) {
        gameObjects.add(z);
        zombies.add(z);
        root.getChildren().add(z.img);
    }

    public static void addZombieOnTrack(int track) {
        Zombie z = new Zombie(1000, 0);
        addZombie(z);
        z.assignToTrack(track);
    }

    @Override
    public void start(Stage primaryStage) {
        Image bg = new Image("file:Frontyard.png");
        String path = "Plants vs Zombies Soundtrack. [Main Menu].mp3";
        Media bgMusic = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(bgMusic);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        background.setImage(bg);
        root.getChildren().add(background);

        Button row1Button = new Button("\u200E \u200E \u200E \u200E ");
        Button row2Button = new Button("\u200E \u200E \u200E \u200E ");
        Button row3Button = new Button("\u200E \u200E \u200E \u200E ");
        Button row4Button = new Button("\u200E \u200E \u200E \u200E ");
        Button row5Button = new Button("\u200E \u200E \u200E \u200E ");

        double X = bg.getWidth()-bg.getWidth()/10;
        row1Button.setLayoutX(X);
        row2Button.setLayoutX(X);
        row3Button.setLayoutX(X);
        row4Button.setLayoutX(X);
        row5Button.setLayoutX(X);

        row1Button.setLayoutY(135);
        row2Button.setLayoutY(245);
        row3Button.setLayoutY(345);
        row4Button.setLayoutY(450);
        row5Button.setLayoutY(560);

        root.getChildren().addAll(row1Button, row2Button, row3Button,row4Button, row5Button);

        row1Button.setOnAction(event -> {
            addZombieOnTrack(0);
        });
        row2Button.setOnAction(event -> {
            addZombieOnTrack(1);
        });
        row3Button.setOnAction(event -> {
            addZombieOnTrack(2);
        });
        row4Button.setOnAction(event -> {
            addZombieOnTrack(3);
        });
        row5Button.setOnAction(event -> {
            addZombieOnTrack(4);
        });

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