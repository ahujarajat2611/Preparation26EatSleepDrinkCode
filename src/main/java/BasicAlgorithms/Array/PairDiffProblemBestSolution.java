package BasicAlgorithms.Array;

import java.util.Arrays;

/**
 * Created by hadoop on 25/12/17.
 */

// THere are two ways to deal with the solutions
// and here are two ways to deal with such things
    // Now advanced one actually looks damn simple ....
    // thats another sliding techniqie moving end by so many instead of 1 by one ...
    // move Fuck end until we meet condition

    // earlier i used to move end one by one here moving end by many until meet condition ..
    ///
public class PairDiffProblemBestSolution {
    public int findPairsAdvanced(int[] nums, int k) {

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
            start++;
        }
        return count;
    }

    public int findPairsBasicWOrking(int[] nums, int k) {
        if (k < 0 || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            int firNum = nums[left];
            int secNum = nums[right];
            // If less than k, increase the right index
            if (secNum - firNum < k) {
                right++;
            }
            // If larger than k, increase the left index
            else if (secNum - firNum > k) {
                left++;
            }
            // If equal, move left and right to next different number
            else {
                count++;
                while (left < nums.length && nums[left] == firNum) {
                    left++;
                }
                while (right < nums.length && nums[right] == secNum) {
                    right++;
                }
            }
            //left and right should not be the same number
            if (right == left) {
                right++;
            }
        }
        return count;
    }

}
