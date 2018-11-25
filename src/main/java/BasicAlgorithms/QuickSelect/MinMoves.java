package BasicAlgorithms.QuickSelect;

/**
 * Created by hadoop on 16/10/17.
 */
public class MinMoves {
    // min moves would be to get median and find the diff from the median
    // that would be your answer !!!
    public int minMoves2(int[] nums) {
        int median = getmedian(nums);
        int moves = 0;
        for(int i=0;i<nums.length;i++){
            moves = moves+Math.abs(nums[i]-median);
        }
        return moves;
    }
    private int getmedian(int[] nums) {
        return quickSelect(nums,0,nums.length-1,nums.length/2+1);
    }

    private int quickSelect(int []nums, int lo, int hi, int k) {
        if(lo>hi){
            return -1;
        }
        int partitionindex = dutchpartition(nums,lo,hi);
        System.out.println("par"+partitionindex);
        int size =partitionindex-lo+1;
        if(size == k){
            return nums[partitionindex];
        }
        else if(size<k){
            return quickSelect(nums,partitionindex+1,hi,k-size);
        }
        else {
            return quickSelect(nums,lo,partitionindex-1,k);
        }

    }

    private int dutchpartition(int[] nums, int lo, int hi) {
        int start = lo;
        int high = hi;
        int middle = lo;
        int pivot = nums[(lo+hi)/2];
        while(middle<=high) {
            if (nums[middle] > pivot) {
                swap(nums, middle, high);
                high--;
            } else if (nums[middle] < pivot) {
                swap(nums, start, middle);
                start++;
                middle++;
            } else {
                middle++;
            }
        }
        return start;
    }

    void swap(int[] array, int startindex, int middle) {
        int temp = array[startindex];
        array[startindex] = array[middle];
        array[middle] = temp;
    }
    public static void main(String args[]){
        MinMoves minMoves = new MinMoves();
        System.out.println(minMoves.getmedian(new int[]{1,2,3}));
        System.out.println(minMoves.minMoves2(new int[]{1,2,3}));

    }
}
