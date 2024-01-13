import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pea extends GameObject {
    static final double speed = 3;
    public ImageView img = new ImageView(new Image("file:pea.png"));
    public Pea(double x, double y) {
        super(x, y);
    }

    public void update() {
        this.x += speed;
        for (Zombie z: Main.zombies) {
            if (this.y == z.y && this.x > z.x) {
                z.hp -= 20;
                Main.gameObjects.remove(this);
                Main.root.getChildren().remove(img);
            }
        }
        this.img.setX(this.x);
        this.img.setY(this.y);
    }

}
