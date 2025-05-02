package STS2;

import java.util.*;
public class DFS {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       List<List<Integer>> adj = new ArrayList<>(n);
       for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
       while (true) {
           int u = sc.nextInt(), v = sc.nextInt();
           if (u == -1 && v == -1) break;
           adj.get(u).add(v);
       }
       Stack<Integer> stack = new Stack<>();
       boolean[] vis = new boolean[n];
       stack.push(0);
       System.out.print("DFS : ");
       while (!stack.isEmpty()) {
           int node = stack.pop();
           if (vis[node]) continue;
           vis[node] = true;
           System.out.print(node + " ");
           for (int next : adj.get(node)) {
               if (!vis[next]) {
                   stack.push(next);
               }
           }
       }
   }
}
