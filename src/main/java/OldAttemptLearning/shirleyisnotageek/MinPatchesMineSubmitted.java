package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 5/3/18.
 */
public class MinPatchesMineSubmitted {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i =0;

        int ans =0;
        // if(nums.length ==0){
        //     ans++;
        // }
        while (miss<=n){
            if(i <nums.length && nums[i]<=miss){
                miss = miss+nums[i];
                i++;
            }
            else {
                ans++;
                miss = miss + miss;
            }
        }
        return ans;
    }
}
