package BasicAlgorithms.Array;

/**
 * Created by hadoop on 11/10/17.
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        boolean ans = istrip(nums);
        System.out.println("ans" + ans);
        }

    private static boolean istrip(int[] nums) {
        if(nums.length<3) {
            return false;
        }
        int max;
        int min;
        if(nums[0]<nums[1]){
            max = nums[1];
            min = nums[0];
        }
        else {
            min = nums[1];
            max = Integer.MAX_VALUE;
        }
        for(int i=2;i<nums.length;i++){
            if(nums[i]>max){
                return true;
            }
            else {
                if(nums[i]<min){
                    min = nums[i];
                }
                else if(nums[i]!=min && nums[i]<max){
                    max = nums[i];
                }
            }
        }
        return false;
    }
    public boolean increasingTriplet(int[] nums) {
        int minagain = Integer.MAX_VALUE;
        int secondminagain = Integer.MAX_VALUE;
        for (int nu : nums) {
            // there is reason to equal sign since 2  2 2 is not the answer
            //such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false
            if (nu <= minagain) {
                minagain = nu;
            } else if (nu <= secondminagain) {
                secondminagain = nu;
            } else {
                return true;
            }
        }
        return false;
    }
}
