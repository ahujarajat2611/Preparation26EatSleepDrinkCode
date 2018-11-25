package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int max = 0;
        for(int i=0;i<s.length()-1;i++){
            max = Math.max(max,expand(i,i,s));
            max = Math.max(max,expand(i,i+1,s));
        }
        String suffix =  s.substring(max) ;
        StringBuilder sb = new StringBuilder(suffix);
        String ans = sb.reverse().toString() + s.substring(0,max) + suffix;
        return ans;
    }

    private int expand(int i, int j, String s) {
        int localmax = j-i+1;
        while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            localmax = j-i+1;
            i--;
            j++;
        }
        if(i == -1){
            return localmax;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        System.out.println(shortestPalindrome.shortestPalindrome("aacecaaa"));
    }
}