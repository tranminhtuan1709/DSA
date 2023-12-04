package Others;

public class BinaryHeap {
    public int[] a = new int[3005];
    public int[] posOnHeap = new int[3005];
    int n = 0;

    public void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public int swim(int k) {
        while (k > 1 && a[k / 2] > a[k]) {
            swap(k / 2, k);
            k /= 2;
        }
        return k;
    }

    public int sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j + 1 <= n && a[j] > a[j + 1]) {
                j += 1;
            }
            if (a[k] <= a[j]) {
                break;
            } else {
                swap(k, j);
                k = j;
            }
        }
        return k;
    }

    public void push(int x) {
        a[++n] = x;
        posOnHeap[x] = swim(n);
    }

    public int pop() {
        int res = a[1];
        posOnHeap[res] = -1;
        swap(1, n--);
        sink(1);
        return res;
    }

    public void decrease(int k, int x) {
        a[k] = x;
        posOnHeap[x] = swim(k);
    }

    public void increase(int k, int x) {
        a[k] = x;
        posOnHeap[x] = sink(k);
    }
}
