package STS2;
import java.util.*;

public class GraphDFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    @SuppressWarnings("unchecked")
    public GraphDFS(int v){
        V = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add edge v -> w
    }

    void dfs(int start){
        boolean[] visited = new boolean[V];
        System.out.println("DFS Traversal:");
        dfsUtil(start, visited);
    }

    void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfsUtil(v, visited);
            }
        }
    }

    void dfsIterative(int start){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        System.out.println("Iterative DFS Traversal:");

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (!visited[u]) {
                System.out.print(u + " ");
                visited[u] = true;

                // Push adjacent nodes in reverse order to simulate recursion
                ListIterator<Integer> it = adj[u].listIterator(adj[u].size());
                while (it.hasPrevious()) {
                    int v = it.previous();
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(6);  // 6 nodes (0 to 5)
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);

        g.dfsIterative(0); // Start DFS from node 0

        g.dfs(0);
    }
}
