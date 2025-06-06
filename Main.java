import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static List<Order> orders = new ArrayList<>();
    public static List<Warehouse> warehouseList = new ArrayList<>();

    public static void main(String[] args) {

        List<Truck> trucks = new ArrayList<>();
        
        CityMap cityMap = new CityMap();




        // 1. Zestaw poczatkowych punktow do ktorych nalezy przywiezc towar
        for(int i = 0; i <= 50; i++){
            cityMap.addpoints(Point.getRandomPoint(false));
        }

        System.out.println("Delivery points: " + cityMap.points);

        for (int i = 0; i < 5; i++) {
            Warehouse wh = cityMap.addWareAt(Point.getRandomPoint(true));
            System.out.println(wh);
            warehouseList.add(wh);
        }

        int truckNum = ThreadLocalRandom.current().nextInt(3, 7);
        for(int i = 0; i  <= truckNum-1; i++){
            Truck truck =  new Truck(warehouseList.get(ThreadLocalRandom.current().nextInt(0, 5)).location);
            trucks.add(truck);
        }

        System.out.println(trucks);

        for(Point point : cityMap.points){
            if(point.pointType == PointType.WAREHOUSE)
                continue;
            Order order = new Order(ThreadLocalRandom.current().nextInt(100, 201));
            if(point.pointType == PointType.TAKEAWAY)
                order.sourcePoint = point;
            else
                order.targetPoint = point;
            System.out.println(order);
            orders.add(order);
        }

        RoutePlanner.assignOrdersToTrucks(Main.orders, trucks, warehouseList);

    }


}