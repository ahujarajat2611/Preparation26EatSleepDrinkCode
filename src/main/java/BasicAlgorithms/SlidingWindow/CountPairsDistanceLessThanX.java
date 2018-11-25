package BasicAlgorithms.SlidingWindow;

import java.util.Arrays;

/**
 * Created by hadoop on 24/12/17.
 */
    /*
    import java.util.*;

/**
 * LeetCode 719 - Find K-th Smallest Pair Distance
 * <p>
 * Binary search + sliding window
 */
//public class _719 {
//
//    public int smallestDistancePair(int[] nums, int k) {
//        Arrays.sort(nums);
//        int left = 0, right = 1000000;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (leCnt(nums, mid) < k) {
//                left = mid + 1;
//            } else {
//                if (leCnt(nums, mid - 1) < k) return mid;
//                else right = mid - 1;
//            }
//        }
//        throw new RuntimeException("Should never reach here.");
//    }
//
//    /**
//     * Count # of pairs whose distance is less than or equal to x.
//     */
//    private int leCnt(int[] a, int x) {
//        int cnt = 0;
//        for (int l = 0, r = 0; r < a.length; r++) {
//            while (l < r && a[r] - a[l] > x) l++;
//            cnt += r - l;
//        }
//        return cnt;
//    }
//
//    public static void main(String[] args) {
//        _719 sol = new _719();
//
//        Random rand = new Random();
//        int[] a = new int[20];
//        for (int i = 0; i < a.length; i++)
//            a[i] = rand.nextInt(100);
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//
//        List<Integer> hehe = new ArrayList<>();
//        for (int i = 1; i <= 20 * 19 / 2; i++)
//            hehe.add(sol.smallestDistancePair(a, i));
//
//        List<Integer> expected = new ArrayList<>();
//        for (int i = 0; i < a.length; i++)
//            for (int j = i + 1; j < a.length; j++)
//                expected.add(Math.abs(a[i] - a[j]));
//        Collections.sort(expected);
//        System.out.println(hehe.equals(expected));
//    }
//}
//     */
// count the number of pairs whose distance is less than x

public class CountPairsDistanceLessThanX {
    static int countPairs(int a[], int n, int k)
    {
        // to sort the array.
        Arrays.sort(a);

        int res = 0;
        int start = 0;
        int newans = 0;
        while (start <a.length){
            int end = start+1;
            // Keep incrementing result while
            // subsequent elements are within
            // limits.
            while (end < n && a[end] - a[start] < k)
            {
                res++;
                end++;
            }
            newans = newans+end-1-start;
            start ++;
        }
        System.out.println("newans"+newans);
        return res;
    }

    static int countPairsMine(int a[], int n, int k)
    {
        // to sort the array.
        Arrays.sort(a);

        int res = 0;
        int start = 0;
        int newans = 0;
        int end=0;
        while (end <a.length){
            while (start<end && a[end]-a[start]>=k){
                start++;
            }
            res = res + end-start;
            end++;
        }

        System.out.println("newans"+newans);
        return res;
    }

    public static void main(String[] args) {
        int a[] = {1, 10, 4, 2};
        //1 2 4 10
        int k = 3;
        int n = a.length;
        System.out.println(countPairsMine(a, n, k));
    }
}