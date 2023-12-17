package Graph;

public class UnionFind {
    public static int n;
    public static int[] par;

    public static void init() {
        for (int i = 0; i <= n; i++) {
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
}

/*

Complexity:
+ find() method has complexity of O(logN)

*/