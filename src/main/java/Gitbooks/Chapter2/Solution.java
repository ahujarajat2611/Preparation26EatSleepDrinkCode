package Gitbooks.Chapter2;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums []= {2,1};
        int k =1;
        System.out.println("ans"+solution.findKthLargest(nums,k));
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
        int index = partitionDutch(start,end,k,nums);
        if(index +1 == k){
            return nums[index];
        }
        else if(k<index+1){
            return findKthSmallestQuick(start,index-1,nums,k-index-1);
        }
        else {
            return findKthSmallestQuick(index+1,end,nums,k);
        }
    }

    private int partitionDutch(int start, int end, int k,int []nums) {
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

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}