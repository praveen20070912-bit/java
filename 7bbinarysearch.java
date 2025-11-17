import java.util.Scanner;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (sorted array): ");
        int n = sc.nextInt(); int[] a = new int[n];
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.print("Enter key: ");
        int key = sc.nextInt();
        int l = 0, r = n - 1, pos = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == key) { pos = m; break; }
            if (a[m] < key) l = m + 1; else r = m - 1;
        }
        if (pos == -1) System.out.println("Not Found");
        else System.out.println("Found at index " + pos);
    }
}
