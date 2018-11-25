package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 13/10/17.
 */
public class Minimumsizesubarray {
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        int sum = 7;
        System.out.println(minsize(sum,nums));
    }
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
}
