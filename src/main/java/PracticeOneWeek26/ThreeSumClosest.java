package PracticeOneWeek26;

import java.util.Arrays;

/**
 * Created by hadoop on 7/12/17.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
        return Integer.MAX_VALUE;
    }

    Integer diff = Integer.MAX_VALUE;
        Arrays.sort(num);
    int ans = 0;
        for(int i=0;i<num.length;i++){
        int left = i+1;
        int right = num.length-1;
        while (left<right){
            int sum = num[i]+num[left]+num[right];
            if(Math.abs(sum-target)<diff){
                ans = sum;
                diff = Math.abs(sum-target);
            }
            if(sum == target){
                return sum;
            }
            if(sum<target){
                left++;
            }
            if(sum>target){
                right--;
            }
        }
    }
        return ans;
}
}