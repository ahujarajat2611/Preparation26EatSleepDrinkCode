package smallmomentsmakeitbigger26;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Arrays;

/**
 * Created by hadoop on 14/12/17.
 */
public class DynamicProgammingPractice {
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (A[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || m < 1) {
            return 0;
        }
        int n = A.length;
        //dp[i][j] 表示前i个物品是否能组合成体积和为j的背包
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j < A[i - 1]) {//假如体积和小于物品A[i - 1]则 这件物品有没有都不影响，取决于前i - 1件
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                }
            }
        }

        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                return i;
            }
        }
        return 0;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return DP(1, n, arr, dp);
    }

    public int DP(int i, int j, int[] nums, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], DP(i, x - 1, nums, dp) + nums[i - 1] * nums[x] * nums[j + 1] + DP(x + 1, j, nums, dp));
        }
        return dp[i][j];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    // if i can reach to false from any position means i can win


    public boolean firstWillWin(int n) {
        if (n == 0) {
            return false;
        }
        // write your code here
        if (n <= 2) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] == false || dp[i - 2] == false) {
                dp[i] = true;
            }
        }
        return dp[n];
    }

    public boolean firstWillWin(int[] values) {
        int len = values.length;
        if (len <= 2) {
            return true;
        }
        int[] dp = new int[values.length];
        dp[0] = values[0];
        dp[1] = values[1];

        for (int i = 2; i < values.length; i++) {
            dp[i] = Math.max(values[i] - dp[i - 1], values[i] + values[i - 1] - dp[i - 2]);
        }
        ConsoleWriter.printArray(dp);
        return dp[values.length - 1] > 0;
    }
    //WATTA SOLUTION KEEP IT UP
    public int firstWillWin(int[] values,int i) {
        if(i == values.length-1){
            return values[i];
        }
        if(i >= values.length){
            return 0;
        }

        int secondOption = 0;
        int firstOption = values[i] + Math.min(firstWillWin(values,i+2),firstWillWin(values,i+3));
        if(i+1<values.length) {
            secondOption = values[i] + values[i + 1] + Math.min(firstWillWin(values, i + 3), firstWillWin(values, i + 4));
        }
        return Math.max(firstOption,secondOption);
    }
    public int firstWillWin(int i,int j,int sum[][]) {
        if(i>j){
            return 0;
        }
       // int secondOption = 0;
        int firstOption = sum[i][j]-Math.min(firstWillWin(i+1,j,sum),firstWillWin(i + 2,j, sum));
        return firstOption;
       // return Math.max(firstOption,secondOption);
    }
//        public static void main(String args[]){
//        DynamicProgammingPractice dp = new DynamicProgammingPractice();
//        int []arr = {3,1,4,100,2,4};
//       // System.out.println(dp.firstWillWin(arr));
//        System.out.println( dp.firstWillWin(arr,0));
//        int []sum = new int[arr.length+1];
//        sum[0] = 0;
//        for(int i =1;i<=arr.length;i++){
//            sum[i] = arr[i-1]+sum[i-1];
//        }
//        int n = arr.length;
//            int[] dp1 = new int[n + 1];
//            boolean[] flag = new boolean[n + 1];
//          //  ConsoleWriter.printArray(sum);
//            //System.out.println(dp.search(n,n,dp1,flag,arr,sum));
//
//            int sum2d [][]= new int[arr.length][arr.length];
//            for(int i=0;i<arr.length;i++){
//                sum2d[i][i] = arr[i];
//            }
//            for(int i=0;i<sum2d.length;i++){
//                for(int j =i+1;j<sum2d.length;j++){
//                    sum2d[i][j] = sum2d[i][j-1]+arr[j];
//                }
//            }
//           // ConsoleWriter.printArray(sum2d);
//            System.out.println(dp.firstWillWin(0,arr.length-1,sum2d));
//    }

    public int search(int i, int n, int[] dp, boolean[] flag, int[] values, int[] sum) {
        if (flag[i] == true) {
            return dp[i];
        }

        if (i == 0) {
            dp[i] = 0;
        } else if (i == 1) {
            dp[i] = values[n - 1];
        } else if (i == 2) {
            dp[i] = values[n - 1] + values[n - 2];
        } else {
            dp[i] = sum[i] - Math.min(search(i - 1, n, dp, flag, values, sum), search(i - 2, n, dp, flag, values, sum));
        }

        flag[i] = true;
        return dp[i];
    }


    public int copyBooks(int[] pages, int k) {

        int left = 0;
        int right = 999999;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if search is less than k then please decrease size further to see if its still working
            // think this way you put size to be max and that will be ans you have to reduce from max value
            // sum of all pages will have 1 partition
            // max value cna have
            if (search(mid, pages, k)) {
                // we want to have k paritiotn
                // if picked sum , we will have max 1 parition
                // if condition is false
                //
                right = mid;
            } else {
                // if we getting more parition then better you increase
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean search(int mid, int[] pages, int k) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < pages.length; i++) {
            if (sum + pages[i] > mid) {
                sum = pages[i];
                count++;
                if (count > k) {
                    return false;
                }
            } else {
                sum = sum + pages[i];
            }
        }
        return true;
    }

    public int copyBooksAgain(int[] pages, int k) {

        int dp[][] = new int[k + 1][pages.length];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < pages.length; i++) {
            sum = sum + pages[i];
            dp[1][i] = sum;
            max = Math.max(max, pages[i]);
        }

        if (k >= pages.length) {
            return max;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = pages.length - 1; j >= i - 1; j--) {
                int localsum = 0;
                for (int l = j; l >= i - 1; l--) {
                    System.out.println("local" + localsum);
                    localsum = localsum + pages[l];
                    dp[i][j] = Math.min(Math.max(dp[i - 1][l - 1], localsum), dp[i][j]);
                }
            }
        }
        return dp[k][pages.length - 1];
    }
// this will not worrk since there is operalap if you start from
    // starting points so not a good choice
    // start from end keep adding sum
    public int copyBooksAgainMine(int[] pages, int k) {

        int dp[][] = new int[k + 1][pages.length];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < pages.length; i++) {
            sum = sum + pages[i];
            dp[1][i] = sum;
            max = Math.max(max, pages[i]);
        }

        if (k >= pages.length) {
            return max;
        }

        // HOW MANY STARTNING POINTS
        for (int i = 2; i <= k; i++) {
            // THESE ARE POSSIBLE STARTING POINTS
            for(int partition = i-1;partition<pages.length;partition++){
                int localsum = 0;
                // OPTINGS FROM THOSE STARTING POINTS
                for(int p = partition;p<pages.length;p++){
                    localsum = localsum + pages[p];
                    dp[i][partition] = Math.min(Math.max(dp[i-1][p-1],localsum),dp[i][partition]);
                }
            }
//            for (int j = pages.length - 1; j >= i - 1; j--) {
//                int localsum = 0;
//                for (int l = j; l >= i - 1; l--) {
//                    System.out.println("local" + localsum);
//                    localsum = localsum + pages[l];
//                    dp[i][j] = Math.min(Math.max(dp[i - 1][l - 1], localsum), dp[i][j]);
//                }
//            }
        }
        return dp[k][pages.length - 1];
    }

    public static void main(String[] args) {
        DynamicProgammingPractice dp = new DynamicProgammingPractice();
        System.out.println(dp.copyBooksAgain(new int[]{3, 2, 4,4,1}, 2));
        System.out.println(dp.copyBooksAgainMine(new int[]{3, 2, 4,4,1}, 2));

        //  int [][]ans = new int[1][1];
       // ans[0][0] =100;
        ///System.out.println(dp.calculateMinimumHP(ans));
    }

    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
            return 0;
        }
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++)//T is empty
            dp[i][0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {//means this character can be retained or drop
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];//so the convert amount equals retain the character plus do not retain this character.
                } else {
                    dp[i][j] = dp[i - 1][j];//no matter the char i and char j equals or not, at least has dp[i - 1][j]
                }

                // dp[i][j] = dp[i - 1][j];  简化版本
                // if (s.charAt(i - 1) == t.charAt(j - 1)) {
                //     dp[i][j] += dp[i - 1][j - 1];
                // }
            }
        }

        return dp[S.length()][T.length()];
    }

        public int calculateMinimumHP(int[][] dungeon) {

            int [][]dp = new int[dungeon.length+1][dungeon[0].length+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
            for(int i=dungeon.length-1;i>=0;i--){
                for(int j=dungeon[0].length-1;j>=0;j--){
                    // so fuckingh good this soolution is
                    // copy last value
                    if(i ==dungeon.length-1 && j ==dungeon[0].length-1){
                        dp[i][j] = dungeon[i][j];
                    }
                    // better you break into xaxis and y axis to keep things simple to understand
                    else {
                        dp[i][j] = dungeon[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }


                    // THE MOST IMP STEP
                    // IF ANY POINT OF TIME THIS VALUE IS MORE THAN ZERO MAKE IT ZERO
                    // SO THAT MAX FUNCTION ALWAYS DEAL WITH NEGATIVE VALUESS OR ZERO
                    if(dp[i][j]>0){
                        dp[i][j] = 0;
                    }
                }
            }
            return dp[0][0]>=0 ? 1 : -1*dp[0][0] +1;
        }
}