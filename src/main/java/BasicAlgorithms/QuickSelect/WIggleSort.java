package BasicAlgorithms.QuickSelect;

/**
 * Created by hadoop on 17/10/17.
 */
public class WIggleSort {
    // median is alwayss (n.lengtg+1)/2;
    // since we have written function to find kth largest element
    // better be median like n.length+1/2
    public void wiggleSort(int[] nums) {
        if (nums.length == 0) return;
//        for(int i:nums){
//            System.out.print(i);
//        }
//        System.out.println();
        int median = findKthLargest(nums, (nums.length + 1) / 2);
//        for(int i:nums){
//            System.out.print(i);
//        }
        System.out.println();
        int odd = nums.length %2 == 1 ? nums.length - 2 : nums.length - 1;
        int even = nums.length % 2 == 0? nums.length - 2 : nums.length - 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > median) {
              //  System.out.println("entry here odd"+nums[i]);
                temp[odd] = nums[i];
                odd -= 2;
            }
            else if (nums[i] < median) {
               // System.out.println("entry here even"+nums[i]);
                temp[even] = nums[i];
                even -= 2;
            }
        }
        while (odd >=1) {
            temp[odd] = median;
            odd -= 2;
        }
        while (even>=0) {
            temp[even] = median;
            even -= 2;
        }
//        for(int i:temp){
//            System.out.print(i);
//        }
//        System.out.println();
        for (int i = 0; i < nums.length; i++) nums[i] = temp[i];
//        for(int i:nums){
//            System.out.print(i);
//        }
//        System.out.println();
    }

    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        //(n+1)/2
        return quickSelect(a, 0, n - 1, n - k + 1);
    }

    public int quickSelect(int[] a, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);

        int m = i - lo + 1;
        if (m == k) return a[i];
        else if (m > k) return quickSelect(a, lo, i - 1, k);
        else return quickSelect(a, i + 1, hi, k - m);
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        WIggleSort wIggleSort = new WIggleSort();
        wIggleSort.wiggleSort(new int[]{1, 2, 3, 4, 5, 6});
    }
}
