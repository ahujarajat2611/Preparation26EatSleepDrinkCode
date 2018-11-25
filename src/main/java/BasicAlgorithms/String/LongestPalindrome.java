package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestPalindrome {
    int max = 1;
    int low = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        for (int i=0;i<s.length();i++){
            extendPalindrome(s,i,i+1);
            extendPalindrome(s,i,i);
        }
        return s.substring(low,max+low);
    }

    private void extendPalindrome(String s, int i, int j) {
        int locallow = i;
        int locallength = 0;
        while (i>=0 && j<s.length()&& s.charAt(i) == s.charAt(j)){
            System.out.print(" "+s.charAt(i));
            System.out.print(" "+s.charAt(j));
            System.out.print(" "+i);
            System.out.print(" "+j);
            System.out.println();
            locallow = i;
            locallength = j-i+1;
            i--;
            j++;
        }

        if(max<locallength){
            System.out.println(i);
            System.out.println(j);
            max = locallength;
            low = locallow;
        }
    }

    public static void main(String[] args) {
        String a = "babad";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(a));
    }
}