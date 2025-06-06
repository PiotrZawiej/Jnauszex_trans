import java.util.concurrent.ThreadLocalRandom;

public enum PointType {
    DELIVERY,
    TAKEAWAY,
    WAREHOUSE;

    public static PointType getOrderType(){
        if(ThreadLocalRandom.current().nextBoolean())
            return PointType.DELIVERY;
        else
            return PointType.TAKEAWAY;
    }

}
