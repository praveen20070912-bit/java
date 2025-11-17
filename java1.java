import java.util.Scanner;
public class ArrayStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack capacity: ");
        int MAX = sc.nextInt();
        int[] stack = new int[MAX];
        int top = -1;
        while (true) {
            System.out.println("\n1.Push  2.Pop  3.Display  4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    if (top == MAX - 1) System.out.println("Stack Overflow");
                    else {
                        System.out.print("Enter element: ");
                        stack[++top] = sc.nextInt();
                    }
                    break;
                case 2:
                    if (top == -1) System.out.println("Stack Underflow");
                    else System.out.println("Popped: " + stack[top--]);
                    break;
                case 3:
                    if (top == -1) System.out.println("Stack Empty");
                    else {
                        System.out.println("Stack elements (top->bottom):");
                        for (int i = top; i >= 0; i--) System.out.println(stack[i]);
                    }
                    break;
                case 4:
                    System.out.println("Exit"); sc.close(); System.exit(0);
                    break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
