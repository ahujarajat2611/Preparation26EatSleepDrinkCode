package BasicAlgorithms.SlidingWindow;

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
    /*
     public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product =1;
        int left =0;
        int ans =0;
        for(int i=0;i<nums.length;i++){
            product = product * nums[i];
            while(left<i && product>=k){
                product = product/nums[left++];
            }
            if(product<k){
                ans += i-left+1;
            }
        }
        return ans;
    }
     */
}
