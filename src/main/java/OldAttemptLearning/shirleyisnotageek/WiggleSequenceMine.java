package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 2/3/18.
 */
public class WiggleSequenceMine {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }

        int[] up = new int[nums.length];
        int []down = new int[nums.length];


        up[0] = 1;
        down[0] = 1;


        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                up[i] = Math.max(up[i-1],down[i-1]+1);
            }
            else if (nums[i]<nums[i-1]){
                down[i] = Math.max(down[i-1],up[i-1] +1);
            }
            else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }
}
