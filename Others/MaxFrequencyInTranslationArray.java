import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxFrequencyInTranslationArray {
    public static ArrayList<Integer> solution(int[] a, int m) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] f = new int[100005];
        for (int i = 0; i < a.length; i++) {
            if (i >= m) {
                f[a[i - m]]--;
            }
            f[a[i]]++;
            while (!dq.isEmpty() && f[a[i]] >= f[a[dq.peekLast()]]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= m - 1) {
                res.add(a[dq.peekFirst()]);
            }
        }
        return res;
    }
}
