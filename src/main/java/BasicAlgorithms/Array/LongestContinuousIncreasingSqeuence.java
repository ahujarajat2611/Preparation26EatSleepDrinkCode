package BasicAlgorithms.Array;

/**
 * Created by hadoop on 7/1/18.
 */
public class LongestContinuousIncreasingSqeuence {
    private class Solution {
        public int longestIncreasingContinuousSubsequenceII(int[][] A) {
            if (A == null || A.length == 0){
                return 0;
            }
            int rows = A.length;
            int cols = A[0].length;
            int[][] dp = new int[rows][cols];
            int ans = 1;
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    if (dp[i][j] == 0){
                        dp[i][j] = dfs(A, i, j, rows, cols, dp);
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }

        public int dfs(int[][] A, int i, int j, int rows, int cols, int[][] dp){
            if (dp[i][j] != 0){
                return dp[i][j];
            }
            int numLeft = 0;
            int numRight = 0;
            int numUp = 0;
            int numBottom = 0;
            if (j - 1 >= 0 && A[i][j - 1] > A[i][j]){
                numLeft = dfs(A, i, j - 1, rows, cols, dp);
            }
            if (j + 1 < cols && A[i][j + 1] > A[i][j]){
                numRight = dfs(A, i, j + 1, rows, cols, dp);
            }
            if (i - 1 >= 0 && A[i - 1][j] > A[i][j]){
                numUp = dfs(A, i - 1, j, rows, cols, dp);
            }
            if (i + 1 < rows && A[i + 1][j] > A[i][j]){
                numBottom = dfs(A, i + 1, j, rows, cols, dp);
            }
            dp[i][j] = Math.max(Math.max(numLeft, numRight), Math.max(numUp, numBottom)) + 1;
            return dp[i][j];
        }
    }
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int l = A.length;
        int ans = 1;
        int max = 1;
        // increasing
        for (int i = 1; i < l; i++){
            if (A[i] > A[i - 1]){
                max++;
                ans = Math.max(ans, max);
            } else {
                max = 1;
            }
        }
        max = 1;//重置
        // decreasing
        for (int j = l - 2; j >= 0; j--){
            if (A[j] > A[j + 1]){
                max++;
                ans = Math.max(ans, max);
            } else {
                max = 1;
            }
        }
        return ans;
    }
}
