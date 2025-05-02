package STS2;

import java.util.*;

public class GraphBFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    @SuppressWarnings("unchecked")
    public GraphBFS(int v) {
        V = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v]; // Safe cast
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list
    }

    void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(6); // 6 nodes (0 to 5)
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);

        g.bfs(0); // Start BFS from node 0
    }
}
