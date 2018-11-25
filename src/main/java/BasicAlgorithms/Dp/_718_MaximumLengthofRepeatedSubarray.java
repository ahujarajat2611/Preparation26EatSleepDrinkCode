package BasicAlgorithms.Dp;

public class _718_MaximumLengthofRepeatedSubarray {
	// nothing but longest common substring (not subsequence)
	// if not equal put zero simplyyyyy
    public int findLength(int[] A, int[] B) {
		int max = 0;
		int lenA = A.length;
		int lenB = B.length;
		int[][] dp = new int[lenA + 1][lenB + 1];
		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > max) {
						max = dp[i][j];
					}
				}
			}
		}
		return max;
	}
}