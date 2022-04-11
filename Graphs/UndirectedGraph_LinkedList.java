package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraph_LinkedList {
    LinkedList<Integer>[] adj;
    private int V;

    public UndirectedGraph_LinkedList(int nodes) {
        V = nodes;
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest) {
        this.adj[source].add(dest);
        this.adj[dest].add(source);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            sb.append(i + ":");
            for (int w : adj[i]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        System.out.print("DFS: ");
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : adj[u]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        UndirectedGraph_LinkedList ugList = new UndirectedGraph_LinkedList(5);
        ugList.addEdge(0, 1);
        ugList.addEdge(1, 2);
        ugList.addEdge(2, 3);
        ugList.addEdge(3, 0);
        ugList.addEdge(4, 2);

        System.out.println(ugList);
        ugList.bfs(0);
        ugList.dfs(0);
    }

}
