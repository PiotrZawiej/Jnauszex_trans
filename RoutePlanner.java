import java.util.*;

public class RoutePlanner {

    public static void assignOrdersToTrucks(List<Order> orders, List<Truck> trucks, List<Warehouse> warehouseList) {
        // Lista wszystkich aktywnych zamówień
        List<Order> remainingOrders = new ArrayList<>(orders);

        // Inicjalizacja stanu każdej ciężarówki
        for (Truck truck : trucks) {
            truck.route = new ArrayList<>();
            truck.route.add(truck.location);
            truck.stops = new ArrayList<>();
            truck.assignedOrders = new ArrayList<>();
        }

        // Pętla główna – dopóki są zamówienia do zrealizowania
        while (!remainingOrders.isEmpty()) {
            Stop bestStop = null;
            Truck bestTruck = null;
            double bestDistance = Double.MAX_VALUE;

            // Szukamy najlepszego (Truck, Stop) w danym kroku
            for (Truck truck : trucks) {
                Point current = truck.route.get(truck.route.size() - 1);
                int currentLoad = truck.stops.stream().mapToInt(Stop::getWeightChange).sum();
                Set<Order> activeOrders = new HashSet<>();
                for (Stop stop : truck.stops) {
                    if (stop.type == Stop.ActionType.PICKUP) activeOrders.add(stop.order);
                    else activeOrders.remove(stop.order);
                }

                for (Order order : remainingOrders) {
                    // Uzupełnianie brakujących punktów
                    if (order.sourcePoint == null && order.targetPoint != null) {
                        order.sourcePoint = findNearestWarehouse(order.targetPoint, warehouseList);
                    }
                    if (order.targetPoint == null && order.sourcePoint != null) {
                        order.targetPoint = findNearestWarehouse(order.sourcePoint, warehouseList);
                    }
                    if (order.sourcePoint == null || order.targetPoint == null) continue;

                    // Jeśli towar już na pokładzie – dostawa
                    if (activeOrders.contains(order)) {
                        double dist = current.calulacteDistance(order.targetPoint);
                        if (dist < bestDistance) {
                            bestDistance = dist;
                            bestTruck = truck;
                            bestStop = new Stop(order, order.targetPoint, Stop.ActionType.DELIVER);
                        }
                    }
                    // Inaczej – pickup jeśli się zmieści
                    else if (order.totalKg + currentLoad <= truck.maxCapacity) {
                        double dist = current.calulacteDistance(order.sourcePoint);
                        if (dist < bestDistance) {
                            bestDistance = dist;
                            bestTruck = truck;
                            bestStop = new Stop(order, order.sourcePoint, Stop.ActionType.PICKUP);
                        }
                    }
                }
            }

            // Jeśli nie ma możliwego przystanku – kończymy
            if (bestStop == null || bestTruck == null) break;

            // Zaktualizuj trasę i stan ciężarówki
            bestTruck.stops.add(bestStop);
            bestTruck.route.add(bestStop.location);

            if (bestStop.type == Stop.ActionType.PICKUP) {
                bestTruck.assignedOrders.add(bestStop.order);
            } else {
                remainingOrders.remove(bestStop.order);
            }
        }

        // Wyświetlanie tras ciężarówek
        for (Truck truck : trucks) {
            System.out.println("\nTruck (" + (truck.hashCode() % 10000)  + ") " + truck.color + " route (Max " + truck.maxCapacity +"kg):");
            int currentLoad = 0;
            for (Stop stop : truck.stops) {
                currentLoad += stop.getWeightChange();
                System.out.println(" → " + stop + " | Current Load: " + currentLoad + "kg");
            }
        }

        // Zamówienia nieprzypisane
        if (!remainingOrders.isEmpty()) {
            System.out.println("\nUnassigned orders:");
            for (Order order : remainingOrders) System.out.println(order);
        }
    }

    // Znajduje najbliższy magazyn względem danego punktu
    private static Point findNearestWarehouse(Point reference, List<Warehouse> warehouses) {
        Point nearest = null;
        double minDist = Double.MAX_VALUE;
        for (Warehouse wh : warehouses) {
            double dist = reference.calulacteDistance(wh.location);
            if (dist < minDist) {
                minDist = dist;
                nearest = wh.location;
            }
        }
        return nearest;
    }
}