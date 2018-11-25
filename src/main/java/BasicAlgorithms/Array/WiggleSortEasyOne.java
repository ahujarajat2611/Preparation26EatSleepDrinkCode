package BasicAlgorithms.Array;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 16/1/18.
 */
public class WiggleSortEasyOne {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 != 0 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swapnum(nums, i, i - 1);
            }
        }
    }
    private void swapnum(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]  = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        WiggleSortEasyOne wiggleSortEasyOne = new WiggleSortEasyOne();
        wiggleSortEasyOne.wiggleSortMed(new int[]{5,10,7,9,4,12});
    }

    public void wiggleSortMed(int[] nums) {
        int k=nums.length/2;
        int median = findKthSmallestQuick(0,nums.length-1, nums,k);
        int space [] = new int[nums.length];
        int l = 1;
        int r =  k%2 == 0 ? k+2 :k+1;

        while (l<k-1 && r <nums.length){
            swapnum(nums,l,r);
            l= l+2;
            r = r+2;
        }
        ConsoleWriter.printArray(nums);

//
//        int l = 0; int m = 0; int r = nums.length - 1;
//        while(m <= r){
//            if(nums[get(nums, m)] > median)
//                swap(nums, get(nums, m++), get(nums, l++));
//            else if(nums[get(nums, m)] < median)
//                swap(nums, get(nums, m), get(nums, r--));
//            else m++;
//        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int median(int[] nums, int k){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int pi = partition(nums, left, right);
            if(pi == k) return nums[pi];
            else if(pi > k) right = pi - 1;
            else left = pi + 1;
        }
        return 0;
    }

    private int partition(int[]nums, int left, int right){
        int pivot = nums[right];
        int lessIndex = left - 1;
        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                lessIndex++;
                swap(nums, i, lessIndex);
            }
        }
        swap(nums, lessIndex + 1, right);
        return lessIndex + 1;
    }

    private int get(int[] nums, int i){
        if(i <= (nums.length / 2 - 1)) return i * 2 + 1;
        return (i - nums.length / 2) * 2;
    }
    int findKthSmallestQuick(int start, int end, int nums[], int k){
        if(start>end){
            return -1;
        }
        if(start == end){
            return nums[start];
        }
        int index = partitionDutch(nums,start,end);
        if(index +1 -start == k){
            return nums[index];
        }
        else if(index+1-start<k){
            return findKthSmallestQuick(index+1,end,nums,k+start-index-1);
        }
        else {
            return findKthSmallestQuick(start,index-1,nums,k);
        }
    }

    private int partitionDutch(int []nums,int start,int end) {
        int pivot= nums[start];
        int left = start;
        int right = end;
        int middle = start;
        while (middle<=right){
            if(nums[middle] == pivot){
                middle++;
            }
            else if(nums[middle]<pivot){
                swap(nums,left,middle);
                middle++;
                left++;
            }
            else {
                swap(nums,right,middle);
                right--;
            }
        }
        return left;
    }
}

/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

The easiest solution is to sort the array and add elements from head and tail:

 1 2 3 4 5 6 => 1 6 2 5 3 4

But, this solution takes O(nlogn) complexity. We definitely can do better.

Based on the problem, we know that for any index i, if i is even, then nums[i] <= nums[i - 1], other wise, nums[i] >= nums[i - 1]. Now we only need to traverse the array once and swap the elements that don't follow the rule.
 */