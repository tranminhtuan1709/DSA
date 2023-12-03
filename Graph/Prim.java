package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
    public static double totalWeight = 0;
    public static ArrayList<ArrayList<Adjacent>> a;
    public static PriorityQueue<PrimQueueElement> q;
    public static ArrayList<Edge> mst;
    public static double[] d = new double[100005];
    public static boolean[] visited = new boolean[100005];
    public static int[] par = new int[100005];

    public static void init(int m, int n, ArrayList<ArrayList<Adjacent>> adjacencyList) {
        a = new ArrayList<>(adjacencyList);
        mst = new ArrayList<>();
        q = new PriorityQueue<>(Comparator.comparingDouble(o -> o.distance));
        Arrays.fill(d, Double.MAX_VALUE);
        Arrays.fill(visited, false);
        Arrays.fill(par, -1);
    }

    public static void prim(int root) {
        d[root] = 0;
        q.add(new PrimQueueElement(root, 0));
        while (!q.isEmpty()) {
            int u = q.peek().vertex;
            q.poll();
            if (!visited[u]) {
                visited[u] = true;
                totalWeight += d[u];
                if (par[u] != -1) {
                    mst.add(new Edge(u, par[u], d[u]));
                }
                for (Adjacent i : a.get(u)) {
                    if (d[i.v] > i.w) {
                        d[i.v] = i.w;
                        par[i.v] = u;
                        q.add(new PrimQueueElement(i.v, d[i.v]));
                    }
                }
            }
        }
    }

    public static double getTotalWeight() {
        return totalWeight;
    }

    public static ArrayList<Edge> getMst() {
        return mst;
    }
}
