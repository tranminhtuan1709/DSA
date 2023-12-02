package BT11;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;


class Result {

    public static int BinarySearch(List<Integer> a, int x, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a.get(m) == x) {
                return m;
            }
            else if (a.get(m) < x) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            if (BinarySearch(arr, arr.get(i) + k, i + 1, arr.size() - 1) != -1) {
                res++;
            }
            if (arr.get(i) >= k) {
                if (BinarySearch(arr, arr.get(i) - k, 0, i - 1) != -1) {
                    res++;
                }
            }
        }
        return res / 2;
    }

}

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
