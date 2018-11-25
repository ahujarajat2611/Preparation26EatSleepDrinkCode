package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 16/1/18.
 */
public class RangeAddition {
    private static class Solution1 {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] nums = new int[length];
            int k = updates.length;
            for (int i = 0; i < k; i++) {
                int start = updates[i][0];
                int end = updates[i][1];
                int inc = updates[i][2];
                nums[start] += inc;
                if (end < length - 1) {
                    nums[end + 1] -= inc;
                }
            }

            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += nums[i];
                nums[i] = sum;
            }
            return nums;
        }
    }

    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;

    }
}