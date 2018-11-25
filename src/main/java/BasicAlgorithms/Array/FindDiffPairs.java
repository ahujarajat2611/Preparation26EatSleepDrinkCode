package BasicAlgorithms.Array;

/**
 * Created by hadoop on 28/2/18.
 */
import java.util.*;
public class FindDiffPairs {
    public int findPairs(int[] nums, int k) {
        int start = 0;
        int end = 0;
        if(nums.length==0 || nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        while (end < nums.length) {
            while (start < end && nums[end] - nums[start] > k) {
                start++;
            }
            if (start < nums.length && start !=end && nums[end] - nums[start] == k) {
                count++;
                while (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end++;
                }
            }
            end++;
        }
        return count;
    }
}
