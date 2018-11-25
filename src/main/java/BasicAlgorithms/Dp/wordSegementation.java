package BasicAlgorithms.Dp;/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Example
Given

s = "lintcode",

dict = ["lint", "code"].

Return true because "lintcode" can be segmented as "lint code".
 */
import java.util.*;
public class wordSegementation {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
    	if (s == null || s.length() == 0)
            return true;
    	boolean[] dp = new boolean[s.length()+1];
    	dp[0] = true;
    	for (int i = 0; i < s.length(); i++) {
    	    StringBuilder sb = new StringBuilder(s.substring(0, i+1));
    		for (int j = 0; j <= i; j++) {
    			if (dict.contains(sb.toString()) && dp[j]) {
    				dp[i+1] = true;
    				break;
    			}
    			sb.deleteCharAt(0);
    		}
    	}
    	return dp[s.length()];
    }
}
