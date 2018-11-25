package DSA.Dp;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 19/2/18.
 */
public class DungeonGAME {
    public int calculateMinimumHP(int[][] dungeon) {

        int [][]dp = new int[dungeon.length+1][dungeon[0].length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i=dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){
                if(i ==dungeon.length-1 && j ==dungeon[0].length-1){
                    dp[i][j] = dungeon[i][j];
                }
                else {
                    dp[i][j] = dungeon[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]);
                }

                if(dp[i][j]>0){
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0]>=0 ? 1 : -1*dp[0][0] +1;
    }
    public static int dungeonGame(int a[][]) {
        int m = a.length, n = a[0].length;
        int t[][] = new int[m][n];

        t[m - 1][n - 1] = Math.max(1 - a[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            t[i][n - 1] = Math.max(t[i + 1][n - 1] - a[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            t[m - 1][j] = Math.max(t[m - 1][j + 1] - a[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int ans = Math.min(t[i+1][j],t[i][j+1])-a[i][j] ;
                ans = Math.max(ans,1);
//                int down = Math.max(t[i + 1][j] - a[i][j], 1);
//                int right = Math.max(t[i][j + 1] - a[i][j], 1);
               // t[i][j] = Math.min(right, down);
                t[i][j] = ans;
            }
        }
    //    ConsoleWriter.printArray(t);
        return t[0][0];
    }

    /*
    for i in reversed(range(m)):
            for j in reversed(range(n)):
                if i == m - 1 and j == n - 1:
                    dp[i][j] = max(1, 1 - dungeon[i][j])
                elif i == m - 1:
                    dp[i][j] = max(1, dp[i][j + 1] - dungeon[i][j])
                elif j == n - 1:
                    dp[i][j] = max(1, dp[i + 1][j] - dungeon[i][j])
                else:
                    dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j])

        return dp[0][0]
     */
}
