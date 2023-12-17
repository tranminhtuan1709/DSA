package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra_PriorityQueue {
    static class Adjacency {
        int vertex;
        int weight;

        public Adjacency(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class Pair {
        int vertex;
        int distance;

        public Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Adjacency>> a;
    public static PriorityQueue<Pair> pQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
    public static int[] par;
    public static int[] d;
    public static boolean[] visited;

    public static void init() {
        Arrays.fill(par, -1);
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
    }

    public static void dijkstra(int s) {
        d[s] = 0;
        pQueue.add(new Pair(s, d[s]));
        while (!pQueue.isEmpty()) {
            int u = pQueue.poll().vertex;
            if (!visited[u]) {
                visited[u] = true;
                for (Adjacency i : a.get(u)) {
                    int v = i.vertex;
                    int wuv = i.weight;
                    if (d[v] > d[u] + wuv) {
                        par[v] = u;
                        d[v] = d[u] + wuv;
                        pQueue.add(new Pair(v, d[v]));
                    }
                }
            }
        }
    }
}

/*

Complexity:
+ The maximum element in pQueue is E so that the number of poll() is E
  and each poll() cost logE => ElogE
+ The maximum of for loop is E and if there is a call to add(), it costs logE => ElogE
=> O(ElogE + ElogE) ~ O(ElogE)

*/