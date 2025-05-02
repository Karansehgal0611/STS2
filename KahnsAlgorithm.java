package STS2;

import java.util.*;

public class KahnsAlgorithm {
    public static void topologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];

        // Step 1: Compute in-degrees
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        // Step 2: Enqueue vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> topoOrder = new ArrayList<>();

        // Step 3: BFS traversal
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Step 4: Check for cycles
        if (topoOrder.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
        } else {
            System.out.println("Topological Sort (Kahn's Algorithm):");
            for (int node : topoOrder)
                System.out.print(node + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Directed graph edges
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topologicalSort(V, adj);
    }
}
