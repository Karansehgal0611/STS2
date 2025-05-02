package STS2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class topo{
    static int V, adj[][];
    static void topoSort(int v, boolean[] vis, Stack<Integer> st) {
        vis[v] = true;
        for (int i = 0; i < V; i++) if (adj[v][i] == 1 && !vis[i]) topoSort(i, vis, st);
        st.push(v);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        adj = new int[V][V];
        for (int v, e; (v = sc.nextInt()) != -1 && (e = sc.nextInt()) != -1; adj[v][e] = 1);
        boolean[] vis = new boolean[V]; Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) if (!vis[i]) topoSort(i, vis, st);
        while (!st.isEmpty()) System.out.print(st.pop() + " ");
    }
}