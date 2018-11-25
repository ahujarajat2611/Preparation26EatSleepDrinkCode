package BasicAlgorithms.Array;

/**
 * Created by hadoop on 16/12/17.
 */
public class SubArraysProblem {
    public static int minsize(int s, int []nums){
        int minlength = Integer.MAX_VALUE;
        int right=0;
        int left=0;
        int sum = 0;

        while (right<nums.length){
            sum = sum + nums[right];
            while (sum>=s){
                sum = sum-nums[left];
                minlength = Math.min(minlength,right-left+1);
                left = left+1;
            }
            right++;
        }
        return minlength;
    }

    public void subArraysOfSum(int[] a, int k) {

        int sum = 0;
        int l = 0;

        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum > k && l <= r) {
                sum -= a[l++];
            }
            if (sum == k) {
                //printSubarray(a, l, r);
                sum = 0;
                l = r + 1;
            }
        }
    }
}
