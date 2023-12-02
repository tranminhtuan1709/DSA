package BT13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Edge {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class DSU {
    public int[] par = new int[3005];

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public int find(int u) {
        if (u != par[u]) {
            par[u] = find(par[u]);
            return par[u];
        } else {
            return u;
        }
    }

    public boolean join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return false;
        } else {
            par[v] = u;
            return true;
        }
    }
}

public class Exercise4 {
    public static int kruskal(ArrayList<Edge> a, int n) {
        int totalWeight = 0;
        DSU dsu = new DSU();
        dsu.init(n);
        a.sort(Comparator.comparingInt(o -> o.w));
        for (Edge i : a) {
            if (dsu.join(i.u, i.v)) {
                totalWeight += i.w;
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge> input = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            input.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        System.out.println(kruskal(input, n));
        sc.close();
    }
}
