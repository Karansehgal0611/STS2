package STS2;
import java.util.*;
import java.util.LinkedList;

public class BFS {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       if (n == 0) {
           System.out.println("Graph doesn't exist");
           return;
       }
       List<List<Integer>> adj = new ArrayList<>(n);
       for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
       while (true) {
           int u = sc.nextInt(), v = sc.nextInt();
           if (u == -1 && v == -1) break;
           adj.get(u).add(v);
       }
       Queue<Integer> q = new LinkedList<>();
       boolean[] vis = new boolean[n];
       q.add(0);
       vis[0] = true;
       System.out.print("BFS : ");
       while (!q.isEmpty()) {
           int node = q.poll();
           System.out.print(node + " ");
           for (int next : adj.get(node))
               if (!vis[next]) {
                   q.add(next);
                   vis[next] = true;
               }
       }
   }
}