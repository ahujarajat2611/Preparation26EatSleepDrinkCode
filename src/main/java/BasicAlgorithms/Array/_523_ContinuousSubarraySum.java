package BasicAlgorithms.Array;
import java.util.*;

public class _523_ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// we can have check outside this loop if k is not zero ...
			if (k != 0) {
				sum = sum % k;
			}
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1) {
					return true;
				}
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}
}