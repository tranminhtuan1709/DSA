package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BFS {
    public static ArrayList<ArrayList<Integer>> a;
    public static ArrayList<Integer> path;
    public static ArrayDeque<Integer> q;
    public static int[] par = new int[100005];
    public static boolean[] visited = new boolean[100005];
    public static int[] d = new int[100005];

    public static void init(int m, int n, ArrayList<ArrayList<Integer>> adjacencyList) {
        a = new ArrayList<>(adjacencyList);
        path = new ArrayList<>();
        Arrays.fill(par, -1);
        Arrays.fill(visited, false);
        Arrays.fill(d, 0);
    }

    public static void bfs(int root) {
        q.addLast(root);
        visited[root] = true;
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            for (int v : a.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    par[v] = u;
                    d[v] = d[u] + 1;
                    q.addLast(v);
                }
            }
        }
    }

    public static int getLength(int u) {
        return d[u];
    }

    public static ArrayList<Integer> getPath(int u) {
        while (u != -1) {
            path.add(u);
            u = par[u];
        }
        Collections.reverse(path);
        return path;
    }
}
