package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class PredictTheWinner {
    private int helper(int[] nums, int start, int end) {
        // simpel contion
        if (start > end) {
            return 0;
        }
        //
        int leftpicked = nums[start] + Math.min(helper(nums, start + 2, end),
                helper(nums, start + 1, end - 1));
        // this math.min(publish+1,end-1),publish+2,end) amount left by my opponent
        // since he is also very smart
        int rightpicked = nums[end] + Math.min(helper(nums, start + 1, end - 1),
                helper(nums, start, end - 2));
        // i wil
        return Math.max(leftpicked, rightpicked);
    }

    public boolean PredictTheWinner(int[] nums) {
        if(nums == null ||nums.length ==0){
            return false;
        }
        int total =0;
        for(int num:nums){
            total = total + num;
        }
        // ansfirst /// ans calcul by first man
        // ans second will total -ansfirst
        // see which one is higher
        int ansfirst = helper(nums,0,nums.length-1);
        int anssecond = total-ansfirst;
        if(ansfirst>=anssecond){
            return true;
        }
        return false;
    }


    public boolean firstWillWinOne(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }

        int n = values.length;

        int[][] sum = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        boolean[][] flag = new boolean[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    sum[i][j] = values[j];
                } else {
                    sum[i][j] = sum[i][j - 1] + values[j];
                }
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += values[i];
        }

        return (total / 2) < search(0, n - 1, dp, flag, values, sum);
    }

    public int search(int i, int j, int[][] dp, boolean[][] flag, int[] values, int[][] sum) {
        if (flag[i][j]) {
            return dp[i][j];
        }

        flag[i][j] = true;

        if (i == j) {
            dp[i][j] = values[i];
        } else if (i > j) {
            dp[i][j] = 0;
        } else if (i + 1 == j) {
            dp[i][j] = Math.max(values[i], values[j]);
        } else {
            dp[i][j] = sum[i][j] - Math.min(search(i, j - 1, dp, flag, values, sum), search(i + 1, j, dp, flag, values, sum));
        }

        return dp[i][j];
    }
    /*
    public boolean PredictTheWinner(int[] nums) {

        if (nums == null || nums.length < 1) {
            return false;
        }

        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int firstPlayerSum = helper(nums, 0, nums.length - 1);
        int secondPlayerSum = totalSum - firstPlayerSum;

        return firstPlayerSum >= secondPlayerSum;
    }

    private int helper(int[] nums, int publish, int end) {

        if (publish > end) {
            return 0;
        }

        int first = nums[publish] + Math.min(helper(nums, publish + 2, end), helper(nums, publish + 1, end - 1));
        int last = nums[end] + Math.min(helper(nums, publish + 1, end - 1), helper(nums, publish, end - 2));

        return Math.max(first, last);
    }
     */

    /*
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        boolean[][] tag = new boolean[nums.length][nums.length];
        return getRes(nums, 0, nums.length - 1, dp, tag) >= 0;
    }

    private int getRes(int[] nums, int l, int r, int[][] dp, boolean[][] tag) {
        if (l == r) {
            return nums[l];
        }
        if (tag[l][r]) {
            return dp[l][r];
        }
        tag[l][r] = true;
        dp[l][r] = Math.max(nums[l] - getRes(nums, l + 1, r, dp, tag), nums[r] - getRes(nums, l, r - 1,dp, tag));
        return dp[l][r];
    }
     */
    /*
    public boolean PredictTheWinner(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) { dp[i][i] = nums[i]; }
    for (int len = 1; len < n; len++) {
        for (int i = 0; i < n - len; i++) {
            int j = i + len;
            dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        }
    }
    return dp[0][n - 1] >= 0;
}
     */
}