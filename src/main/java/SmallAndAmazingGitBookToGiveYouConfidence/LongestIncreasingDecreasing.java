package SmallAndAmazingGitBookToGiveYouConfidence;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 21/9/17.
 */
public class LongestIncreasingDecreasing {
    public static int maxIncreasingLength(int []nums){
        int []leftIncreasing = new int[nums.length];
        leftIncreasing[0] = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>=nums[i-1]){
                leftIncreasing[i] = leftIncreasing[i-1]+1;
            }
            else {
                leftIncreasing[i] = 1;
            }
        }

        ConsoleWriter.printArray(leftIncreasing);
        int []rightIncreasing = new int[nums.length];

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=nums[i+1]){
                rightIncreasing[i] = rightIncreasing[i+1]+1;
            }
            else {
                rightIncreasing[i] = 1;
            }
        }
            ConsoleWriter.printArray(rightIncreasing);

        int ans =1;
        for(int i=0;i<nums.length;i++){
            // i think it should be plus in
            ans = Math.max(ans,leftIncreasing[i]+rightIncreasing[i]-1);
        }

        System.out.println("ans"+ans);
        return ans;
    }

    public static void main(String[] args) {
        int []nums ={1,2,3,5, 4, 2, 1, 3};
        System.out.println(maxIncreasingLength(nums));
    }
}
