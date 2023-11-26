package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static ArrayList<ArrayList<Integer>> v;
    public static boolean[] visited = new boolean[100005];
    public static int[] par = new int[100005];
    public static int[] d = new int[100005];
    public static int vertex, edge;

    public static void init(ArrayList<ArrayList<Integer>> v, int m, int n) {
        vertex = m;
        edge = n;
        Arrays.fill(visited, false);
        Arrays.fill(par, -1);
        Arrays.fill(d, 0);
        v = new ArrayList<ArrayList<Integer>>(v);
    }

    public static void dfs(int u) {
        visited[u] = true;
        for (int i : v.get(u)) {
            if (!visited[i]) {
                visited[i] = true;
                par[i] = u;
                d[i] = d[u] + 1;
                dfs(i);
            }
        }
    }

    public static ArrayList<Integer> tracing(int u) {
        ArrayList<Integer> path = new ArrayList<>();
        int i = u;
        while (i != -1) {
            path.add(i);
            i = par[i];
        }
        return path;
    }
}
