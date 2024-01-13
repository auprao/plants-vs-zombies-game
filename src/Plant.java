import javafx.scene.layout.AnchorPane;

public class Plant {
    enum Type{
        Shooter,iceShooter,doubleShooter,
        Flower,Walnut,Mine
    }
    Type type;
    int x;
    int y;
    int hp = 100;

    public Plant(Type type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        if (type == Type.Walnut){
            hp = 200;
        }
    }

    public void peaShoot(){
        GameObject pea = new GameObject(this.x,this.y);
    /*    Main.root.getChildren().add(pea);
        for (int i = 0; i < 300; i++) {
            pea.x = pea.x + 3;
            if (){

            }
        }*/
    }

    public void icePeaShoot(){
        GameObject icePea = new GameObject(this.x,this.y);
    /*    Main.root.getChildren().add(icePea);
        for (int i = 0; i < 300; i++) {
            icePea.x = icePea.x + 3;
            if (){

            }
        }*/
    }

    public void mineExplode(){
        for (int i = 0; i < Main.zombies.size(); i++) {
            Zombie z = Main.zombies.get(i);
            int distance = (int) Math.sqrt(Math.pow(Math.abs(z.x - this.x),2)+Math.pow(Math.abs(z.y - this.y),2));
            if (distance < 20){
                z.setHP(z.getHP() - (1/(distance+1))*100);
            }
        }
    }
}