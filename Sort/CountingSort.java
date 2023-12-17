package Sort;

public class CountingSort {
    public static int[] a;
    public static int[] frequency;
    public static int[] res;
    public static int n;
    public static int max;

    public static void countingSort() {
        for (int i = 1; i <= max; i++) {
            frequency[i] += frequency[i - 1];
        }
        for (int i = 0; i < n; i++) {
            res[frequency[a[i]] - 1] = a[i];
            frequency[a[i]]--;
        }
    }
}

/*

Complexity:
+ Best case => O(max + n)
+ Worst case => O(max + n)

*/
