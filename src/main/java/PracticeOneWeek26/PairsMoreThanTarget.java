package PracticeOneWeek26;

import java.util.Arrays;

/**
 * Created by hadoop on 7/12/17.
 */
public class PairsMoreThanTarget {
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            // note equaltiy not included in this
            if (nums[left] + nums[right] > target) {
                // imp step ... not right-left + 1....
                count += (right - left);
                // endinh at right how many left values ...
                /// imp step to decrement
                // right --- very imp take a note of this
                right--;
            } else {
                // usual  step that we do
                left++;
            }
        }
        return count;
    }
    public int twoSum2Again(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int index = binarySearch(nums, target - nums[i - 1], i, nums.length - 1);
            count += nums.length - index;
        }
        return count;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        int mid;
        int sum;
        while (start + 1 < end) {
            mid = start + (end - start) /2;
            if (mid - 1 >= 0 && nums[mid-1] <= target && target < nums[mid]) {
                return mid;
            } else if (mid + 1 < nums.length &&  nums[mid] <= target && target < nums[mid + 1]) {
                return mid + 1;
            } else if (target < nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] > target) {
            return start;
        }
        return (nums[end] > target) ? end : nums.length;
    }
    public int twoSum2AgainAgain(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count += (nums[i] + nums[j] > target) ? 1 : 0;
            }
        }
        return count;
    }
}
