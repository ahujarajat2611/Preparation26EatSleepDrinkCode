package BasicAlgorithms.Greedy;
import java.util.*;

/**
 * Created by hadoop on 25/12/17.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        Map<Integer, String> map = new HashMap<>();
        String[] res = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        map.put(pq.poll(), "Gold Medal");
        map.put(pq.poll(), "Silver Medal");
        map.put(pq.poll(), "Bronze Medal");

        for (int i = 4; i <= nums.length; i++) {
            map.put(pq.poll(), Integer.toString(i));
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
