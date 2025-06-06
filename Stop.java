public class Stop {
    public enum ActionType { PICKUP, DELIVER }
    public Order order;
    public Point location;
    public ActionType type;

    public Stop(Order order, Point location, ActionType type) {
        this.order = order;
        this.location = location;
        this.type = type;
    }

    // Zmiana masy ładunku przy danym przystanku
    public int getWeightChange() {
        return type == ActionType.PICKUP ? order.totalKg : -order.totalKg;
    }

    @Override
    public String toString() {
        return type + " " + location + " (Order: " + order.hashCode() % 10000 + ", " + order.totalKg + "kg)";
    }
}