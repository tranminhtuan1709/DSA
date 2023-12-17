package Sort;

public class InsertionSort {
    public static int[] a;
    public static int n;

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void insertionSort() {
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}

/*

Complexity:
+ Best case => O(1) when array is already sorted ascending
+ Worst case => O(N)
*/