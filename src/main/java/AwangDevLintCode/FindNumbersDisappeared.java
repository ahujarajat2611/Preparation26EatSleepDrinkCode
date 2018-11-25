package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

/*
Thought1:
Move it to where it should be at.
Important: if we keep traverse for loop, once it swap once and i + 1, the nums[i] may have a incorrect value.
Therefore, the solution should handle (i - 1) after each swap, until there is no swap to do on nums[i].
In the background, the rumtime may accumulate up to 2n: n for all sways on index i = 0; and another n for the rest traverse. Overall, it's still O(n)
 */
import java.util.*;
public class FindNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        final List<Integer> resultList = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        for (int i = 0; i < nums.length; i++) {
            // we find desired index and swap .. also we could have make those elements negative then scan and see
            // which ever index are non negative those index dont exists simple
            // Fuck it is tahat simple
            int desiredIndex = nums[i] - 1;
            if (nums[desiredIndex] != nums[i]) {
                int temp = nums[desiredIndex];
                nums[desiredIndex] = nums[i];
                nums[i] = temp;
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                resultList.add(i + 1);
            }
        }
        return resultList;
    }
}
