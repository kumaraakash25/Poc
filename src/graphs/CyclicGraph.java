package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CyclicGraph {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vrtcs = Integer.parseInt(br.readLine()); // 3
        List<Edge>[] graph = new ArrayList[vrtcs]; // Array of lists size 3

        for (int i = 0; i < vrtcs; i++) {
            graph[i] = new ArrayList<>(); // Initialising the list for each vertex
        }
        int edges = Integer.parseInt(br.readLine()); // 3
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]); //1         2         3
            int v2 = Integer.parseInt(parts[1]); //2         1
            int wt = Integer.parseInt(parts[2]); //10        20
            graph[v1].add(new Edge(v1, v2, wt)); // 1-2      2-1
            graph[v2].add(new Edge(v2, v1, wt)); // 2-1      1-2
        }

        boolean[] visited = new boolean[vrtcs];
        for (int v = 0; v < vrtcs; v++) {


            if (!visited[v]) {
                // traverse and do work
                boolean isCycle = isCyclic(graph, v, visited);
                if (isCycle) {
                    System.out.println("Cycle detected");
                    return;
                }
            }
        }

    }

    public static boolean isCyclic(List<Edge>[] graph, int src, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        while (queue.size() > 0) {
            int element = queue.remove();
            if (visited[element]) {
                return true;
            }
            visited[element] = true;
            for (Edge e : graph[element]) {
                if (!visited[element]) {
                    queue.add(e.number);
                }
            }
        }
        return false;
    }
}
