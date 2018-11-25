package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 25/2/18.
 */
/*
Can learn from the ideas in the I problem, to build 2D state transition equations.+

In 2D search increasing continuous subsequence, can consider dual circulation plus a recursive search directly seek to (x, y)ending the longest sequence.
Using memory search can be optimized.
When to use memory search?
State transition is particularly troublesome, not sequential.
Initialization is not easy to find.
Dynamic programming solves four elements:
status

dp[x][y]: x, yThe longest sub-sequence to end with
equation

Traverse x, yup and down about the four directions of the grid
dp[x][y] = dp[nx][ny] + 1 if A[x][y] > A[nx][ny]
initialization

dp[x][y]When it is a minimum, it is initialized to 1
answer

d[x][y]In the maximum
 */

// think like max math ending at x,y not starting
    // there are two ways to think dp problem
    // path ending at taht position
    // path starting at that position
    // so better sort out this deal
    // can be solved from both ways ..
    // it is kindda similar to top down bottom up approach !!!
public class LongestIncreasingPathInMatrixBetterDIfferenentConcept {
    int[][] dp;
    int[][] flag;
    int M, N;

    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, -1, 0, 1};
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        M = A.length;
        N = A[0].length;
        dp = new int[M][N];
        flag = new int[M][N];

        int ans = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = search(i, j, A);
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    // Memorized search, recursive
    public int search(int x, int y, int[][] A) {
        if (flag[x][y] != 0) {
            return dp[x][y];
        }

        int ans = 1; // Initialize dp[x][y] = 1 if it's local min compare to 4 directions
        int nx, ny;
        for (int i = 0; i < dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (insideBoundary(nx, ny) && (A[x][y] > A[nx][ny])) {
                ans = Math.max(ans, search(nx, ny, A) + 1);
            }
        }

        flag[x][y] = 1;
        dp[x][y] = ans;

        return ans;
    }

    public boolean insideBoundary(int x, int y) {
        return (x >=0 && x < M && y >= 0 && y < N);
    }
}

