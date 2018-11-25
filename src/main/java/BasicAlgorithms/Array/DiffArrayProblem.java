package BasicAlgorithms.Array;

import java.util.Arrays;
import java.util.*;

/**
 * Created by hadoop on 25/12/17.
 */
public class DiffArrayProblem {
    public static void main(String[] args) {
        int []array = {1,3,1,5,4};
        int diff = 0;
        DiffArrayProblem diffArrayProblem = new DiffArrayProblem();
        System.out.println(diffArrayProblem.findPairs(array, diff));
        System.out.println(diffArrayProblem.findPairsAdvanced(array, diff));

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
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < nums.length; ) {
            for (j = Math.max(j, i + 1); j < nums.length && nums[j] - nums[i] < k; ) {
                j++;
            }
            if (j < nums.length && nums[j] - nums[i] == k) ans++;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            i++;
            System.out.println("END"+j);
            System.out.println("START"+i);
        }
        return ans;
    }
}