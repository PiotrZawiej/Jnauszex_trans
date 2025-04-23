import java.util.Random;

public class Ware {
    
    public int ware_capacity;
    public Point location;

    public Ware(Point location){
        Random rand = new Random();
        this.ware_capacity =  rand.nextBoolean() ? 100 : 200;
        this.location = location;
    }
    
    @Override
    public String toString() {
        return "Ware{" +
            "ware_capacity=" + ware_capacity +
            '}';
    }
}
