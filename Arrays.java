public class Arrays{

    public static void reverseArray(int[] array, int start, int end){
        
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        for(int i=0; i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        
    }

    public static void moveZerosToEnd(int[] array){
        int j = 0;
        for(int i =0; i<array.length; i++){
            if(array[i] != 0 && array[j] == 0){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            if(array[j] != 0)
                j++;
        }
        for(int i=0; i<array.length;i++){
            System.out.print(array[i] + " ");
        };
    }

    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = word.length()-1;
        while(start < end){
            if(charArray[start] != charArray[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Arrays array = new Arrays();

        String word = "madam";
        if(array.isPalindrome(word)){
            System.out.println("It is palindrome.");
        } else{
            System.out.println("Not a palindrome");
        }
        
    }
}