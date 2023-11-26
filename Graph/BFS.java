package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class BFS {
    public static ArrayList<ArrayList<Integer>> v;
    public static ArrayDeque<Integer> q = new ArrayDeque<>();
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
        v = new ArrayList<>(v);
    }

    public static void bfs(int x) {
        q.push(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            for (int i : v.get(u)) {
                if (!visited[i]) {
                    d[i] = d[u] + 1;
                    par[i] = u;
                    visited[i] = true;
                    q.push(i);
                }
            }
        }
    }

    public static ArrayList<Integer> tracing(int u) {
        int i = u;
        ArrayList<Integer> path = new ArrayList<>();
        while (i != -1) {
            path.add(i);
            i = par[i];
        }
        return path;
    }
}
