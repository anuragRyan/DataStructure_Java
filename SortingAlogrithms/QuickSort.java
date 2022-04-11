package SortingAlogrithms;

public class QuickSort {

    private static int partitioning(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        int j = low;
        while (i <= high) {
            if (a[i] <= pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1;
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partitioning(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    private void printarray(int[] a) {
        System.out.print("QuickSort: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = { 2, 6, 10, 3, 12, 4, 5 };
        int n = a.length;

        quickSort.quickSort(a, 0, n - 1);
        quickSort.printarray(a);

    }

}
