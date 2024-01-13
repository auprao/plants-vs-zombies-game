import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Zombie extends GameObject {

    static final Image[] WALK_FRAMES = {
            new Image("file:Archive/walk/go_1.png"),
            new Image("file:Archive/walk/go_2.png"),
            new Image("file:Archive/walk/go_3.png"),
            new Image("file:Archive/walk/go_4.png"),
            new Image("file:Archive/walk/go_5.png"),
            new Image("file:Archive/walk/go_6.png"),
            new Image("file:Archive/walk/go_7.png"),
            new Image("file:Archive/walk/go_8.png"),
            new Image("file:Archive/walk/go_9.png"),
            new Image("file:Archive/walk/go_10.png")
    };

    static final Image[] DIE_FRAMES = {
            new Image("file:Archive/die/die_1.png"),
            new Image("file:Archive/die/die_2.png"),
            new Image("file:Archive/die/die_3.png"),
            new Image("file:Archive/die/die_4.png"),
            new Image("file:Archive/die/die_5.png"),
            new Image("file:Archive/die/die_6.png"),
            new Image("file:Archive/die/die_7.png"),
            new Image("file:Archive/die/die_8.png"),
    };
    private int track = 0;

    private enum AnimStates {
        walk, attack, die, stopped
    }

    private AnimStates animState = AnimStates.walk;
    static double walkSpeed = 1;
    public ImageView img = new ImageView(new Image("file:Archive/zombie.png"));
    public int hp = 100;
    public int frame = 0;


    public Zombie(double x, double y) {
        super(x, y);
        img.setScaleX(0.4);
        img.setScaleY(0.4);
    }

    public void assignToTrack(int track) {
        switch (track) {
            case 0:
                this.y = 135;
                break;
            case 1:
                this.y = 245;
                break;
            case 2:
                this.y = 345;
                break;
            case 3:
                this.y = 450;
                break;
            case 4:
                this.y = 560;
                break;
        }
        this.track = track;
    }

    public void update() {
        if (Math.random() < 0.4 || true) {frame++;}

        if (this.animState == AnimStates.walk) {
            if (frame >= WALK_FRAMES.length) frame = 0;
            this.img.setImage(WALK_FRAMES[frame]);
        }
//        System.out.println(frame);
//        if (this.animState == AnimStates.die) {
//            if (frame == 8) {
//                die();
//                frame--;
//            }
//            this.img.setImage(DIE_FRAMES[frame]);
//        }

        if (this.hp <= 0) {
            die();
        }

        if (animState == AnimStates.walk) {
            this.x -= walkSpeed;
        }
        this.img.setX(x - 0.5 * img.getImage().getWidth() * 0.4);
        this.img.setY(y - img.getImage().getHeight() * 0.4 * 1.5);

        if (this.x <= 5){
            Main.COUNT++;
        }
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void startDying() {
        this.animState = AnimStates.die;
        this.frame = 0;
    }
    public void die() {
        this.animState = AnimStates.stopped;
        Main.gameObjects.remove(this);
        Main.zombies.remove(this);
    }
}
