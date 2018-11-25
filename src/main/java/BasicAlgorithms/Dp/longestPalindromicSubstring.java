package BasicAlgorithms.Dp;//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


public class longestPalindromicSubstring {
    //if s.charat(i) == s.charAt(j) : dp[i][j] = dp[i-1][j+1]
	public String longestPalindrome(String s) {		
        if (s == null || s.length() == 0)
        	return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int l = 0;
        int r = 0;
        for (int i = s.length()-1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(j) == s.charAt(i)) {
					if (j - i <= 2)
						dp[i][j] = true;
					else
						dp[i][j] = dp[i+1][j-1];
				}
				if (dp[i][j] == true && j - i + 1 > r - l + 1) {
					l = i;
					r = j;
				}
			}
		}    
        return s.substring(l, r+1);        
    }
}
