package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
/*
Given a 2D binary matrix filled with 0's and 1's,
find the largest square containing all 1's and return its area.

Example
For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

Tags Expand
Dynamic Programming
*/

/*
	Thoughts: Seem that we need to check on right and bottom spots for 2x2 1's.
	If all size spots are clean, len++, square = newLen ^ 2.
	DP[i,j]: the longest square lengh that this matrix[i][j] reach.
	dp[i,j] = Math.min(dp[i][j+1], dp[i+1][j], dp[i+1][j+1])
	init:
	dp[n-1][0 ~ m-1] = matrix[n-1][0 ~ m-1] == 0 ? 0 : 1;
	dp[0 ~ n-1][m-1] = matrix[0 ~ n-1][m-1] == 0 ? 0 : 1;
	for from rigt-bottom conor.
	Maintain a max area
*/
public class MaxSquare {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] dp = new int[n][m];
            int maxLen = 0;

            for(int i=0;i<n;i++){
                if(matrix[i][0] =='1'){
                    maxLen = 1;

                    dp[i][0] = 1;
                }
            }
            for(int j=0;j<m;j++){
                if(matrix[0][j] == '1'){
                    maxLen = 1;

                    dp[0][j] = 1;
                }
            }
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    if(matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j-1]),dp[i-1][j-1]) +1;
                        maxLen = Math.max(maxLen,dp[i][j]);
                    }
                }
            }
            return maxLen*maxLen;
        }
}
