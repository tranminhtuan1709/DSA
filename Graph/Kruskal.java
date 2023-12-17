package Graph;

import java.util.ArrayList;
import java.util.Comparator;

public class Kruskal {
    static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static ArrayList<Edge> edges;
    public static int totalWeight = 0;

    public static void kruskal() {
        edges.sort(Comparator.comparingInt(o -> o.w));
        for (Edge i : edges) {
            if (UnionFind.join(i.u, i.v)) {
                totalWeight += i.w;
            }
        }
    }
}

/*

Complexity:
+ Sorts an edge list costs ElogE
+ Traverses all edges costs E, in each step traverse, join() costs logV => ElogV
=> O(ElogE + ElogV)

*/