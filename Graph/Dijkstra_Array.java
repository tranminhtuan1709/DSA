package Graph;

import java.util.ArrayList;

public class Dijkstra_Array {
    static class Adjacency {
        int vertex;
        int weight;

        public Adjacency(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Adjacency>> a;
    public static int[] par;
    public static int[] d;
    public static boolean[] visited;

    public void dijkstra(int s) {
        d[s] = 0;
        for (int i = 1; i <= n; i++) {
            int u = 0;
            int du = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (d[j] < du && !visited[j]) {
                    u = j;
                    du = d[j];
                }
            }
            visited[u] = true;
            for (Adjacency adj : a.get(u)) {
                int v = adj.vertex;
                int wuv = adj.weight;
                if (d[v] > d[u] + wuv) {
                    d[v] = d[u] + wuv;
                    par[v] = u;
                }
            }
        }
    }
}

/*

Complexity:
+ We need a V step of outermost loop,
  in each step of outermost loop, need a V step to find u with du min
  so two first for loop cost O(V^2)
+ There is a maximum of E step to traverse all edge adjacent to u
=> O(V^2 + E)

*/