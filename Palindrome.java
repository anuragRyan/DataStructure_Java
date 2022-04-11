public class Palindrome {

    private boolean palindrome(int x){
        int rev =0;
        int temp = x;
        while(x>0){
            rev = (rev*10) + x%10;
            x = x/10;
        }
        return (rev ==temp);
    }
    public static void main(String[] args) {
        Palindrome pa = new Palindrome();
        System.out.println(pa.palindrome(121));
    }
}
