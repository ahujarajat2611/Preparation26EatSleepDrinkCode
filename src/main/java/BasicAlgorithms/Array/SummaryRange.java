package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 12/10/17.
 */
public class SummaryRange {
    List<String> summaryRange(int[] nums) {
        List<String> summary = new ArrayList<>();
        // sliding technique problem
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (val != nums[i]) {
                summary.add(String.valueOf(val) + "->" + String.valueOf(nums[i]));
            }
            // if val == nums[i] means no movement // just add that number in the
            // summary
            else {
                summary.add(String.valueOf(val));
            }
        }
        return summary;
    }

    List<String> summaryRangeTwoPointer(int[] nums) {
        int start =0;
        List<String> summary = new ArrayList<>();
        while (start<nums.length){
            int end = start+1;
            while (end<nums.length && nums[end]-nums[end-1] == 1){
                end++;
            }
            if(nums[start] == nums[end-1]){
                summary.add(String.valueOf(nums[start]));
                start++;
            }
            else {
                summary.add(String.valueOf(nums[start]+"->"+nums[end-1]));
                start =end;
            }
        }
        return summary;
    }
}
