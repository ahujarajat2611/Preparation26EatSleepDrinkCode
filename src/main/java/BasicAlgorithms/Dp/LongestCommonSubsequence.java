package BasicAlgorithms.Dp;

import java.util.*;

public class LongestCommonSubsequence {
    public static int LCS(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return 0;
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + 1;				
				} else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		printLCS(dp, s1);
		return dp[s1.length()][s2.length()];
	}
	public static void printLCS(int[][] dp, String s1) {
		int m = dp.length-1;
		int n = dp[0].length-1;
		LinkedList<Character> list = new LinkedList<Character>();
		while (n != 0 && m != 0) {
			if (dp[m][n] == dp[m-1][n-1] + 1) {
				list.add(0, s1.charAt(m-1));
				m--;
				n--;
			} else if (dp[m][n] == dp[m-1][n]) {
				m--;
			} else {
				n--;
			}
		}
		for (char c : list) {
			System.out.println(c);
		}
	}
	
	// 利用滚动数组，把空间复杂度降为(2*m);
	public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0)
            return 0;
        int[] dp = new int[B.length()+1];
        int[] rolling = new int[B.length()+1];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j))
                    dp[j+1] = rolling[j]+1;
                else
                    dp[j+1] = Math.max(dp[j+1], dp[j]);
            }
            for (int j = 1; j <= B.length(); j++) {
                rolling[j] = dp[j];
            }
        }
        return dp[B.length()];        
    }
	public static void main(String[] args) {
		String s1 = "abcdefggggoooooggggooooggggooooggggoooggggaewqewqewfkdfgrtrgfdgfswerewfdsabcdefghlmnqqqqqqqqppewqewqkewqirieorewiorewiroew";
		String s2 = "abcdefggggoooooggggooooggggooooggggoooggggmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmabcdefghlmnqqqqqqqqqnnnnnnnnnnnnnnnnnnn";
		System.out.println(LCS(s1, s2));	
		
	}
}
