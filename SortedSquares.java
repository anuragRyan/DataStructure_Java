public class SortedSquares {
    private static int[] sortedSquares(int[] a) {
        int n = a.length;
        int i = 0;
        int j = n - 1;
        int[] result = new int[n];
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(a[i]) > Math.abs(a[j])) {
                result[k] = a[i] * a[i];
                i++;
            } else {
                result[k] = a[j] * a[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = { -11, -5, -1, 0, 3, 7, 10 };
        int[] r = sortedSquares(array);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }

}
