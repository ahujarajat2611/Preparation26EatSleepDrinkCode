package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

The easiest solution is to sort the array and add elements from head and tail:

 1 2 3 4 5 6 => 1 6 2 5 3 4

But, this solution takes O(nlogn) complexity. We definitely can do better.

Based on the problem, we know that for any index i, if i is even, then nums[i] <= nums[i - 1], other wise, nums[i] >= nums[i - 1]. Now we only need to traverse the array once and swap the elements that don't follow the rule.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 != 0 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]  = nums[j];
        nums[j] = tmp;
    }
}
