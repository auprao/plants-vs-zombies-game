import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Zombie extends GameObject {

    static double walkSpeed = 1;
    public ImageView img = new ImageView(new Image("file:Archive/zombie.png"));
    public Zombie(double x, double y) {
        super(x, y);
        img.setScaleX(0.4);
        img.setScaleY(0.4);
    }

    public void assignToTrack(int track) {
        switch (track) {
            case 0:
                this.x = 0;
                break;
            case 1:
                this.x = 0;
                break;
            case 2:
                this.x = 0;
                break;
            case 3:
                this.x = 0;
                break;
            case 4:
                this.x = 0;
                break;
        }
    }

    public void update() {
        this.x -= walkSpeed;
        this.img.setX(x);
        this.img.setY(y - 0.5 * img.getImage().getHeight());
    }
}
