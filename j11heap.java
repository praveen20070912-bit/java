import java.util.*;
public class HeapPriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        while (true) {
            System.out.println("\n1.Insert 2.DeleteMax 3.Display 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: System.out.print("Enter element: "); pq.add(sc.nextInt()); break;
                case 2:
                    if (pq.isEmpty()) System.out.println("Heap empty");
                    else System.out.println("Deleted max: " + pq.poll());
                    break;
                case 3: System.out.println("Heap elements (unordered): " + pq); break;
                case 4: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
