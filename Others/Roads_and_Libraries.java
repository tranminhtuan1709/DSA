package Others;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
    public static int[] par = new int[100005];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }

    public static boolean join(int x, int y) {
        int u = find(par[x]);
        int v = find(par[y]);
        if (u == v) {
            return false;
        }
        par[v] = u;
        return true;
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        init();
        ArrayList<Edge> edge = new ArrayList<>();
        for (List<Integer> i : cities) {
            edge.add(new Edge(i.get(0), i.get(1)));
        }
        for (Edge i : edge) {
            join(i.u, i.v);
        }
        for (int i = 1; i <= n; i++) {
            find(i);
        }
        int[] cc = new int[100005];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            cc[par[i]]++;
        }
        int n_road = 0;
        for (int i = 1; i <= n; i++) {
            if (cc[i] != 0) {
                count++;
                n_road += cc[i] - 1;
            }
        }
        return Math.min((long) c_road * (long) n_road + (long) count * (long) c_lib, (long) n * (long) c_lib);
    }
}

public class Roads_and_Libraries {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
