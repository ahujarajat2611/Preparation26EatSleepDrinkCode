package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 26/1/18.
 */
public class SlidingWindowDIfferentTechnique {
    // all positive number
    void findSubarray(int []num,int n,int sum){
        int windowsum = num[0];
        int low = 0;
        int high =0;
        int count =0;
        // low pointer
        // high pointer
        // take low pointer and then move forward forward high pointer ...
        // caluclutae some window andd see ...
        while (low<n){
            while(windowsum<sum && high<n) {
                high++;
                windowsum = windowsum + num[high];
            }
            if(windowsum == sum){
                System.out.println(low);
                // since we have incremented high
                System.out.println(high);
                //windowsum = windowsum-num[low];
                //low++;
            }
            // while (windowsum>sum && low<n) {
            windowsum = windowsum - num[low];
            low++;
            //}
        }
    }

    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < nums.length; ) {
            for (j = Math.max(j, i + 1); j < nums.length && nums[j] - nums[i] < k; ) {
                j++;
            }
            if (j < nums.length && nums[j] - nums[i] == k) ans++;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            i++;
            System.out.println("END"+j);
            System.out.println("START"+i);
        }
        return ans;
    }

    public int findPairsMineAndWOrking(int[] nums, int k) {

        int start = 0;
        int end = 0;
        if(nums.length==0 || nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        while (start < nums.length) {
            end = start+1;
            while (end < nums.length && nums[end] - nums[start] < k) {
                end++;
            }
            if (end < nums.length && nums[end] - nums[start] == k) {
                count++;
            }
            while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
                start++;
            }
            start++;
        }
        return count;
    }

    public int findPairsMineAndWOrkingENd(int[] nums, int k) {

        int start = 0;
        int end = 0;
        if(nums.length==0 || nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        while (end < nums.length) {
            while (start < end && nums[end] - nums[start] > k) {
                start++;
            }
            if (start < nums.length && nums[end] - nums[start] == k) {
                count++;
            }
            while (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                end++;
            }
            end++;
        }
        return count;
    }

    /*



     */

    public boolean hasSequence(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return false;
        }
        int n = nums.length;
        int[] sums = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int i = 0, j = 1;
        while(j <= n){
            if((sums[j] - sums[i]) < target){
                j++;
            } else if ((sums[j] - sums[i]) > target){
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
    public void subArraysOfSumK(int[] a, int n, int k) {

        int sum = 0;
        int l = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                //printSubarray(a, i, i);
                l = i + 1;
                sum = 0;
                continue;
            }

            sum += a[i];

            while (l <= i && sum > k) {
                sum -= a[l++];
            }

            if (sum == k) {
               // printSubarray(a, l, i);
                sum = 0;
                l = i + 1;
            }

        }
    }

    public void subArraysOfSum(int[] a, int k) {

        int sum = 0;
        int l = 0;

        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum > k && l <= r) {
                sum -= a[l++];
            }
            if (sum == k) {
                //printSubarray(a, l, r);
                sum = 0;
                // r+1 since by next time loop starts r will get increment by
                // 1 by for lopp ....
                l = r + 1;
            }
        }
    }
    List<String> summaryRangeProblemSolution(int []nums){
        List<String> summary = new ArrayList<>();
        // sliding technique problem
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            while (i+1<nums.length && nums[i+1]-nums[i] == 1){
                i++;
            }
            if(val!=nums[i]) {
                summary.add(String.valueOf(val)+"->"+String.valueOf(nums[i]));
            }
            else {
                summary.add(String.valueOf(val));
            }
        }
        return summary;
    }
    /*

    With old technique

    def has_sequnce(nums, t):
    if not nums or t <= 0: return False
    left, right, total = 0, 0, 0

    while right < len(nums):
        total += nums[right]
        right += 1

        while total > t:
            total -= nums[left]
            left += 1

        if total == t:
            return True

    return False

     */


}
