import java.util.ArrayList;
import java.util.List;

public class Map {
    
    public final int height = 100;
    public final int width = 100;

    public  List<Point> deliveryPoints;

    public Map() {
        this.deliveryPoints = new ArrayList<>();
    }

    public void addPoint(int x, int y) {
        if (x >= 0 && x <= width && y >= 0 && y <= height) {
            deliveryPoints.add(new Point(x, y));
        } else {
            throw new IllegalArgumentException("Point out of range!");
        }
    }

    public double calulacteDistance(Point p1, Point p2) {

        return p1.calulacteDistance(p2);
    }
    

    public Ware addWareAt(int x, int y) {
        Point point = new Point(x, y);
        deliveryPoints.add(point); 
        return new Ware(point);
    }

}
