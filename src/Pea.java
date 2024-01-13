public class Pea extends GameObject {
    static final double speed = 3;
    public Pea(double x, double y) {
        super(x, y);
    }

    public void update() {
        this.x += speed;
        for (Zombie z: Main.zombies) {
            if (this.y == z.y && this.x > z.x) {

            }
        }
    }

}
