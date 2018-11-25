package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 24/12/17.
 */
public class ProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, prod = 1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (l < r && prod >= k)
                prod /= nums[l++];
            if (prod < k)
                ans += r - l + 1;
        }
        return ans;
    }
}
