package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 16/12/17.
 */
public class SubArraysProblem {
    public static int minsize(int s, int []nums){
        int minlength = Integer.MAX_VALUE;
        int right=0;
        int left=0;
        int sum = 0;

        // normal sliding windo approach
        // right pointter
        // and
        while (right<nums.length){
            sum = sum + nums[right];
            while (sum>=s){
                // min length where sum is more than s
                sum = sum-nums[left];
                //kepe tracks of min length
                minlength = Math.min(minlength,right-left+1);
                left = left+1;
            }
            right++;
        }
        return minlength;
    }

    public void subArraysOfSum(int[] a, int k) {

        int sum = 0;
        int l = 0;

        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum > k && l <= r) {
                /// this is fucking right
                // we can have normal sliding window
                // to solve this problem ...
                sum -= a[l++];
            }
            if (sum == k) {
                //printSubarray(a, l, r);
                sum = 0;
                l = r + 1;
            }
        }
    }
    public void subarraysum(int []a,int k ){
        int l =0;
        int r =0;
        int sum = 0;

        for(r=0;r<a.length;r++){
            sum = sum + a[r];
            while (sum >k && l<=r){
                sum = sum -a[l++];
            }
            if(sum == k){
                // l and r is the answer index
                // print l and r
                // vim back to orihinla wequal tion
                sum = 0;
                l = r+ 1;
            }

        }






    }
}
