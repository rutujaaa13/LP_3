import java.util.Scanner;

public class Knapsack_DP {

    // Function to solve 0/1 Knapsack using Dynamic Programming
    static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // Backtrack to find selected items
        int res = dp[n][capacity];
        int w = capacity;

        System.out.println("\nSelected Items:");
        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                System.out.println("Item with weight " + weights[i - 1] + " and value " + values[i - 1]);
                res -= values[i - 1];
                w -= weights[i - 1];
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        System.out.println("\nEnter values and weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = sc.nextInt();
        }

        System.out.print("\nEnter maximum capacity of knapsack: ");
        int capacity = sc.nextInt();

        int maxValue = knapsack(values, weights, capacity);
        System.out.println("\nMaximum value achievable: " + maxValue);

        sc.close();
    }
}
