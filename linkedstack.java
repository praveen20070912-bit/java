import java.util.Scanner;

class LNode {
    int data; LNode next;
    LNode(int d) { data = d; next = null; }
}

public class LinkedListStack {
    static LNode top = null;

    static void push(int x) {
        LNode n = new LNode(x);
        n.next = top; top = n;
    }

    static void pop() {
        if (top == null) System.out.println("Stack Underflow");
        else { System.out.println("Popped: " + top.data); top = top.next; }
    }

    static void display() {
        if (top == null) { System.out.println("Stack Empty"); return; }
        System.out.println("Stack (top->bottom):");
        for (LNode t = top; t != null; t = t.next) System.out.println(t.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Push 2.Pop 3.Display 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: System.out.print("Enter element: "); push(sc.nextInt()); break;
                case 2: pop(); break;
                case 3: display(); break;
                case 4: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
