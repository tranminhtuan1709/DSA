package Others;

public class Heap_Sort {
    int length = 0;
    int[] heap = new int[100005];

    void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    int sink(int k) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j + 1 <= length && heap[j + 1] < heap[j]) {
                j += 1;
            }
            if (heap[k] <= heap[j]) {
                break;
            } else {
                swap(k, j);
                k = j;
            }
        }
        return k;
    }

    int swim(int k) {
        while (k > 1 && heap[k] < heap[k / 2]) {
            swap(k, k / 2);
            k /= 2;
        }
        return k;
    }

    void push(int x) {
        heap[++length] = x;
        swim(length);
    }

    int pop() {
        int res = heap[1];
        swap(1, length--);
        sink(1);
        return res;
    }

    void buildHeap(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            push(arr[i]);
        }
    }

    void heapify(int[] arr, int n, int i) {

    }

    public void heapSort(int[] arr, int n) {
        buildHeap(arr, n);
        int i = 0;
        while (length > 0) {
            arr[i++] = pop();
        }
    }
}
