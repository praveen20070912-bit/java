import java.util.Scanner;

class QNode {
    int data; QNode next;
    QNode(int d) { data = d; next = null; }
}

public class LinkedListQueue {
    static QNode front = null, rear = null;

    static void enqueue(int x) {
        QNode n = new QNode(x);
        if (rear == null) front = rear = n;
        else { rear.next = n; rear = n; }
    }

    static void dequeue() {
        if (front == null) System.out.println("Queue Underflow");
        else {
            System.out.println("Dequeued: " + front.data);
            front = front.next;
            if (front == null) rear = null;
        }
    }

    static void display() {
        if (front == null) { System.out.println("Queue Empty"); return; }
        System.out.print("Queue: ");
        for (QNode t = front; t != null; t = t.next) System.out.print(t.data + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Enqueue 2.Dequeue 3.Display 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: System.out.print("Enter element: "); enqueue(sc.nextInt()); break;
                case 2: dequeue(); break;
                case 3: display(); break;
                case 4: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
