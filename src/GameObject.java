import javafx.scene.image.ImageView;

public class GameObject {
    public boolean visible;
    public double x, y;
    public ImageView img;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.visible = true;
    }
    public void update() {

    }

}
