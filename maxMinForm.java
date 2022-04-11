//Rearrange the sorted array in max/min form using O(1) space complexity.
// Input: [1, 4, 6, 8, 11, 13]
// Output: [13, 1, 11, 4, 8, 6]

public class maxMinForm {

    private static void arrangeMaxMin(int[] array) {
        int maxIdx = array.length - 1;
        int minIdx = 0;
        int max = array[maxIdx] + 1;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = array[i] + (array[maxIdx] % max) * max;
                maxIdx--;
            } else {
                array[i] = array[i] + (array[minIdx] % max) * max;
                minIdx++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] / max;
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 4, 6, 8, 11, 13 };
        arrangeMaxMin(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
