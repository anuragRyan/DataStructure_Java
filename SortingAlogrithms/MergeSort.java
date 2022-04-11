package SortingAlogrithms;

public class MergeSort {
    private static void sort(int[] a, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(a, l, mid);
            sort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] b = new int[a.length];
        int k = l;
        while (i <= mid && j <= r && k < r) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= r) {
                b[k] = a[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                b[k] = a[i];
                k++;
                i++;
            }
        }

        for (k = l; k <= r; k++) {
            a[k] = b[k];
        }
    }

    private static void printarray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 15, 2, 6, 10, 3, 12, 4, 5, 118 };
        int n = a.length;
        int l = 0;
        int r = n - 1;
        sort(a, l, r);
        printarray(a);
    }

}
