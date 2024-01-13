import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import java.util.Optional;


public class Main extends Application {

    static final Duration BUTTON_COOLDOWN = Duration.millis(2000);
    static AnchorPane root = new AnchorPane();
    static Scene scene = new Scene(root);
    static final int FPS = 60;
    public static int COUNT = 0;

    static ImageView background = new ImageView();

    static List<GameObject> gameObjects = new LinkedList<>();
    static List<Zombie> zombies = new LinkedList<>();

    static Plant[][] plants = new Plant[5][9];
    static final int[] CELL_X = {312, 400, 480, 575, 660, 745, 830, 910, 1000};
    private int level = 1;

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
        z.assignToTrack(track);
        addZombie(z);
    }

    @Override
    public void start(Stage primaryStage) {
        Image bg = new Image("file:Frontyard.png");
        String path = "Plants vs Zombies Soundtrack. [Main Menu].mp3";
        Media bgMusic = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(bgMusic);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        plantPlants();

        background.setImage(bg);
        root.getChildren().add(background);
        Image zomb = new Image("file:PVZ_Zombie.png");


        ImageView zobie1 = new ImageView(zomb);
        zobie1.setFitHeight(50);
        zobie1.setFitWidth(50);

        ImageView zobie2 = new ImageView(zomb);
        zobie2.setFitHeight(50);
        zobie2.setFitWidth(50);

        ImageView zobie3 = new ImageView(zomb);
        zobie3.setFitHeight(50);
        zobie3.setFitWidth(50);

        ImageView zobie4 = new ImageView(zomb);
        zobie4.setFitHeight(50);
        zobie4.setFitWidth(50);

        ImageView zobie5 = new ImageView(zomb);
        zobie5.setFitHeight(50);
        zobie5.setFitWidth(50);



        Button row1Button = new Button();
        Button row2Button = new Button();
        Button row3Button = new Button();
        Button row4Button = new Button();
        Button row5Button = new Button();

        Timeline tl1 = new Timeline(new KeyFrame(BUTTON_COOLDOWN,  e -> {row1Button.setVisible(true);}));
        tl1.setCycleCount(1);
        Timeline tl2 = new Timeline(new KeyFrame(BUTTON_COOLDOWN,  e -> {row2Button.setVisible(true);}));
        tl1.setCycleCount(1);
        Timeline tl3 = new Timeline(new KeyFrame(BUTTON_COOLDOWN,  e -> {row3Button.setVisible(true);}));
        tl1.setCycleCount(1);
        Timeline tl4 = new Timeline(new KeyFrame(BUTTON_COOLDOWN,  e -> {row4Button.setVisible(true);}));
        tl1.setCycleCount(1);
        Timeline tl5 = new Timeline(new KeyFrame(BUTTON_COOLDOWN,  e -> {row5Button.setVisible(true);}));
        tl1.setCycleCount(1);
        row1Button.setGraphic(zobie1);
        row2Button.setGraphic(zobie2);
        row3Button.setGraphic(zobie3);
        row4Button.setGraphic(zobie4);
        row5Button.setGraphic(zobie5);

        double X = bg.getWidth()-bg.getWidth()/10;
        row1Button.setLayoutX(X);
        row2Button.setLayoutX(X);
        row3Button.setLayoutX(X);
        row4Button.setLayoutX(X);
        row5Button.setLayoutX(X);

        row1Button.setLayoutY(110);
        row2Button.setLayoutY(215);
        row3Button.setLayoutY(325);
        row4Button.setLayoutY(440);
        row5Button.setLayoutY(550);

        root.getChildren().addAll(row1Button, row2Button, row3Button,row4Button, row5Button);

        row1Button.setOnAction(event -> {
            addZombieOnTrack(0);
            row1Button.setVisible(false);
            tl1.playFromStart();
        });
        row2Button.setOnAction(event -> {
            addZombieOnTrack(1);
            row2Button.setVisible(false);
            tl2.playFromStart();
        });
        row3Button.setOnAction(event -> {
            addZombieOnTrack(2);
            row3Button.setVisible(false);
            tl3.playFromStart();
        });
        row4Button.setOnAction(event -> {
            addZombieOnTrack(3);
            row4Button.setVisible(false);
            tl4.playFromStart();
        });
        row5Button.setOnAction(event -> {
            addZombieOnTrack(4);
            row5Button.setVisible(false);
            tl5.playFromStart();
        });

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("YOU WON");
        alert.setHeaderText("YOU ATED THE BRAIN");
        alert.setContentText("\uD83E\uDD24");
        alert.setOnCloseRequest(event -> {
            alert.close();
            primaryStage.close();
                });

        Timeline timeline = new Timeline();
        timeline.setCycleCount(-1);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis((double) 1000/FPS), e -> {
            for (GameObject obj: gameObjects) {
                obj.update();
                if (COUNT>= 5){
                    alert.show();
                    timeline.stop();

                }

            }
        }));
        timeline.play();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void plantPlants() {
        if (level == 1){
            plants = {  {},
                        {},
                        {}
            }
        }
    }
}