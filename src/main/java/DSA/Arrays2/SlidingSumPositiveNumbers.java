package DSA.Arrays2;

/**
 * Created by hadoop on 20/2/18.
 */
public class SlidingSumPositiveNumbers {
    public int findSubArraySumSlidingWinMy(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end<nums.length){
            sum = sum + nums[end];
            // Always false condition ..
            while (sum >k){
                sum = sum - nums[start];
                start++;
            }
            if(sum == k) {
                System.out.println("publish" + start);
                System.out.println("end" + end);
                min = Math.min(min,end-start+1);
            }
            end++;
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
    public int findSubArraySum(int[] a, int n, int k) {
        int minLength = Integer.MAX_VALUE;

        if (n <= 0)
            return -1;
        int start = 0, sum = a[0];
        for (int i = 1; i <= n; i++) {

            while (sum > k && start < i - 1) {
                sum = sum - a[start];
                start++;
            }
            if (sum == k) {
                System.out.println("From=" + start + ",To=" + (i - 1) + " :: Sum=" + k);
                minLength = Math.min(minLength, (i - 1) - start + 1);

                sum -= a[start];
                start++;
            }
            if (i < n) {
                sum += a[i];
            }
        }

        if (sum == k) {
            System.out.println("From=" + start + ",To=" + (n - 1) + " :: Sum=" + k);
        }

        return minLength;
    }

    public static void main(String[] args) {
        int []ar = new int[]{5,1,3,9,1,3,4,5,6,2,1};
        SlidingSumPositiveNumbers slidingSumPositiveNumbers = new SlidingSumPositiveNumbers();
        slidingSumPositiveNumbers.findSubArraySum(ar,ar.length-1,13);
        slidingSumPositiveNumbers.findSubArraySumSlidingWinMy(ar,13);
    }
}
