package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DFS {
    public static ArrayList<ArrayList<Integer>> a;
    public static ArrayList<Integer> path;
    public static boolean[] visited = new boolean[100005];
    public static int[] par = new int[100005];
    public static int[] d = new int[100005];

    public static void init(int m, int n, ArrayList<ArrayList<Integer>> adjacencyList) {
        a = new ArrayList<>(adjacencyList);
        path = new ArrayList<>();
        Arrays.fill(visited, false);
        Arrays.fill(par, -1);
        Arrays.fill(d, 0);
    }

    public static void dfs(int u) {
        visited[u] = true;
        for (int v : a.get(u)) {
            if (!visited[v]) {
                par[v] = u;
                d[v] = d[u] + 1;
                dfs(v);
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
