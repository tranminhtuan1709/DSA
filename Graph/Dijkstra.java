package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dijkstra {
    public static int vertex, edge;
    public static ArrayList<ArrayList<Adjacent>> a;
    public static ArrayList<Integer> path;
    public static boolean[] visited = new boolean[100005];
    public static double[] d = new double[100005];
    public static int[] par = new int[100005];

    public static void init(int m, int n, ArrayList<ArrayList<Adjacent>> adjacencyList) {
        vertex = m;
        edge = n;
        a = new ArrayList<>(adjacencyList);
        Arrays.fill(visited, false);
        Arrays.fill(d, Double.MAX_VALUE);
        Arrays.fill(par, -1);
    }

    public static void dijkstra(int root) {
        d[root] = 0;
        for (int i = 0; i < vertex; i++) {
            int u = 0;
            double du = Double.MAX_VALUE;
            for (int j = 0; j < vertex; j++) {
                if (d[j] < du && !visited[j]) {
                    u = j;
                    du = d[j];
                }
            }
            visited[u] = true;
            for (Adjacent x : a.get(u)) {
                if (d[x.v] > du + x.w) {
                    par[x.v] = u;
                    d[x.v] = du + x.w;
                }
            }
        }
    }

    public static double getTotalWeight(int u, int root) {
        if (u != root && par[u] == -1) {
            return -1;
        } else {
            return d[u];
        }
    }

    public static ArrayList<Integer> getPath(int u, int root) {
        if (u != root && par[u] == -1) {
            return null;
        }
        while (u != -1) {
            path.add(u);
            u = par[u];
        }
        Collections.reverse(path);
        return path;
    }
}
