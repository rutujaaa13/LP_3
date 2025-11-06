import java.util.*;

class HuffmanNode {
    int freq;
    char symbol;
    HuffmanNode left, right;

    HuffmanNode(char symbol, int freq) {
        this.symbol = symbol;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}

public class HuffmanEncoding {

    // Recursive function to print Huffman codes
    static void printCodes(HuffmanNode root, String code) {
        if (root == null)
            return;

        // If it's a leaf node → print symbol and its code
        if (root.left == null && root.right == null && root.symbol != '#') {
            System.out.println(root.symbol + " -> " + code);
            return;
        }

        // Traverse left and right
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freqs = new int[n];

        System.out.println("\nEnter characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            chars[i] = sc.next().charAt(0);
            System.out.print("Frequency of " + chars[i] + ": ");
            freqs[i] = sc.nextInt();
        }

        // Priority Queue (min-heap) based on frequency
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        // Step 1: Create leaf nodes and add to queue
        for (int i = 0; i < n; i++) {
            pq.add(new HuffmanNode(chars[i], freqs[i]));
        }

        // Step 2: Build Huffman Tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode newNode = new HuffmanNode('#', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        // Step 3: Print Huffman Codes
        System.out.println("\n--- Huffman Codes ---");
        printCodes(pq.peek(), "");

        sc.close();
    }
}
