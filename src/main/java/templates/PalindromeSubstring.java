package templates;

/**
 * Created by hadoop on 23/10/17.
 */
public class PalindromeSubstring {
    String res = "";
    int maxlength ;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;
        maxlength = 0;

        // THATS QUITE SIMPLE I I+1 IITERATE AND keep track of max size !!
        // see how you can do it !!!
        for(int i=0;i<s.length()-1;i++){
            // if adjacent words are equal then only we are going to
            // deal this way
            if(s.charAt(i) == s.charAt(i+1)){
                helper(s,i,i+1);
            }
            helper(s,i,i);
        }
        return res;
    }

    private void helper(String s, int i, int j) {
        while (i>=0 && j<s.length() ){
            if(s.charAt(i)!=s.charAt(j)) break;
            i--;
            j++;
        }
        if(j-i+1> maxlength){
            maxlength = j-i+1;
            res = s.substring(i,j+1);
        }
    }
}
