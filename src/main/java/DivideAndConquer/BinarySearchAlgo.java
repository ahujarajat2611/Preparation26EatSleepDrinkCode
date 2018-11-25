package DivideAndConquer;

/**
 * Created by hadoop on 4/9/17.
 */
public class BinarySearchAlgo {
    public static void main(String[] args) {
        int []array = {2,5,6,10,12,14};
        int low = 0;
        int high = array.length-1;

//        int index = BinarySearch(array,low,high,8);
//        int indexmid = BinarySearchRecursive(array,low,high,8);
//        System.out.println("index"+index);
//        System.out.println("indexmid"+indexmid);
        BinarySearchAlgo b = new BinarySearchAlgo();
        int insert = b.binarySearchInsert(array,0,array.length-1,1);
        System.out.println("insert "+insert);
    }

    private static int BinarySearch(int[] array, int low, int high, int target) {

        while (low<=high){
            int mid = low + (high - low)/2;
            if(array[mid] == target){
                return mid;
            }
            else if(target<array[mid]){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return  -1;
    }
    private static int BinarySearchRecursive(int []array,int low,int high,int target){
        if(low >high ) return -1;

        int mid = (low + high )/2;

        if(array[mid] == target){
            return mid;
        }
        else if (target<array[mid]){
            return BinarySearchRecursive(array,low,mid-1,target);
        }
        else {
            return BinarySearchRecursive(array,mid+1,high,target);
        }
    }
    private static int binarySearchInsert(int array[],int low,int high,int target){

        while(low<high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < target) {
                low = mid+1;
            } else {
                high = mid;
            }
            }
            return high;
//            if(target <= array[low]){
//
//
//                return low;
//            }
//            else {
//                return low+1;
//            }

        }

    private int squareroot(int x){
        if(x == 0) return 0;
        int left = 1;
        int right = x;

        while (left<right){
            int mid = left + (right - left  )/2;

//            if(mid * mid <=x && x <(mid +1)* (mid +1)){
//                return  mid;
//            }

            if(mid * mid <x){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    private int searchRotatedrray(int array[], int low, int high, int target){
        while (low<high){

            int mid = low + (high-low/2);

            if(array[mid]<array[high]){
                if(array[mid]<target && target<=array[high]){
                    low = mid +1;
                }
                else {
                    high = mid;
                }

            }
            else {

                if(array[low]<=target && target<=array[mid]){
                    high = mid;
                }
                else {
                    low = mid +1;
                }
            }
        }
        if(array[low] == target) return low;
        return -1;
    }
    public int findMin(int[] nums) {
        int lo =0;
        int hi = nums.length-1;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] <=nums[hi]){
                if(nums[mid]<nums[hi]) {
                    hi = mid;
                }
                else {
                    hi--;
                }
            }
            else {
                lo = mid+1;
            }

        }
        return lo;
    }

}
