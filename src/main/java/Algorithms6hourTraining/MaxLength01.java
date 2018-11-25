package Algorithms6hourTraining;

import java.util.*;
/**
 * Created by hadoop on 21/12/17.
 */
public class MaxLength01 {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        // inserrt sum and its index up to which yu have got this sum
        // whne taking diff ans would be i-map.get(sum-key)
        /// very imp we are using map to keeep the state
        // in one iteration we are check if we are getting duplicates
        // in one for loop we ar enot using two for loops
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                // once we find one sum, we are not updating keep lowest index to find the maxium length
                map.put(sum, i);
            }
        }
        return res;
    }
}
