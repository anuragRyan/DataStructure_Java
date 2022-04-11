import java.util.Arrays;

public class BinarySearch {

    private static int binarySearch(int[] a, int key){
        int low =0;
        int high = a.length -1;
        while(low<=high){
            int mid = (low + high) / 2;
            if(a[mid] == key) return mid;
            if(a[mid] < key){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a= {3,5,1,8,4};
        Arrays.sort(a);
        System.out.println(binarySearch(a, 4));
    }
    
}
