import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] adj = new int[n][n];
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();
        System.out.println("Enter edges (u v) 0-based:");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj[u][v] = 1; adj[v][u] = 1;
        }
        System.out.print("Enter start vertex: ");
        int s = sc.nextInt();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s); vis[s] = true;
        System.out.print("BFS Order: ");
        while (!q.isEmpty()) {
            int v = q.poll(); System.out.print(v + " ");
            for (int i = 0; i < n; i++)
                if (adj[v][i] == 1 && !vis[i]) { vis[i] = true; q.add(i); }
        }
        System.out.println();
    }
}
