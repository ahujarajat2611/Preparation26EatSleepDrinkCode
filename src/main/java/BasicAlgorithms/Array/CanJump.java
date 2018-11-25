package BasicAlgorithms.Array;

import java.util.Arrays;

/**
 * Created by hadoop on 22/10/17.
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        boolean jump[] = new boolean[nums.length];
        jump[0] = true;
        for(int end=0;end<nums.length;end++){
            for(int i=0;i<end;i++){
                if(nums[i]+i>=end && jump[i]){
                    jump[end] = true;
                }
            }
        }
        return jump[nums.length-1];
    }
    public boolean canJumpGreedy(int[] nums) {

        int farthest = 0+nums[0];
        if (farthest == 0){
            return false;
        }
        int index =0;
        // for loop construct
        // init and then contitoion check and then icnrement condition check

        // going trhough all index one by one and cal and the max farthest at each
        // point
        for(;index<nums.length && index<=farthest;index++){
            farthest = Math.max(farthest,index+nums[index]);
        }
        if(farthest>=nums.length-1){
            return true;
        }
        return false;
    }
    public int canJumpminSteps(int[] nums) {
        int jump[] = new int[nums.length];
        Arrays.fill(jump,Integer.MAX_VALUE);
        jump[0] = 0;
        for(int end=1;end<nums.length;end++){
            for(int i=0;i<end;i++){
                if(nums[i]+i>=end && jump[end]>jump[i]+1){
                    jump[end] = jump[i]+1;
                }
            }
        }
        return jump[nums.length-1];
    }
    public int jump(int []nums){
        int start = 0;
        int end = 0;
        int steps =0;
        int farthestPointReached =0;
        while (end< nums.length){
            steps++;
            for(int k=start;k<=end;k++){
                farthestPointReached = Math.max(farthestPointReached,k+nums[k]);
                if(farthestPointReached>= nums.length-1){
                    return steps;
                }
            }
            start = end+1;
            end = farthestPointReached;
        }
        return -1;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int nums[]={3,2,1,0,4};
        canJump.canJumpGreedy(nums);
        int nums1[] = {2,3,1,1,4};
        System.out.println(canJump.canJumpminSteps(nums1));
    }
}