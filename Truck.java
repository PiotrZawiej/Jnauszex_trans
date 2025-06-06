import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Truck {
    
    public double capacity = 0;
    public final int maxCapacity;
    public final String color;
    public Point location;

    public List<Stop> stops = new ArrayList<>();
    public List<Point> route = new ArrayList<>();
    public List<Order> assignedOrders = new ArrayList<>();



    int[] capacities = {1000, 1500, 2000};
    String[] colors = {"green", "blue", "red"};

    public Truck(Point location){
        this.location = location;
        int randomIndex = ThreadLocalRandom.current().nextInt(0, 3);
        this.maxCapacity = capacities[randomIndex];
        this.color = colors[randomIndex];

    }


    @Override
    public String toString() {
        return "Truck " + this.hashCode() % 10000 + " {\n" +
                "  capacity=" + capacity + "kg,\n" +
                "  maxCapacity=" + maxCapacity + "kg,\n" +
                "  location=" + location + ",\n" +
                "  color=" + color + "\n" +
                '}';
    }


}
