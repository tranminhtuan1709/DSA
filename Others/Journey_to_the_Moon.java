package Others;

import java.util.ArrayList;
import java.util.List;

public class Journey_to_the_Moon {
    static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static int[] par = new int[100005];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
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

    public static boolean join(int x, int y) {
        int u = find(x);
        int v = find(y);
        if (u == v) {
            return false;
        } else {
            par[v] = u;
            return true;
        }
    }

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        init();
        ArrayList<Edge> edges = new ArrayList<>();
        for (List<Integer> i : astronaut) {
            edges.add(new Edge(i.get(0), i.get(1)));
        }
        for (Edge i : edges) {
            join(i.u, i.v);
        }
        for (int i = 0; i < n; i++) {
            find(i);
        }
        int[] cc = new int[100005];
        for (int i = 0; i < n; i++) {
            cc[par[i]]++;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cc[i] != 0) {
                a.add(cc[i]);
            }
        }
        long res = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                res += (long) a.get(i) * (long) a.get(j);
            }
        }
        return res;
    }
}
