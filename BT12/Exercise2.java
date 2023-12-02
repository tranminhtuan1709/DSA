package BT12;

import java.util.*;

public class Exercise2 {
    public static void BFS(ArrayList<ArrayList<Integer>> a, int s, int n) {
        int[] d = new int[1005];
        boolean[] visited = new boolean[1005];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);
        Arrays.fill(d, -1);
        d[s] = 0;
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : a.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    d[v] = d[u] + 1;
                    queue.add(v);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                System.out.print(-1 + " ");
            } else if (i != s) {
                System.out.print(d[i] * 6 + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> input = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                input.add(new ArrayList<>());
            }
            while (m-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                input.get(u).add(v);
                input.get(v).add(u);
            }
            int s = sc.nextInt();
            BFS(input, s, n);
        }
        sc.close();
    }
}
