package BasicAlgorithms.String;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        Iterator<Integer> it = set.iterator();
        int maxsize = 0;
        for(int i=0;i<nums.length;i++) {
            if (set.remove(nums[i])) {
                int elem = nums[i];
                int leftsize = 0;
                int rightsize = 0;
                int leftreduce = elem - 1;
                int rightreduce = elem + 1;
                while (set.remove(leftreduce)) {
                    leftreduce--;
                    leftsize++;
                }
                while (set.remove(rightreduce)) {
                    rightreduce++;
                    rightsize++;
                }
                maxsize = Math.max(maxsize, leftsize + rightsize + 1);
            }
        }
        return maxsize;
    }
    public static void main(String args[]){
        LongestConsecutiveSequence lsc = new LongestConsecutiveSequence();
        int num[]={1,2,3,4};
        System.out.println(lsc.longestConsecutive(num));
    }
}