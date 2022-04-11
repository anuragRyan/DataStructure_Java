public class PossibleSubString {
    private static void subString(String str, int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                System.out.print(str.substring(i, j) + " ");
            }
        }
    }

    private static void withoutSubstringFunc(char[] str, int n){
        for(int len =1; len<=n;len++){
            for(int i=0;i<=n-len; i++){
                int j = i+len-1;
                for(int k=i;k<=j;k++){
                    System.out.print(str[k]);
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        char[] s = str.toCharArray();
        //subString(str, str.length());
        withoutSubstringFunc(s, str.length());
    }
}
