public class MatrixSearch {
    private int[] sortedMatrixSearch(int[][] matrix,int n, int target){
        int[] result = new int[2];
        int i =0;
        int j = n-1;
        while(i<n && j>=0){
            if (matrix[i][j] == target){
                result[0] = i;
                result[1] = j;
            }
            if(target < matrix[i][j]){
                j--;
            } else {
                i++;
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        MatrixSearch matrixSearch = new MatrixSearch();
        int[][] mat = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,49}
        };
        System.out.print(matrixSearch.sortedMatrixSearch(mat, 4, 37)[0]+ ","); 
        System.out.println(matrixSearch.sortedMatrixSearch(mat, 4, 37)[1]); 
        
    }
}
