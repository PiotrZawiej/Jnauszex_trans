import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Truck> trucks = new ArrayList<>();
        
        Map map = new Map();

        map.addPoint(20, 30);
        map.addPoint(46, 58);
        map.addPoint(30, 76);

        Point warehouse = map.deliveryPoints.get(0);
        Point p2 = map.deliveryPoints.get(1);

        System.out.println(map.calulacteDistance(warehouse, p2)); 

        Ware ware1 = map.addWareAt(10, 15);
        Ware ware2 = map.addWareAt(50, 60);
        Ware ware3 = map.addWareAt(90, 25);

        System.out.println(ware1);
        System.out.println(ware2);
        System.out.println(ware3);
        

        for(int i = 0; i  <= 6; i++){

            Point location = warehouse;
            Truck truck =  new Truck(location);
            trucks.add(truck);
        }

    }
}