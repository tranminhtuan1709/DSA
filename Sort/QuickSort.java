package Sort;

public class QuickSort {
    public static int[] a;
    public static int n;

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (a[++i] < a[low]) {
                if (i == high) {
                    break;
                }
            }
            while (a[--j] > a[low]) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(low, j);
        return j;
    }

    public static void quickSort(int low, int high) {
        if (low >= high) {
            return;
        } else {
            int j = partition(low, high);
            quickSort(low, j - 1);
            quickSort(j + 1, high);
        }
    }
}

/*

Complexity:
+ Worst case => O(N^2) when input array is already sorted ascending,
  while (a[++i]) costs 0 and while (a[--j]) cost n - 1, and this case
  leads to j increasing step by step
+ Best case => O(NlogN) when every partition element j is at the middle of [low; high]

*/