package BT13;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result2 {
    static class Cost {
        public int vertex, w;

        public Cost(int v, int w) {
            this.w = w;
            this.vertex = v;
        }
    }

    public static int totalWeight = 0;
    public static ArrayList<ArrayList<Cost>> a;
    public static PriorityQueue<Cost> q;
    public static int[] d = new int[3005];
    public static boolean[] visited = new boolean[3005];

    public static void init(int n, List<List<Integer>> edges) {
        a = new ArrayList<>();
        q = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }
        for (List<Integer> i : edges) {
            int u = i.get(0);
            int v = i.get(1);
            int w = i.get(2);
            a.get(u).add(new Cost(v, w));
            a.get(v).add(new Cost(u, w));
        }
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
        init(n, edges);
        d[start] = 0;
        q.add(new Cost(start, d[start]));
        while (!q.isEmpty()) {
            int u = q.peek().vertex;
            q.poll();
            if (!visited[u]) {
                visited[u] = true;
                totalWeight += d[u];
                for (Cost i : a.get(u)) {
                    int v = i.vertex;
                    int wuv = i.w;
                    if (d[v] > wuv) {
                        d[v] = wuv;
                        q.add(new Cost(v, d[v]));
                    }
                }
            }
        }
        return totalWeight;
    }
}

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result2.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

