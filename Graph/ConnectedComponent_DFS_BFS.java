package Graph;

public class ConnectedComponent_DFS_BFS {
    public static int n;
    public static int m;
    public static int count = 0;
    public static boolean[] visited;

    public static void run() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                BFS.bfs(i);
                count++;
            }
        }
    }
}

/*

Complexity:
+ For loop takes a V step
+ There is a maximum of V vertices and E edges that is traversed by BFS
(the total complexity for all numbers of callings BFS is just E + V)
=> O(V + E + V) ~ O(E + v)

*/