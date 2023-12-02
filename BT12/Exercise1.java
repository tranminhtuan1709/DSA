package BT12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise1 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] grid;
    public static boolean[][] visited;
    public static int count_connected(int u, int v, int n, int m) {
        int ans = 0;
        Queue<Pair> tmp = new LinkedList<>();
        tmp.add(new Pair(u, v));
        while (!tmp.isEmpty()) {
            int x = tmp.peek().x;
            int y = tmp.peek().y;
            tmp.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (x + i >= 0 && x + i < n && y + j >= 0 && y + j < m
                            && !visited[x + i][y + j] && grid[x + i][y + j] == 1) {
                        visited[x + i][y + j] = true;
                        ans++;
                        tmp.add(new Pair(x + i, y + j));
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j, n, m);
                if (max < cnt) {
                    max = cnt;
                }
            }
        }
        System.out.println(max);
    }
}