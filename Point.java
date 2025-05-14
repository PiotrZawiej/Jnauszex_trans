public class Point{
    
    public int x;
    public int y;

    public Point(int x, int y){

        this.x = x;
        this.y = y;

    }

    public double calulacteDistance(Point other){
        int dx = this.x - other.x;
        int dy = this.y - other.y;

        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        return distance;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
