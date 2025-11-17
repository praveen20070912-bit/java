import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        System.out.println("After Bubble Sort:");
        for (int x : a) System.out.print(x + " ");
    }
}
