package BasicAlgorithms.Dp;

import BasicAlgorithms.utils.ConsoleWriter;

/*
Given a string s, cut s into some substrings such that every substring is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
Example
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
        	return 0;
        boolean[][] dict = new boolean[s.length()][s.length()];
        dict = getDictPalindromeIndex(s);
        ConsoleWriter.printIntArray(dict);
        dict = getDict(s);
        ConsoleWriter.printIntArray(dict);
        int[] dp = new int[s.length()+1];
        dp[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            dp[i+1] = i+1;
            for (int j = 0; j <= i; j++) {
                if (dict[j][i] == true) {
                    dp[i+1] = Math.min(dp[j]+1,dp[i+1]);
                }
            }
        }
        return dp[s.length()];
	}
	private boolean[][] getDict(String s) {
	    boolean[][] dict = new boolean[s.length()][s.length()];
	    for (int i = 0; i < s.length(); i++) {
	        for (int j = i; j >= 0; j--) {
	            if ((i - j < 2 || dict[j+1][i-1]) && s.charAt(i) == s.charAt(j)) {
	                dict[j][i] = true;
	            } 
	        }
	    }
	    return dict;
	}
    private boolean[][] getDictPalindromeIndex(String s) {
        boolean[][] dict = new boolean[s.length()][s.length()];
        for(int i =0;i<s.length();i++){
            dict[i][i] = true;
        }
        for(int d = 2;d<=s.length();d++){
            for(int i=0;i<s.length()-d+1;i++){
                int j = i+d-1;
                if(d == 2){
                    dict[i][j] = s.charAt(i) == s.charAt(j);
                    continue;
                }
                if(dict[i+1][j-1] == true && s.charAt(i) == s.charAt(j)){
                    dict[i][j] = true;
                }
                else {
                    dict[i][j] = false;
                }
            }
        }
        return dict;
    }

    public static void main(String[] args) {
        PalindromePartitioningII palindromePartitioningII = new PalindromePartitioningII();
        System.out.println(palindromePartitioningII.minCut("aab"));
    }
}
