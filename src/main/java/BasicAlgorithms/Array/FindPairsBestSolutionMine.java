package BasicAlgorithms.Array;

import java.util.Arrays;

/**
 * Created by hadoop on 26/1/18.
 */
public class FindPairsBestSolutionMine {
    public int findPairs(int[] nums, int k) {

        int start = 0;
        int end = 0;
        if(nums.length==0 || nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        while (start < nums.length) {
            end = start+1;
            while (end < nums.length && nums[end] - nums[start] < k) {
                end++;
            }
            if (end < nums.length && nums[end] - nums[start] == k) {
                count++;
            }
            while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
                start++;
            }
            // note here publish != end .. so keep that in mind
            // we move publish by 1111
            start++;
        }
        return count;
    }
}
