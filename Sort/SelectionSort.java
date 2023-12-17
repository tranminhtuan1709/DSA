package Sort;

public class SelectionSort {
    public static int[] a;
    public static int n;

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectionSort() {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }
}

/*

Complexity:
+ Best case => O(N^2)
+ Worst case => O(N^2)

*/