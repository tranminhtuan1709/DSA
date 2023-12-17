package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BFS {
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> a;
    public static Queue<Integer> queue;
    public static int[] par;
    public static int[] d;
    public static boolean[] visited;

    public static void init() {
        Arrays.fill(par, -1);
        Arrays.fill(d, 0);
        Arrays.fill(visited, false);
    }

    public static void bfs(int s) {
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : a.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    par[v] = u;
                    d[v] = d[u] + 1;
                    queue.add(v);
                }
            }
        }
    }
}

/*

Complexity:
+ There is a maximum of V step to poll
+ There is a maximum of E step of for loop to traverse all edge adjacent to u
=> O(E + V)

*/