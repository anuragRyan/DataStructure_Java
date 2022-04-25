public class RainWater {

    public static int rainWater(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], a[i]);
        }
        right[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], a[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (Math.min(left[i], right[i]) - a[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 4, 2, 0, 3, 2, 5 };
        System.out.println(rainWater(a));
    }

}
