package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class TrapWater {
    int water(int []nums){
        int left =0;
        int right = nums.length-1;


        int totalwater= 0;
        // until next pointer is higher keep moving right
        // vey imp -1 contion and left + 1 > left
        // keep going left
        while (left<nums.length-1 && nums[left+1]>=nums[left]){
            left++;
        }
        // keep going right until right -1 >= right
        // imp condion of 1 needs to be taken care
        while (right>=1 && nums[right-1]>=nums[right]){
            right--;
        }

        // normal while lpp

        while (left< right){
            int leftheight = nums[left];
            int rightheight = nums[right];
            if(leftheight<=rightheight){
                // left heihgt is lower keep moving left pointer
                // and water will be
                // leftight -h[left]
                left = left+1;
                while (left<right && nums[left]<=leftheight){
                    totalwater = totalwater + leftheight-nums[left];
                    left++;
                }
            }
            else {
                // right height matters
                right = right -1;
                while (left<right && nums[right]<=rightheight){
                    totalwater = totalwater + rightheight-nums[right];
                    right--;
                }
            }
        }
        return totalwater;
    }
    public int rainWaterTrapped(int a[], int n) {
        if (n <= 1)
            return 0;
        int lMax[] = new int[n];
        int rMax[] = new int[n];

        int max_on_left = a[0];
        int max_on_right = a[n - 1];

        for (int i = 1; i < n; i++) {
            lMax[i] = max_on_left;
            max_on_left = Math.max(a[i], max_on_left);
        }

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = max_on_right;
            max_on_right = Math.max(a[i], max_on_right);
        }

        int t = 0;

        for (int i = 1; i < n - 1; i++) {
            if (a[i] < lMax[i] && a[i] < rMax[i]) {
                t += Math.min(lMax[i], rMax[i]) - a[i];
            }
        }
        return t;
    }
}
