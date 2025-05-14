
public class Truck {
    
    public double capacity = 0;
    public final int maxCapacity;
    public final String color;
    public Point location;

    int[] capacities = {1000, 1500, 2000};
    String[] colors = {"green", "blue", "red"};

    public Truck(Point location){
        this.location = location;
        int randomIndex = (int)(Math.random() * capacities.length);
        this.maxCapacity = capacities[randomIndex];
        this.color = colors[randomIndex];

    }

    public boolean addWarens( Ware ware){
        if(capacity + ware.ware_capacity <= maxCapacity){
            capacity += ware.ware_capacity;

            return true;
        }else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "Truck{" +
               "capacity=" + capacity +
               ", maxCapacity=" + maxCapacity +
               ", location=" + location +
               ", color=" + color +
               '}';
    }

}
