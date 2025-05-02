package STS2;

import java.util.*;
import java.util.LinkedList;

public class TopologicalSort {
    // Adjacency list to represent the graph
    private Map<Integer,List<Integer>> adj;
    private int V;

    public TopologicalSort(int vertices){
        this.V = vertices;
        this.adj = new HashMap<>();
        for(int i = 0; i < vertices; i++){
            this.adj.put(i, new ArrayList<>());
        }
    }

    public void createEdge(int u, int v){
        this.adj.get(u).add(v);
    }

    public void topological(){
        int[] indegree = new int[V];
        Arrays.fill(indegree, 0);
        // Calculate indegree of each vertex
        for(int i = 0; i < V; i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        // Queue to store vertices with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        
        int visitedNodes = 0;
        List<Integer> order = new ArrayList<>();

        // Process all vertices with indegree 0
        while(!queue.isEmpty()){
            int u = queue.poll();
            order.add(u);

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.add(v);
                }
            }
            visitedNodes++;
        }


        if(visitedNodes != V){
            System.out.println("There's a Cycle present");
        }
        else{
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.createEdge(0, 1);
        graph.createEdge(0, 2);
        graph.createEdge(1, 3);
        graph.createEdge(1, 5);
        graph.createEdge(2, 3);
        graph.createEdge(2, 5);
        graph.createEdge(3, 4);
        graph.createEdge(5, 4);

        graph.topological();
    }
}
