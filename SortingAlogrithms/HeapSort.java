package SortingAlogrithms;

public class HeapSort {
    private static void heapSort(int[] a, int n) {
        // buildheap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapify(a, i - 1, 0);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i;
        int r = 2 * i + 1;

        if (l < n && a[l] > a[largest])
            largest = l;

        if (r < n && a[r] > a[largest])
            largest = r;

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest);
        }

    }

    public static void main(String[] args) {
        int[] a = { 1, 13, 4, 67, 34, 8, 28 };

        heapSort(a, a.length);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
