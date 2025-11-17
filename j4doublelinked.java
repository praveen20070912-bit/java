import java.util.Scanner;

class DNode {
    int data; DNode prev, next;
    DNode(int d) { data = d; }
}

public class DoublyLinkedList {
    static DNode head = null;

    static void insertEnd(int x) {
        DNode n = new DNode(x);
        if (head == null) head = n;
        else {
            DNode t = head;
            while (t.next != null) t = t.next;
            t.next = n; n.prev = t;
        }
    }

    static void deleteValue(int x) {
        DNode t = head;
        while (t != null && t.data != x) t = t.next;
        if (t == null) { System.out.println("Not found"); return; }
        if (t.prev != null) t.prev.next = t.next; else head = t.next;
        if (t.next != null) t.next.prev = t.prev;
        System.out.println("Deleted " + x);
    }

    static void display() {
        if (head == null) { System.out.println("List Empty"); return; }
        System.out.print("List: ");
        for (DNode t = head; t != null; t = t.next) System.out.print(t.data + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.InsertEnd 2.DeleteValue 3.Display 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: System.out.print("Enter element: "); insertEnd(sc.nextInt()); break;
                case 2: System.out.print("Enter value to delete: "); deleteValue(sc.nextInt()); break;
                case 3: display(); break;
                case 4: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
