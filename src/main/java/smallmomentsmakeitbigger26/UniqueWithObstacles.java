package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class UniqueWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n =obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;
        // in paths vale questions mein
        // always dheko ki 1 kaha se aayega
        // like base case ka ans 1 hoga
        // kis base case ka answer 1 hoga that you need to figure
        // it out ...
        dp[0][0] = 1;
        /// usually such problems do not
        // go take +1 matrix gets difficult to deal with
        //

        for (int j = 1; j < n; j++){
            // previous state doe snt have blcoker and curren dont not have
            //blocker addd 1 to patjh
            if (dp[0][j - 1] != 0 && obstacleGrid[0][j] != 1)
                dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++){
            if (dp[i - 1][0] != 0 && obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                // if blcoker simple we need to put zero
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
