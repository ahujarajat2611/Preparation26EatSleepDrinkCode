package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
public class BackPack2 {
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || V == null || A.length == 0 || V.length == 0 || A.length != V.length || m <= 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][m + 1];
        dp[0][0] = 0; // 0 item, to make pack size = 0, of course value = 0.

        // dp(i)(j) i for element make sure you take element as i-1 since staritng from 1
        // j is sum ....
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[A.length][m];
    }
    /*
	To use just O(m) sapce.
	Just like in Backpack I, at the end, we only care about the last row.
    Why not just maintain a row, always keep the max value.

	Note: Only update dp[j] if adding A[i-1] would be greater than current dp[j]

	It's a bit hard to come up with this... but it's good exercise.
*/
    public int backPackIIAgain(int m, int[] A, int V[]) {
        if (A == null || V == null || A.length == 0 || V.length == 0 || A.length != V.length || m <= 0) {
            return 0;
        }
        int[]dp = new int[m + 1];
        dp[0] = 0; // 0 item, to make pack size = 0, of course value = 0.

        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i - 1] >= 0 && dp[j - A[i - 1]] + V[i - 1] > dp[j]) {
                    dp[j] = dp[j - A[i - 1]] + V[i - 1];
                }
            }
        }

        return dp[m];
    }
}
