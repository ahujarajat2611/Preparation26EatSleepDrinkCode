package BasicAlgorithms.String;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by hadoop on 14/10/17.
 */
public class ScrambleString {
    // You can crete DP array as asll of dp[String][String] = boolean to keep
    // track and not calculate the same thing again and again !!!!
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char a:s1.toCharArray()){
            if(!hashMap.containsKey(a)){
                hashMap.put(a,1);
            }
            else {
                hashMap.put(a,hashMap.get(a)+1);
            }
        }

        for(char b:s2.toCharArray()){
            if(!hashMap.containsKey(b)){
                return false;
            }
            int freq = hashMap.get(b);
            freq = freq-1;
            if(freq ==0){
                hashMap.remove(b);
            }
            else {
                hashMap.put(b,freq);
            }
        }
        System.out.println(hashMap);
        if(hashMap.keySet().size()!=0){
            System.out.println(hashMap.keySet().size());
            return false;
        }
        String reverse = new StringBuilder(s2).reverse().toString();
        for(int i=1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))){
                return true;
            }
            if(isScramble(s1.substring(0,i),reverse.substring(0,i)) && isScramble(s1.substring(i),reverse.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("dbdac","abcdd"));
    }

    private class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1 == null || s2 == null){
                return false;
            }
            int l = s1.length();
            boolean[][][] dp = new boolean[l][l][l + 1];
            boolean[][][] filled = new boolean[l][l][l + 1];
            for (int i = 0; i < l; i++){
                for (int j = 0; j < l; j++){
                    dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                    filled[i][j][1] = true;
                }
            }
            return helper(0, 0, l, dp, filled);
        }

        public boolean helper(int s1pos, int s2pos, int len, boolean[][][] dp, boolean[][][] filled){

            if (filled[s1pos][s2pos][len]){
                return dp[s1pos][s2pos][len];
            }
            boolean isScramble = false;
            for (int i = 1; i <= len - 1; i++){
                boolean leftLeft = helper(s1pos, s2pos, i, dp, filled);
                boolean rightRight = helper(s1pos + i, s2pos + i, len - i, dp, filled);
                boolean leftRight = helper(s1pos, s2pos + len - i, i, dp, filled);
                boolean rightLeft = helper(s1pos + i, s2pos, len - i, dp, filled);
                isScramble = isScramble || (leftLeft && rightRight) || (leftRight && rightLeft);
                if (isScramble){
                    dp[s1pos][s2pos][len] = true;
                    break;
                }
            }
            filled[s1pos][s2pos][len] = true;
            return dp[s1pos][s2pos][len];
        }
    }

}