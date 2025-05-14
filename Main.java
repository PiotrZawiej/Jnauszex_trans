import java.util.ArrayList;

public class Main {

    public static int RandomMagazine(){
        int max = 0;
        int min = 4;
        int range = max - min + 1;

        return (int)(Math.random() * range) + min;
    }

    public static void main(String[] args) {

        ArrayList<Truck> trucks = new ArrayList<>();
        
        Map map = new Map();

        int max = 100;
        int min = 1;
        int range = max - min + 1;

        for(int i = 0; i <= 5; i++){
            int randX = (int)(Math.random() * range) + min;
            int randY = (int)(Math.random() * range) + min;
            map.addPoint(randX, randY);

        }

        System.out.println(map.deliveryPoints);

        Ware ware1 = map.addWareAt(10, 15);
        Ware ware2 = map.addWareAt(50, 60);
        Ware ware3 = map.addWareAt(90, 25);

        System.out.println(ware1);
        System.out.println(ware2);
        System.out.println(ware3);
        

        for(int i = 0; i  <= 6; i++){
            Point warehouse = map.deliveryPoints.get(RandomMagazine());

            Point location = warehouse;
            Truck truck =  new Truck(location);
            trucks.add(truck);
        }

        System.out.println(trucks);


    }
}