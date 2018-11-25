package BasicAlgorithms.Dp;

import java.util.Arrays;

/**
 * Created by hadoop on 3/2/18.
 */
public class LongestIncreasingInMatrix {
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        boolean[][] flag = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag[i][j] = true;
                dp[i][j] = dfs(A, dp, flag, i, j, n, m);
                flag[i][j] = false;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public int dfs(int[][] A, int[][] dp, boolean[][] flag, int i, int j, int n, int m) {
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 1;
        int[] dx = {0,  0, 1, -1};
        int[] dy = {1, -1, 0,  0};
        //Go 4 directions
        for (int k = 0; k < dx.length; k++) {
            int id = i + dx[k];
            int jd = j + dy[k];
            if (id >= 0 && id < n && jd >= 0 && jd < m && A[i][j] < A[id][jd] && flag[id][jd] == false) {
                flag[id][jd] = true;
                ans = Math.max(ans, dfs(A, dp, flag, id, jd, n, m) + 1);
                flag[id][jd] = false;
            }
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
