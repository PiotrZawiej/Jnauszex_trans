import java.util.Random;

public class Order {
    public int orangeKg;
    public int uraniumKg;
    public int tunaKg;

    public int totalKg;

    public Order(int totalKg) {
        Random rand = new Random();

         this.totalKg = totalKg;

        int first = rand.nextInt(totalKg + 1); 
        int second = rand.nextInt(totalKg + 1);

        int a = Math.min(first, second);
        int b = Math.max(first, second);

        orangeKg = a;
        uraniumKg = b - a;
        tunaKg = totalKg - b;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orangeKg=" + orangeKg +
            ", uraniumKg=" + uraniumKg +
            ", tunaKg=" + tunaKg +
            ", totalKg=" + totalKg +
            '}';
    }

}
