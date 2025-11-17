import java.util.Scanner;
public class ArrayListImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int size = 0;
        while (true) {
            System.out.println("\n1.Insert at pos  2.Delete at pos  3.Display  4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter position (0-based) and element: ");
                    int pos = sc.nextInt();
                    int val = sc.nextInt();
                    if (pos < 0 || pos > size) {
                        System.out.println("Invalid position");
                    } else {
                        for (int i = size - 1; i >= pos; i--) arr[i + 1] = arr[i];
                        arr[pos] = val; size++;
                    }
                    break;
                case 2:
                    System.out.print("Enter position to delete (0-based): ");
                    pos = sc.nextInt();
                    if (pos < 0 || pos >= size) System.out.println("Invalid position");
                    else {
                        for (int i = pos; i < size - 1; i++) arr[i] = arr[i + 1];
                        size--;
                    }
                    break;
                case 3:
                    System.out.println("List elements:");
                    for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");
                    System.out.println();
                    break;
                case 4: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
