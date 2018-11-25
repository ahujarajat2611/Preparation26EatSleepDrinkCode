package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class MinSizeSubarraySum{
        public int minimumSize(int[] nums, int s) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int min = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;
            int sum = 0;

            while (end < nums.length) {
                while (end < nums.length && sum < s) {
                    sum += nums[end];
                    end++;
                }
                while (sum >= s) {
                    min = Math.min(min, end - start);
                    sum -= nums[start];
                    start++;
                }
            }
            return (min == Integer.MAX_VALUE) ? -1 : min;
        }
}
