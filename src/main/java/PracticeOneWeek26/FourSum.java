package PracticeOneWeek26;

import java.util.Arrays;
import java.util.*;

/**
 * Created by hadoop on 7/12/17.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return fourSumMy(nums,target);

    }
    private void twoSumMY(List<List<Integer>> res, int[] nums, int sum, int left, int first, int seocnd) {
        int begin = left;
        int right = nums.length-1;
        while (left<right) {
            if(left>begin && nums[left-1] == nums[left]) {
                left++;
                continue;
            }
            if(right<nums.length-1 && nums[right] == nums[right+1]) {
                right--;
                continue;
            }

            int total = nums[left] + nums[right];
            if(total >sum) {
                right--;
            }
            else if(total<sum) {
                left++;
            }
            else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[first]);
                list1.add(nums[seocnd]);
                list1.add(nums[left]);
                list1.add(nums[right]);
                res.add(list1);
                left++;
                right--;
            }
        }
    }


    public List<List<Integer>> fourSumMy(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = target - nums[i] - nums[j];
                int start = j + 1;
                twoSumMY(res,nums, sum, start,i,j);
            }
        }
        return res;
    }
}
