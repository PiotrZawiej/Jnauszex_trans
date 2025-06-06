import java.util.ArrayList;
import java.util.List;

public class CityMap {
    
//    public final int height = 100;
//    public final int width = 100;

    public  List<Point> points;

    public CityMap() {
        this.points = new ArrayList<>();
    }

    public void addpoints(Point point) {
        points.add(point);
    }

    public double calulacteDistance(Point p1, Point p2) {

        return p1.calulacteDistance(p2);
    }
    

    public Warehouse addWareAt(Point point) {
        points.add(point);
        return new Warehouse(point);
    }

}
