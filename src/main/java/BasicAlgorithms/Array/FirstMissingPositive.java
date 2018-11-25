package BasicAlgorithms.Array;

/**
 * Created by hadoop on 12/10/17.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int nums[] = {3,4,-1,-1};
        int first = missingnumber(nums);
    }

    private static int missingnumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
                i--;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1 !=nums.length){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}

/*
public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
 */