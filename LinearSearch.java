public class LinearSearch {
    private static void linearSearch(int[] a, int target){
        for(int i=0; i<a.length;i++){
            if(a[i] == target){
                System.out.println("Target found");
            }
        }

    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        linearSearch(a, 5);
        
    }
    
}
