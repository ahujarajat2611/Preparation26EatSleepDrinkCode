package BasicAlgorithms.Dp;

/*
 *  Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3. 
 */
public class distinctSubSequence {
    //if s.charAt(i) == t.charAt(j), dp[i][j] = dp[i-1][j-1] + dp[i-1][j] 该字符作为T成员+不作为成员次数
    //else dp[i][j] = dp[i-1][j]
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return 0;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                } else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    
    public int numDistinct2(String s, String t) {
    	if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return 0;
    	int[] dp = new int[t.length()+1];
    	dp[0] = 1;
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = t.length()-1; j >= 0; j--) {
    			dp[j+1] = (s.charAt(i) == s.charAt(j) ? dp[j] : 0) + dp[j+1];
    		}
    	}
    	return dp[t.length()];
    }
}
