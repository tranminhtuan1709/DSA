package Sort;

public class MergeSort {
    public static int[] a;
    public static int[] res;
    public static int n;

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void merge(int low, int mid, int high) {
        int i = low;
        int j = mid;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                res[k] = a[j++];
            } else if (j > high) {
                res[k] = a[i++];
            } else if (a[i] < a[j]) {
                res[k] = a[i++];
            } else {
                res[k] = a[j++];
            }
        }
    }

    public static void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        } else {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }
}

/*

Complexity:
There is a maximum of logN steps to divide the array in half,
in each step, we need N steps to merge left part and right part
=> O(NlogN) in every case

*/