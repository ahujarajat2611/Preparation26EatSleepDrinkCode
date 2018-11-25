package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 13/10/17.
 */
public class DuplicatesAgain {
    public static void main(String args[]){
        int nums[] = {2,5,1,1,4,3};
        int ans = duplicate(nums);
        System.out.println("ans"+ans);
    }

    private static int duplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);

        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow+1;
    }

}
