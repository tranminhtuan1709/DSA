package BT13;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int vertex, distance;

    public Pair(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Pair o) {
        if (o.distance > this.distance) return -1;
        if (o.distance < this.distance) return 1;
        return Integer.compare(this.vertex, o.vertex);
    }
}

class Result3 {

    public static Queue<Integer> q;
    public static double[] d;
    public static boolean[] onQueue;
    //public static boolean[] check = new boolean[3005];

    public Result3(ArrayList<Pair>[] a, int s) {
        d = new double[a.length];
        onQueue = new boolean[a.length];
        Arrays.fill(d, Double.POSITIVE_INFINITY);
        q = new LinkedList<>();

        d[s] = 0;
        q.add(s);
        onQueue[s] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            onQueue[u] = false;
            //check[u] = true;
            for (Pair i : a[u]) {
                int v = i.vertex;
                int wuv = i.distance;
                if (d[v] > d[u] + wuv) {
                    d[v] = d[u] + wuv;
                    if (!onQueue[v]) {
                        q.add(v);
                        onQueue[v] = true;
                    }
                }
            }
        }
    }

    public void getD() {
        for (int i = 1; i < d.length; i++) {

            if (d[i] != 0) {
                if (d[i] == Double.POSITIVE_INFINITY) {
                    System.out.print("-1 ");
                } else System.out.print((int)d[i] + " ");
            }
        }
    }
}

public class Exercise3 {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            if (st == null || !st.hasMoreElements ()) {
                do {
                    try {
                        st = new StringTokenizer (br.readLine ());
                    } catch (IOException e) {
                        System.out.println(e.toString());
                    }
                } while (st == null || !st.hasMoreElements ());
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                System.out.println(e.toString());
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Pair>[] a = (ArrayList<Pair>[]) new ArrayList[n + 1];
            for (int v = 0; v <= n; v++) a[v] = new ArrayList<>();

            for (int j = 0; j < m; j++) {

                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                a[u].add(new Pair(v, w));
                a[v].add(new Pair(u, w));

            }
            int s = sc.nextInt();
            Result3 r = new Result3(a, s);

            r.getD();
            System.out.println();
        }
    }
}
