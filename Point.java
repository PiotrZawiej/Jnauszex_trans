public class Point{
    
    public int x;
    public int y;
    public PointType pointType;

    public Point(int x, int y, boolean isWarehouse){

        this.x = x;
        this.y = y;
        if(isWarehouse)
            this.pointType = PointType.WAREHOUSE;
        else
            this.pointType = PointType.getOrderType();
    }

    public double calulacteDistance(Point other){
        int dx = this.x - other.x;
        int dy = this.y - other.y;

        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        return distance;
    }

    public static Point getRandomPoint(boolean isWarehouse){
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        int randX = (int)(Math.random() * range) + min;
        int randY = (int)(Math.random() * range) + min;
        return new Point(randX, randY, isWarehouse);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ") " + pointType.toString();
    }

}
