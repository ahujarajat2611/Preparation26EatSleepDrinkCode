package BasicAlgorithms.Dp;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 27/1/18.
 */
public class WildCardRegexFinally {
    public boolean isRegexMatch(String text, String pattern) {
        boolean[][] t = new boolean[text.length() + 1][pattern.length() + 1];
        t[0][0] = true;
        // (empty_text,a*),(empty_text,a*b*) => set to true
        for (int j = 1; j < t[0].length; j++) {
            if (pattern.charAt(j - 1) == '*') {
                t[0][j] = t[0][j - 2];
            }
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {

                if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    // scenario : t = x, p=xa*, res = true, value gets from left;( ignoring a and star) (x,x)
                    t[i][j] = t[i][j - 2];

                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
                        // scenario : t = xa, p=xa*, res = true, value doesn't get from left(xa,x); value gets from top (x,xa*)
                        // scenario : t = xaa, p=xa*, res = true, value doesn't get from left(xaa,x); value gets from top (xa,xa*)
                        t[i][j] = t[i][j] || t[i - 1][j];
                    }

                    /* t(i)(j) = assume p* not there
                        // may be chars are not maching

                        then t(i)(j) = t(i)(j-2)

                        // if chars are matching of i-1 and j-2 or j-2 is . ( means any characacter)
                        t(i)(j) = t(i-1)(j)


                         */


                }
            }
        }
        return t[t.length - 1][t[0].length - 1];
    }
    public boolean ismatchingagainbottomup(String s, String p){
        if(p==null || p.length() == 0){
            return s== null || s.length() ==0;
        }
        int rows = s.length();
        int cols = p.length();

        boolean dp [][] = new boolean[rows+1][cols+1];
        dp[0][0] = true;




        /// no need to remove extra ****
        // since i am consderinga ll options
        for(int j=1;j<=p.length();j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1];
            }
            else{
                dp[0][j] = false;
            }
        }

        for(int i=1;i<=s.length();i++){
            dp[i][0] = false;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1) !='*'){
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) =='?')
                        dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j-1]||dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    static Map<Pair, Boolean> cache = new HashMap<Pair, Boolean>();

    public boolean isMatch(String s, String p) {
        // Remove pattern which has multiple ***** in the pattern

        char[] pattern = p.toCharArray();
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }
        boolean returnvalue = isMatchHelper(s.toCharArray(), pattern, s.length() - 1, writeIndex-1);
        return returnvalue;
    }
    private static boolean isMatchHelper(char []s,char[] p,int sindex,int pindex){

        if(sindex == -1){
            for(int i=0;i<=pindex;i++){
                if(p[i] !='*'){
                    return false;
                }
            }
            return true;
        }
        if(cache.containsKey(new Pair<Integer,Integer>(sindex,pindex))){
            return cache.get(new Pair<Integer,Integer>(sindex,pindex));
        }

        if(sindex == -1 && pindex == -1){
            return true;
        }
        if(sindex == -1 && pindex !=-1){
            return false;
        }
        if(sindex != -1 && pindex == -1){
            return false;
        }

        if(s[sindex] == p[pindex]){
            Boolean value = isMatchHelper(s,p,sindex-1,pindex-1);
            cache.put(new Pair<Integer,Integer>(sindex,pindex),value);
            return value;
        }

        if(p[pindex] == '?'){
            Boolean value= isMatchHelper(s,p,sindex-1,pindex-1);
            cache.put(new Pair<Integer,Integer>(sindex,pindex),value);
            return value;
        }

        if(p[pindex] =='*'){
            Boolean value =  isMatchHelper(s,p,sindex,pindex-1) || isMatchHelper(s,p,sindex-1,pindex) || isMatchHelper(s,p,sindex-1,pindex-1);
            cache.put(new Pair<Integer,Integer>(sindex,pindex),value);
            return value;
        }

        cache.put(new Pair<Integer,Integer>(sindex,pindex),false);
        return false;
    }

}
