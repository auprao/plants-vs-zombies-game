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
        AnchorPane root = new AnchorPane();
        Image bg = new Image("file:Frontyard.png");
        String path = "Plants vs Zombies Soundtrack. [Main Menu].mp3";
        Media bgMusic = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(bgMusic);
        mediaPlayer.setAutoPlay(true);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        root.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getY());
            }
        });

        background.setImage(bg);
        root.getChildren().add(background);

        addZombieOnTrack(0);
        addZombieOnTrack(1);
        addZombieOnTrack(2);
        addZombieOnTrack(3);
        addZombieOnTrack(4);


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

        row1Button.setLayoutY(120);
        row2Button.setLayoutY(220);
        row3Button.setLayoutY(330);
        row4Button.setLayoutY(440);
        row5Button.setLayoutY(550);



        root.getChildren().addAll(row1Button, row2Button, row3Button,row4Button, row5Button);





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