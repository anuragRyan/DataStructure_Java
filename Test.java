import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    LinkedList<Integer> adj[];

    public Test(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest) {
        adj[source].add(dest);
        adj[dest].add(source);
    }

    public int bfs(int source, int dest) {
        boolean[] visited = new boolean[adj.length];
        int[] parent = new int[adj.length];
        parent[source] = -1;
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == dest)
                break;

            for (int neighbour : adj[cur]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                    parent[neighbour] = cur;
                }
            }

        }
        int cur = dest;
        int dist = 0;

        while (parent[cur] != -1) {
            System.out.print(cur + " -> ");
            cur = parent[cur];
            dist++;
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int v = sc.nextInt();
        Test graph = new Test(v);

        System.out.println("Enter the no of edges: ");
        int e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();

            graph.addEdge(source, dest);
        }
        System.out.println("Distance: " + graph.bfs(0, 4));

        sc.close();
    }
}
