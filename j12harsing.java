import java.util.Scanner;
public class HashLinearProbing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter table size (e.g., 10): ");
        int size = sc.nextInt();
        int[] table = new int[size];
        for (int i = 0; i < size; i++) table[i] = Integer.MIN_VALUE; // empty marker

        while (true) {
            System.out.println("\n1.Insert 2.Search 3.Display 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter key (int): ");
                    int key = sc.nextInt();
                    int idx = key % size;
                    while (table[idx] != Integer.MIN_VALUE && table[idx] != Integer.MIN_VALUE + 1) idx = (idx + 1) % size;
                    table[idx] = key;
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    key = sc.nextInt();
                    idx = key % size;
                    int cnt = 0;
                    boolean found = false;
                    while (cnt < size && table[idx] != Integer.MIN_VALUE) {
                        if (table[idx] == key) { found = true; break; }
                        idx = (idx + 1) % size; cnt++;
                    }
                    System.out.println(found ? "Found at index " + idx : "Not Found");
                    break;
                case 3:
                    System.out.println("Table:");
                    for (int i = 0; i < size; i++) {
                        if (table[i] == Integer.MIN_VALUE) System.out.println(i + " -> empty");
                        else System.out.println(i + " -> " + table[i]);
                    }
                    break;
                case 4: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
