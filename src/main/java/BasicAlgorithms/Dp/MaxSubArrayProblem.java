package BasicAlgorithms.Dp;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 24/2/18.
 */
public class MaxSubArrayProblem {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        return maxSumOfThreeSubarrays(nums, k, 3);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k, int n) {
        int[][] dp = new int[n + 1][nums.length + 1];
        int[][] index = new int[n + 1][nums.length + 1];
        int tot = 0;
        // prefix sum
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        System.out.println("sum prefix");
        ConsoleWriter.printArray(sum);

        for (int i = 1; i <= 3; i++) {
            for (int j = k ; j <= nums.length; j++) {
                int tmpMax = sum[j] - sum[j - k] + dp[i - 1][j - k];
                //dp[i][j] = Math.max(dp[i][j-1],Math.max(dp[i][j],sum[j] - sum[j - k] + dp[i - 1][j - k]));

                if (tmpMax > Math.max(dp[i][j],dp[i][j-1])) {
                    dp[i][j] = tmpMax;
                    index[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j-1];
                    index[i][j] = index[i][j-1];
                }
            }
            System.out.println("dp arr");
            ConsoleWriter.printArray(index);
          //  ConsoleWriter.printArray(dp);
        }

        int[] ret = new int[n];
        System.out.println("returned before "+ret.length);
        ConsoleWriter.printArray(ret);
        int prev = nums.length;
        for (int i = n; i > 0; i--) {
            ConsoleWriter.printArray(index[i]);
            System.out.println("prev "+prev);
            ret[i - 1] = index[i][prev];
            prev = ret[i - 1];
        }
        System.out.println("returned finally "+ret.length);
        ConsoleWriter.printArray(ret);

        return ret;
    }
    public static void main(String args[]){
        MaxSubArrayProblem obj = new MaxSubArrayProblem();
        int []ar = {1,2,1,2,6,7,5,1};
        int k =2;
        obj.maxSumOfThreeSubarrays(ar,2);
       // obj.maxSumOfThreeSubarraysOld(ar,2);
    }


    public int[] maxSumOfThreeSubarraysOld(int[] nums, int k) {
        return maxSumOfThreeSubarraysOld(nums, k, 3);
    }

    public int[] maxSumOfThreeSubarraysOld(int[] nums, int k, int n) {
        int[][] dp = new int[n + 1][nums.length + 1];
        int[][] index = new int[n + 1][nums.length + 1];
        int tot = 0;
        // prefix sum
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }

        for (int i = 1; i <= 1; i++) {
            for (int j = k - 1; j < nums.length; j++) {
                int tmpMax = sum[j + 1] - sum[j - k + 1] + dp[i - 1][j - k + 1];
                if (tmpMax > dp[i][j]) {
                    dp[i][j + 1] = tmpMax;
                    index[i][j + 1] = j - k + 1;
                } else {
                    dp[i][j + 1] = dp[i][j];
                    index[i][j + 1] = index[i][j];
                }
            }
            System.out.println("dp arr old");
            ConsoleWriter.printArray(dp);
        }

        int[] ret = new int[n];
        int prev = nums.length;
        for (int i = n; i > 0; i--) {
            ConsoleWriter.printArray(index[i]);
            System.out.println("prev "+prev);
            ret[i - 1] = index[i][prev];
            prev = ret[i - 1];
        }
        ConsoleWriter.printArray(ret);

        return ret;
    }
}
