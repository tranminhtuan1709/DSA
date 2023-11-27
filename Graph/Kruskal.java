package Graph;

import java.util.ArrayList;
import java.util.Comparator;

public class Kruskal {
    public static double totalWeight = 0;
    public static ArrayList<Edge> a;
    public static ArrayList<Edge> mst;
    public static int[] par = new int[100005];

    public static void init(int m, int n, ArrayList<Edge> edgeList) {
        a = new ArrayList<>(edgeList);
        mst = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        } else {
            par[x] = find(par[x]);
            return par[x];
        }
    }

    public static boolean join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return false;
        } else {
            par[v] = u;
            return true;
        }
    }

    public static void kruskal() {
        a.sort(Comparator.comparingDouble(o -> o.w));
        for (Edge i : a) {
            if (join(i.u, i.v)) {
                totalWeight += i.w;
                mst.add(i);
            }
        }
    }

    public static ArrayList<Edge> getMst() {
        return mst;
    }

    public static double getTotalWeight() {
        return totalWeight;
    }
}
