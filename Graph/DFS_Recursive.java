package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS_Recursive {
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> a;
    public static int[] par;
    public static int[] d;
    public static boolean[] visited;

    public static void init() {
        Arrays.fill(par, -1);
        Arrays.fill(d, 0);
        Arrays.fill(visited, false);
    }

    public static void dfs(int u) {
        visited[u] = true;
        for (int v : a.get(u)) {
            if (!visited[v]) {
                par[v] = u;
                d[v] = d[u] + 1;
                dfs(v);
            }
        }
    }
}

/*

    Complexity:
Complexity of DFS depends on the input data:
+ Adjacency matrix: algorithm traverses all vertices -> O(V),
                    in each vertices, need a V step to traverse v adjacent to u
                    => O(V^2)
+ Edge list       : number of steps call recursive is V,
                    in each step, for E vertices to find v adjacent to u
                    => O(E.V)
+ Adjacency list  : there is a maximum of V step to traverse all vertices
                    and E step to traverse all edges
                    => O(E + V)

*/