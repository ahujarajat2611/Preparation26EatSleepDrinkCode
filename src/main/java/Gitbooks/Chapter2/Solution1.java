package Gitbooks.Chapter2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hadoop on 17/9/17.
 */


public class Solution1 {
    public static void main(String[] args) {
        int []nums = {2,1};
        int []nums1 = {2,1};
        int []nums2 = {2,1};
        int []nums3 = {2,1};


        Solution1 solution1 = new Solution1();
        System.out.println(solution1.partition(nums3,0,nums3.length-1));
        System.out.println(nums3[0]);
        System.out.println(nums3[1]);
        System.out.println("end");
        //nums = original;
        System.out.println(solution1.partitionDutch(nums,0,nums.length-1));
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println("end");

        System.out.println(solution1.partitionmine(nums1,0,nums1.length-1));

        System.out.println(nums1[0]);
        System.out.println(nums1[1]);
        System.out.println("end");

        System.out.println(solution1.partitionTwoPointerTechnique(nums2,0,nums2.length-1));
        System.out.println(nums2[0]);
        System.out.println(nums2[1]);
        System.out.println("end");


    }
    public int findKthLargest(int[] nums, int k) {
        //         Arrays.sort(nums);
        // int length = nums.length;
        // return nums[length-k];
        //         PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o2-o1;
        //     }
        // });
        // for(int num:nums){
        //     pq.add(num);
        // }
        // int ans=Integer.MAX_VALUE ;
        // while (k-->0){
        //     ans = pq.poll();
        // }
        // return ans;

//          PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//             @Override
//             public int compare(Integer o1, Integer o2) {
//                 return o1-o2;
//             }
//         });
//         for(int i=0;i<nums.length;i++){
//             if(i<k) {
//                 pq.add(nums[i]);
//             }
//             else {
//                 if(nums[i] >pq.peek()){
//                     pq.poll();
//                     pq.add(nums[i]);
//                 }

//             }
//         }

//         return pq.peek();
        return findKthLargestQuickSelect(nums,k);
        //return kthLargestElement(k,nums);
    }




    int findKthLargestQuickSelect(int nums[], int k){
        int start = 0;
        int end = nums.length-1;
        k = nums.length-k+1;
        return findKthSmallestQuick(start,end,nums,k);
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
            // k <= index -publish  +1;
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

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);

    }
    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }
    public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];

        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;//return where is the pivot; its position
    }
    private  int partitionmine (int array[],int start ,int end){
        int i = start -1 ;
        int j = start;

        int pivot = array[start];
        if(start == end ){
            return start;
        }
        while(j<= end){
            if(array[j]<pivot){
                i = i+1;
                swap(array, i, j);
                j = j+1;
            }
            else if(array[j] == pivot){
                j++;
            }
            else if(array[j] >pivot){
                swap(array, j, end);
                end = end -1;
            }
        }
        if(i == start -1) {
            return i + 1;
        }
        else{
            return i;
        }
        //return end;
    }
    private int partitionTwoPointerTechnique(int array[],int left,int right){
        int pivot = array[left];

        int leftPointer = left;
        for(int i=left+1;i<=right;i++){
            if(array[i]<pivot){
                swap(array,++leftPointer,i);
            }
        }
        System.out.println("pointer"+array[leftPointer]);
        swap(array,leftPointer,left);
        System.out.println("pointer"+array[leftPointer]);

        return leftPointer;
    }
    private int partitionTwoPointer(int input[],int low,int high) {

        int i = low;
        for (int j = low + 1; j <= high; j++)
            if (input[j]<input[low] && ++i != j) swap(input, i, j);
        if (low != i) swap(input, low, i);
        return i;
    }
    void partition(List<Integer> nums, List<Integer> pivots){
        Integer []boundaries = new Integer[pivots.size()];
        Arrays.fill(boundaries,0);
        for(int k=0;k<nums.size();k++){

            for(int i=0;i<pivots.size();i++) {
                if(nums.get(k)<pivots.get(i)){
                    Collections.swap(nums,k,boundaries[pivots.get(i)]);
                }
            }
            for(int i=1;i<pivots.size();i++){
                boundaries[i] = Math.max(boundaries[i],boundaries[i-1]);
            }

        }

    }


}