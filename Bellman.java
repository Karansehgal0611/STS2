package STS2;

import java.util.Arrays;
import java.util.Scanner;

public class Bellman {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int nodes = sc.nextInt(), edgesCount = sc.nextInt();
       int source = sc.nextInt(); // Take source node as input
       int[][] edges = new int[edgesCount][3];
       // Input edges
       for (int i = 0; i < edgesCount; i++) {
           edges[i][0] = sc.nextInt();
           edges[i][1] = sc.nextInt();
           edges[i][2] = sc.nextInt();
       }

       // Distance array, initialized to "infinity" except for the source node
       int[] dist = new int[nodes];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[source] = 0;

       // Relax edges |V|-1 times
       for (int i = 1; i < nodes; i++) {
           for (int[] edge : edges) {
               int u = edge[0], v = edge[1], weight = edge[2];
               if (dist[u] != Integer.MAX_VALUE) {
                   dist[v] = Math.min(dist[v], dist[u] + weight);
               }
           }
       }

       // Detect negative-weight cycles  //Not necessary but if asked for negative cycles then this code
       for (int[] edge : edges) {
           int u = edge[0], v = edge[1], weight = edge[2];
           if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
               System.out.println("-1");
               return;
           }
       }

       // Print shortest distances from source node
       for (int d : dist) {
           System.out.print((d == Integer.MAX_VALUE ? -1 : d) + " ");
       }
   }
}
