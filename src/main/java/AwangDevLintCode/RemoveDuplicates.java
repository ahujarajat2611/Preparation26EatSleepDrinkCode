package AwangDevLintCode;

/**
 * Created by hadoop on 3/3/18.
 */
// This is called tail techniqueeeee
public class RemoveDuplicates {
    int max2dup(int []nums){

        int tail = 1;
        for(int i=2;i<nums.length;i++){
            if(nums[tail]!= nums[i] || nums[tail-1]!=nums[i]){
                nums[++tail] = nums[i];
            }
        }
        return tail+1;
    }
    int max1dup(int []num){
        int tail = 0;
        for(int i=1;i<num.length;i++){
            if(num[tail]!=num[i]){
                num[++tail] = num[i];
            }
        }
        return tail+1;
    }
}
