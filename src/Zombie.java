import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Zombie extends GameObject {

    static double walkSpeed = 1;
    public ImageView img = new ImageView(new Image("file:Archive/zombie.png"));
    public int hp = 100;
    public int track = 0;
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
        /*if (this.hp <= 0) {
            die();
        }*/

        this.x -= walkSpeed;
        this.img.setX(x - 0.5 * img.getImage().getWidth() * 0.4);
        this.img.setY(y - img.getImage().getHeight() * 0.4 * 1.5);
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void die() {
        // Play death animation or sm
        Main.gameObjects.remove(this);
        Main.zombies.remove(this);
    }
}
