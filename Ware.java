import java.util.Random;

public class Ware {
    
    public int ware_capacity = 0;
    public Point location;
    public int deliverOrTake;
    public Order order;

    int max = 200;
    int min = 100;
    int range = max - min + 1;

    public Ware(Point location){
        Random rand = new Random();
        this.deliverOrTake = rand.nextBoolean() ? 0 : 1; //deliver - 0 take - 1 
        this.ware_capacity =  (int)(Math.random() * range) + min;
        this.location = location;
        this.order = new Order(ware_capacity);

    }
    
    @Override
    public String toString() {
        return "Ware{" +
            "ware_capacity=" + ware_capacity + 
            ", " +  order +
            " deliver or take " + deliverOrTake +
            '}';
    }
}
