package Tree;

public class Heap {
    public static int n = 0;
    public static int[] heap;

    public static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j + 1 <= n && heap[j + 1] < heap[j]) {
                j += 1;
            }
            if (heap[j] >= heap[k]) {
                break;
            } else {
                k = j;
            }
        }
    }

    public static void swim(int k) {
        while (k > 1 && heap[k] <= heap[k / 2]) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    public static void push(int x) {
        heap[++n] = x;
        swim(n);
    }

    public static int pop() {
        if (n == 0) {
            return -1;
        }
        int res = heap[1];
        swap(1, n);
        sink(1);
        n--;
        return res;
    }
}

/*

Complexity:
add() = swim() => O(logN)
pop() = sink() => O(logN)

*/