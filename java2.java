import java.util.Scanner;
public class ArrayQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue capacity: ");
        int MAX = sc.nextInt();
        int[] queue = new int[MAX];
        int front = -1, rear = -1;
        while (true) {
            System.out.println("\n1.Enqueue  2.Dequeue  3.Display  4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    if (rear == MAX - 1) System.out.println("Queue Overflow");
                    else {
                        System.out.print("Enter element: ");
                        int val = sc.nextInt();
                        if (front == -1) front = 0;
                        queue[++rear] = val;
                    }
                    break;
                case 2:
                    if (front == -1 || front > rear) {
                        System.out.println("Queue Underflow");
                        front = rear = -1;
                    } else System.out.println("Dequeued: " + queue[front++]);
                    break;
                case 3:
                    if (front == -1 || front > rear) System.out.println("Queue Empty");
                    else {
                        System.out.print("Queue: ");
                        for (int i = front; i <= rear; i++) System.out.print(queue[i] + " ");
                        System.out.println();
                    }
                    break;
                case 4: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
