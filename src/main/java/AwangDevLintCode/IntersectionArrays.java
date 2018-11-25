package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class IntersectionArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);// nLog(n)
        final Set<Integer> resultSet = new HashSet<>();
        for (final int num: nums2) { // nLog(m)
            if(binarySearch(nums1, num)) {
                resultSet.add(num);
            }
        }
        int i = 0;
        final int[] result = new int[resultSet.size()];
        for (final int num: resultSet) {
            result[i++] = num;
        }
        return result;
    }
    // Running Binary Search on one of the arrays

    private boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int[] intersectionArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        final Set<Integer> unionSet = new HashSet<>();
        final Set<Integer> resultSet = new HashSet<>();
        for (final int num: nums1) {
            unionSet.add(num);
        }
        for (final int num: nums2) {
            if (unionSet.contains(num)) {
                resultSet.add(num);
            }
        }
        int i = 0;
        final int[] result = new int[resultSet.size()];
        for (final int num: resultSet) {
            result[i++] = num;
        }
        return result;
    }
}
