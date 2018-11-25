package CodingNinjas;

/**
 * Created by hadoop on 11/10/17.
 */
public class KthLargest {
    public static void main(String args[]){
        int array[] ={4,3,2,5,6,9};

        // min head best solution to find kth largest
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
        System.out.println(kthlargest(array,4,0,array.length-1));
        System.out.println(findKthSmallestQuick(0,array.length-1,array,4));
    }
    public static int kthlargest(int []array,int k,int start,int end){

        if(end<start){
            return -1;
        }
        if(start == end){
            return array[start];
        }
        int partition = getpartition(array,k,start,end);
        if(partition-start +1 == k){
            return array[partition];
        }
        if(partition-start+1 >k){
            System.out.println("publish"+start);
            System.out.println("partition"+partition);
            return kthlargest(array,k,start,partition-1);
        }
        else {
            return kthlargest(array,k-partition-1+start,partition+1,end);
        }
    }

    private static int getpartition(int[] array, int k, int start, int end) {
        int startindex= start;
        int middle = start;
        int endindex = end;
        int pivot = array[(start+end)/2];
        while (middle<=endindex){
            if(array[middle] == pivot){
                middle++;
            }
            if(array[middle]<pivot){
                swap(array,startindex,middle);
                startindex++;
                middle++;
            }
            if(array[middle]>pivot){
                swap(array,endindex,middle);
                endindex--;
            }
        }
        return startindex;
    }

    private static void swap(int[] array, int startindex, int middle) {
        int temp = array[startindex];
        array[startindex] = array[middle];
        array[middle] = temp;
    }
    static int findKthLargestQuickSelect(int nums[], int k){
        int start = 0;
        int end = nums.length-1;
        k = nums.length-k+1;
        return findKthSmallestQuick(start,end,nums,k);
    }
    static int findKthSmallestQuick(int start, int end, int nums[], int k){
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

    private static int partitionDutch(int []nums,int start,int end) {
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
