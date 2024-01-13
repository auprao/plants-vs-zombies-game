public class Zombie extends GameObject {
    public Zombie(double x, double y) {
        super(x, y);
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
}
