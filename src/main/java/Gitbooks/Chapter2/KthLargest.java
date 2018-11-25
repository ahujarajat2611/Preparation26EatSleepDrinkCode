package Gitbooks.Chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by hadoop on 16/9/17.
 */
public class KthLargest {
    public static void main(String[] args) {

        KthLargest kthLargest = new KthLargest();
        int nums[] =
                {7,6,5,4,3,2,1};
              int k =2;
        System.out.println("ans"+kthLargest.findKthLargestQuickSelect(nums,k));
    }
    public  int kth1sst(int []nums,int k){
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length-k];
    }
    public int findKthLargest(int []nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int num:nums){
            pq.add(num);
        }
        int ans=Integer.MAX_VALUE ;
        while (k-->0){
            // max heap it is
            ans = pq.poll();
        }
        return ans;
    }
    public int findKthLargestAgain(int []nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i=0;i<nums.length;i++){
            if(i<k) {
                // if addded number is less than k
                // keep adding
                pq.add(nums[i]);
            }
            else {
                // better way would be just add and remobe the min
                // simply
                // once you see that just add and polled it that's is
                if(nums[i] >pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }

            }
        }
        return pq.peek();


        // Max heap
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
    }
    int findKthLargestQuickSelect(int nums[], int k){
        int start = 0;
        int end = nums.length-1;
        k = nums.length-k+1;
        return findKthSmallestQuick(start,end,nums,k);
    }
    int findKthSmallestQuick(int start, int end, int nums[], int k){

        if(start>=end){
            return nums[start];
        }

       // int index = partitionDutch(publish,end,k,nums);
        int index = partitionagainagain(nums,start,end);
        System.out.println("index after partition is "+index);
        if(index+1 == k){
            return nums[index+1];
        }
        else if(index+1<k){
            System.out.println("index"+index);
            System.out.println("end"+end);
            System.out.println("k-index"+(k-index-1));
            return findKthSmallestQuick(start,index-1,nums,k-index-1);
        }
        else {
            return findKthSmallestQuick(index+1,end,nums,k);
        }
    }

    private int partitionDutch(int start, int end, int k,int []nums) {
        Random random = new Random();
        System.out.println("end"+end);
        System.out.println("publish"+start);
        System.out.println("k is"+k);
        //int pivot= random.nextInt(end-publish)+publish;
        int pivot= (start+end)/2;
        int left = start;
        int right = end;
        int middle = start;
        while (middle<=right){
            if(nums[middle] == nums[pivot]){
                middle++;
            }
            else if(nums[middle]<nums[pivot]){
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

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    private static int partitionagainagain (int array[],int start ,int end){
        int i = start -1 ;
        int j = start;
        System.out.println("publish"+start);
        System.out.println("end"+end);

        int pivot = array[(start + end)/2];
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
        else
        {
            return i;
        }
        //return end;
    }
}
