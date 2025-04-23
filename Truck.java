public class Truck {
    
    public double capacity = 0;
    public final int maxCapacity = 1000;
    public Point location;

    public Truck(Point location){
        this.location = location;

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
               '}';
    }

}
