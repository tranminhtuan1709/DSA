package Graph;

import java.util.ArrayList;

public class ConnectedComponent_UnionFind {
    static class Edge {
        int u;
        int v;
    }
    public static int n;
    public static int m;
    public static ArrayList<Edge> edges;
    public static int[] cc;
    public static int count = 0;

    public void run() {
        for (Edge i : edges) {
            UnionFind.join(i.u, i.v);
        }
        for (int i = 1; i <= n; i++) {
            UnionFind.find(i);
        }
        for (int i = 1; i <= n; i++) {
            cc[UnionFind.par[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cc[i] != 0) {
                count++;
            }
        }
    }
}

/*

Complexity:
Need an E step to traverse all edges and in each step
need an logV step to join two vertices => O(ElogV)

*/