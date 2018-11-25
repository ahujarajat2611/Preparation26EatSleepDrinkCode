package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 23/10/17.
 */
public class MinPatches {
    public int minPatches(int[] nums, int n) {

        long miss = 1;
        int ans = 0;
        int i=0;
            while(miss<=n) {
                if (i<nums.length && nums[i] <= miss) {
                    miss = miss + nums[i];
                    i++;
                } else {
                    ans++;
                    miss = miss + miss;
                }
                if (miss >= n) {
                    return ans;
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2,10};
        int n = 30;
        MinPatches minPatches = new MinPatches();
        System.out.println(minPatches.minPatches(nums,n));
    }

    int miss (int []nums, int n){
        int miss = 1;
        int i =0;
        int ans =0;
        while (miss<n){
            if(i <nums.length && nums[i]<=miss){
                miss = miss  +nums[i];
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