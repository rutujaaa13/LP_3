import java.util.Scanner;

public class FIBONNACI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("\nNon-Recursive Fibonacci of " + n + " is: " + fibonacciNonRecursive(n));
        System.out.println("Recursive Fibonacci of " + n + " is: " + fibonacciRecursive(n));

        analyzeComplexity();

        sc.close();
    }

    private static int  fibonacciRecursive(int n) {

        if(n<=0)return 0;
        if(n==1)return 1;

        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
    static void analyzeComplexity() {
        System.out.println("\n--- Time and Space Complexity ---");
        System.out.println("Non-Recursive Fibonacci:");
        System.out.println("  Time Complexity: O(n)");
        System.out.println("  Space Complexity: O(1)");

        System.out.println("\nRecursive Fibonacci:");
        System.out.println("  Time Complexity: O(2^n)");
        System.out.println("  Space Complexity: O(n)");
    }


    private static int fibonacciNonRecursive(int n) {
        if(n<=0)return 0;
        if(n==1)return 1;
        int a =0;
        int b =1;
        for(int i=2;i<=n;i++)
        {
            int c = a+b;
             a = b;
             b = c;

        }
        return b;

    }
}
