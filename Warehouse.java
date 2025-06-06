import java.util.Random;

public class Warehouse {
    
    public Point location;


    int max = 200;
    int min = 100;
    int range = max - min + 1;

    public Warehouse(Point location){
        this.location = location;

    }

    @Override
    public String toString() {
        return "Warehouse {\n" +
                "  location = [" + location.x + "," + location.y + "],\n" +
                "}";
    }

}
