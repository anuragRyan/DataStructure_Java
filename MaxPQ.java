
public class MaxPQ {
    private int[] heap;
    int n;

    private MaxPQ(int capacity) {
        heap = new int[capacity + 1];
        n = 0;
    }

    private boolean isEmpty() {
        return n == 0;
    }

    private int size() {
        return n;
    }

    private void insert(int x) {
        if (n == heap.length - 1) {
            resize(2 * heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }

    private void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private void swim(int n) {
        int k = n;
        while (k > 1 && heap[k / 2] < heap[k]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private int deletemax() {
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        if (n > 0 && (n == (heap.length - 1) / 4)) {
            resize(heap.length / 2);
        }
        return max;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[k] >= heap[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(3);
        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);

        for (int i = 1; i <= pq.n; i++) {
            System.out.print(pq.heap[i] + " ");
        }
    }

}
