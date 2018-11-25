package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 22/1/18.
 */
public class RansomPickIndex {
    int[] nums;
    Random rnd;

    public RansomPickIndex(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }
}
