import java.util.Scanner;

public class PolynomialAddition {
    // polynomials represented as arrays index = power
    static int[] readPoly(Scanner sc) {
        System.out.print("Enter highest power: ");
        int p = sc.nextInt();
        int[] poly = new int[p + 1];
        System.out.println("Enter coefficients from highest power to 0:");
        for (int i = p; i >= 0; i--) poly[i] = sc.nextInt();
        return poly;
    }

    static int[] add(int[] a, int[] b) {
        int max = Math.max(a.length, b.length);
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            int av = (i < a.length) ? a[i] : 0;
            int bv = (i < b.length) ? b[i] : 0;
            res[i] = av + bv;
        }
        return res;
    }

    static void printPoly(int[] p) {
        boolean first = true;
        for (int i = p.length - 1; i >= 0; i--) {
            if (p[i] == 0) continue;
            if (!first && p[i] > 0) System.out.print(" + ");
            if (i == 0) System.out.print(p[i]);
            else if (i == 1) System.out.print(p[i] + "x");
            else System.out.print(p[i] + "x^" + i);
            first = false;
        }
        if (first) System.out.print("0");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Polynomial 1:");
        int[] p1 = readPoly(sc);
        System.out.println("Polynomial 2:");
        int[] p2 = readPoly(sc);
        int[] sum = add(p1, p2);
        System.out.print("Sum: ");
        printPoly(sum);
    }
}
