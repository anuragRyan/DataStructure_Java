public class IsPrime {
    private static boolean isPrime(int n){
        if(n<=1)
            return false;

        for(int i=2; i<n; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 13;
        if(isPrime(n))
            System.out.println("It is a prime number");
        else 
            System.out.println("It is NOT a prime number");
    }
    
}
