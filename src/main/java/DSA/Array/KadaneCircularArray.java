package DSA.Array;

import java.util.ArrayList;
import java.util.*;
/**
 * Created by hadoop on 10/2/18.
 */
public class KadaneCircularArray {
    public int maxCircularSubarraySum(List<Integer> list) {

        int minAns = minSubArray(list);
        int maxAns = maxSubArray(list);
        System.out.println(minAns);
        System.out.println(maxAns);
        int totalSum =0;
        for(Integer x:list){
            totalSum = totalSum + x;
        }

        return maxAns >(totalSum-minAns) ? maxAns :(totalSum-minAns);
    }
    public static void main(String args[]){
        KadaneCircularArray kadaneCircularArray = new KadaneCircularArray();
        List<Integer> list = new ArrayList<Integer>();
        list.add(9);
        list.add(-1);
        list.add(-6);
        list.add(10);
        list.add(15);
        list.add(-4);
        System.out.println(kadaneCircularArray.maxCircularSubarraySum(list));
    }
    /**
     * Created by hadoop on 11/12/17.
     * Thoughts:
     Note: sub-array has order. It's not sub-set
     1. On each index: decide to add with nums.get(i), to use the new lowest value nums.get(i). That means:
     If the new value is negative (it has decresing impact on sum) and the sum is larger than new value, just use the new value.
     In another case, if sum has been nagative, so sum + new value will be even smaller, then use sum.
     2. Every time compare the currMin with the overall minimum value, call it minRst.
     */
        public int minSubArray(List<Integer> nums) {
            if (nums == null || nums.size() == 0) {
                return 0;
            }
            int curMin = nums.get(0);
            int minRst = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                curMin = Math.min(nums.get(i), curMin + nums.get(i));
                minRst = Math.min(curMin, minRst);
            }
            return minRst;
        }

    public int maxSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int curMax = nums.get(0);
        int maxRst = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            curMax = Math.max(nums.get(i), curMax + nums.get(i));
            maxRst = Math.max(curMax, maxRst);
        }
        return maxRst;
    }
}