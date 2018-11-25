package BasicAlgorithms.Array;
import java.util.*;

/**
 * Created by hadoop on 8/1/18.
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 3; left++) {
            for (int mid = left + 1; mid < nums.length - 2; mid++) {
                int i = mid + 1;
                int right = nums.length - 1;
                while (i < right) {
                    int sum = nums[left] + nums[mid] + nums[i] + nums[right];
                    if (sum == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[left]);
                        item.add(nums[mid]);
                        item.add(nums[i]);
                        item.add(nums[right]);
                        if (!set.contains(item)) {
                            set.add(item);
                            res.add(item);
                        }
                        i++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        i++;
                    }
                }
            }
        }
        return res;
    }
}
