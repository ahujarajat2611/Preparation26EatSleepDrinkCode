package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
/*
Thoughts:
1. Think of k as the upper limit of the range
 that we want to pick our i and j.
2. When i is in [0 ~ k], we can pick and j that's also in
[0 ~ k]. This can be checked in a for loop, with a HashSet.
3. Once i pass k, we need to remove any value that's in range
 [0, i-k) from the set, because they are out of range.
They are no longer fit the condition to duplicate with
nums[i], regardless if they are duplicates or not

Note: set.add(..) return false if the value already exist in set.
*/
import java.util.*;
public class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
// doing both things at same time checking and adding
            if (!set.add(nums[i])) {
                return true;
            }
            // whether you addd and then remove
            // you remove or add does not matter
            // since checking will happen in next itertatio
            //
            if (i >=k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that
the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
*/
/*
Thoughts:
Given Math.abs(A-B) <= t ->>> -t <= A - B <= t. Therefor, we want find A such as:
A >= B - t
A <= B + t
1. Need to find an element A thats greater to equal to (B-t), and also use the A needs to less or equal to (B+t)
For this, we can use a binary search tree, where to can quickly find the (B-t) and hence A.
Utilize TreeSet.ceiling() to find A
2. This binary search tree needs to be flexible in terms of removing item:
Exact same idea as in 'Contains Duplicate II': once i pass k, we need to remove any value that's in range [0, i-k) from the set, because they are out of range.
*/
class duplicatesWithRange{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // or we could have found both floor and ceil of num[i] and check for floor and ceil range .. if it is between
            // t then for sure such element exisst .. right now we are checking for kth element and my set has k element
            // i want to remove kth element before i insert k+1 element since i want my set to contain only k eelemnets
            // thats easy way tot thik
            // your set should have k elements
            Long target = treeSet.ceiling((long)nums[i] - t);
            if (target != null && target <= (long)nums[i] + t) {
                return true;
            }
            if (i >= k) {
                treeSet.remove((long)nums[i - k]);
            }
            treeSet.add((long)nums[i]);
        }
        return false;
    }
}

