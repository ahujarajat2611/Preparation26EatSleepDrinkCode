package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class LongestIncreasingSequenceMatrix {
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
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


    public int longestIncreasingContinuousSubsequenceLeftRightDirectionDp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        int[] flag = new int[A.length];
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i] = dfs(A, dp, flag, i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int dfs(int[] A, int[] dp, int[] flag, int i){
        if (flag[i] == 1) {
            return dp[i];
        }
        int ansLeft = 1;
        int ansRight = 1;
        flag[i] = -1;
        //Increasing from left->right
        if (i - 1 >= 0 && A[i - 1] < A[i] && flag[i - 1] != -1) {
            ansLeft = dfs(A, dp, flag, i - 1) + 1;
        }
        //Increasing from right->left
        if (i + 1 < A.length && A[i] > A[i + 1] && flag[i + 1] != -1) {
            ansRight = dfs(A, dp, flag, i + 1) + 1;
        }
        flag[i] = 1;
        dp[i] = Math.max(ansLeft, ansRight);
        return dp[i];
    }

    public int longestIncreasingContinuousSubsequenceLeftRightDirection(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int leftRun = 1;
        int rightRun = 1;
        int ans = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                leftRun++;
            } else {
                leftRun = 1;
            }
            ans = Math.max(ans, leftRun);
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                rightRun++;
            } else {
                rightRun = 1;
            }
            ans = Math.max(ans, rightRun);
        }
        return ans;
    }
}
