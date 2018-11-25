package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 7/1/18.
 */


//    Coins in a Line 3
//        There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.
//        Could you please decide the first player will win or lose?
//        Have you met this question in a real interview?  Yes
//        Example
//        Given array A = [3,2,2], return true.
//        Given array A = [1,2,4], return true.
//        Given array A = [1,20,4], return false.
//        lintcode
//        Now the rules of the game can only take one at a time, but can be taken from the left or right. So that we can not use the current view of the coin from the point of view. Use two-dimensional array. dp [left] [right] represents the maximum value from the beginning of the left position to the right position of this coin can get the upper hand. Initialization, if the coin segment length is 1, then the upper hand to get the maximum value is the value of the coin, if the coin segment length is 2, then the upper hand can get the maximum is the larger of the two coins. When the length of the coin segment is greater than or equal to 3, we can use the state transition equation. With Coins in a Line 2, used divide and conquer. I am lazy, I am a forerunner, and I want to know what is the maximum value I get from the first coin to the right coin. I can take left or right. The corresponding remaining coin segment for my opponent is [left + 1, right] or [left, right - 1]. So I let the opponent report it to the two coin segments (Note: my opponent at the moment for the two coin segment is also the first hand to take) the maximum can be taken, I let it take the smaller one, so I was the largest It's The entire dynamic plan is from the length of 1 to the length of the entire coin section. The final output is the length of the entire coin when the first hand to take the maximum.
public class CoinsInDp {
    public boolean firstWillWin(int[] values) {
        int l = values.length;
        int[][] dp = new int[l][l];
        boolean[][] computed = new boolean[l][l];
        int[][] sum = new int[l][l];
        for (int i = 0; i < l; i++){
            for (int j = i; j < l; j++){
                if (i == j){
                    sum[i][j] = values[i];
                } else {
                    sum[i][j] = sum[i][j - 1] + values[j];
                }
            }
        }
        return memorySearch(0, l - 1, dp, computed, sum, values) > sum[0][l - 1] / 2;
    }

    public int memorySearch(int left, int right, int[][]dp, boolean[][] computed, int[][] sum, int[] values){
        if (computed[left][right]){
            return dp[left][right];
        }
        if (left > right){
            dp[left][right] = 0;
        } else if (left == right){
            dp[left][right] = values[left];
        } else if (left + 1 == right){
            dp[left][right] = Math.max(values[left], values[right]);
        } else {
            dp[left][right] = sum[left][right] - Math.min(memorySearch(left + 1, right, dp, computed, sum, values), memorySearch(left, right - 1, dp, computed, sum, values));
        }
        computed[left][right] = true;
        return dp[left][right];
    }
    public boolean firstWillWinOneSide(int[] values) {
        // write your code here
        int n = values.length;
        int []dp = new int[n + 1];
        boolean []flag =new boolean[n + 1];
        int []sum = new int[n+1];
        int allsum = values[n-1];
        sum[n-1] = values[n-1];
        for(int i = n-2; i >= 0; i--) {
            sum[i] += sum[i+1] + values[i];
            allsum += values[i];
        }
        return allsum/2 < MemorySearch(0, n, dp, flag, values, sum);
    }
    int MemorySearch(int i, int n, int []dp, boolean []flag, int []values, int []sum) {
        if(flag[i] == true)
            return dp[i];
        flag[i] = true;
        if(i == n)  {
            dp[n] = 0;
        } else if(i == n-1) {
            dp[i] = values[i];
        } else if(i == n-2) {
            dp[i] = values[i] + values[i + 1];
        } else {
            dp[i] = sum[i] -
                    Math.min(MemorySearch(i+1, n, dp, flag, values, sum) , MemorySearch(i+2, n, dp, flag, values, sum));
        }
        return dp[i];
    }
}