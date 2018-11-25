package BasicAlgorithms.Array;

/**
 * Created by hadoop on 23/2/18.
 */
import java.util.*;
public class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList();
        if(nums.length == 0){
            if(lower == upper)
                res.add(lower + "");
            else res.add(lower + "->" + upper);
            return res;
        }

        if(lower < nums[0])
            if(nums[0] - 1 == lower)
                res.add(lower +"");
            else res.add(lower + "->" + (nums[0] - 1));

        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i - 1];
            if(diff > 1){
                if(diff == 2)
                    res.add((nums[i - 1] + 1) + "");
                else res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
            }
        }

        if(upper > nums[nums.length - 1])
            if(nums[nums.length - 1] + 1 == upper)
                res.add(upper + "");
            else res.add((nums[nums.length - 1] + 1) + "->" + upper);

        return res;
    }
}
