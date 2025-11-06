import java.util.*;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Knapsack_greedy {

    // Function to solve fractional knapsack using greedy approach
    static double fractionalKnapsack(Item[] items, int capacity) {
        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(
                (double) b.value / b.weight, 
                (double) a.value / a.weight
        ));

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        System.out.println("\nSelected Items:");

        for (Item item : items) {
            if (remainingCapacity == 0)
                break;

            if (item.weight <= remainingCapacity) {
                // Take full item
                totalValue += item.value;
                remainingCapacity -= item.weight;
                System.out.println("Item weight " + item.weight + ", value " + item.value + ", fraction taken: 1.0");
            } else {
                // Take fractional part of item
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                System.out.println("Item weight " + item.weight + ", value " + item.value + ", fraction taken: " + String.format("%.2f", fraction));
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("\nEnter weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " weight: ");
            int w = sc.nextInt();
            System.out.print("Item " + (i + 1) + " value: ");
            int v = sc.nextInt();
            items[i] = new Item(w, v);
        }

        System.out.print("\nEnter maximum capacity of knapsack: ");
        int capacity = sc.nextInt();

        double maxValue = fractionalKnapsack(items, capacity);
        System.out.println("\nMaximum value achievable: " + String.format("%.2f", maxValue));

        sc.close();
    }
}
