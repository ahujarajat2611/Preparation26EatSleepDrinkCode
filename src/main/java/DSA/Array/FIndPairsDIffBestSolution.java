package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class FIndPairsDIffBestSolution {
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
            start = start +1 ;
        }
        return count;
    }
}
