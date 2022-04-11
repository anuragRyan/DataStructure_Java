package SortingAlogrithms;

public class BubbleSort {
    private static void bubbleSort(int[] a) {
        int n = a.length;
        boolean isSwapped;
        for (int i = 0; i < n; i++) {
            isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 7, 3, 5, 9, 2 };
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
