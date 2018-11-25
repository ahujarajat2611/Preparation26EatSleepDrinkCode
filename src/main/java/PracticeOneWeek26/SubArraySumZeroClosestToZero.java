package PracticeOneWeek26;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 10/12/17.
 */
public class SubArraySumZeroClosestToZero {
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        //we know that sub-array (a,b) has zero sum if SUM(0 ... a-1) = SUM(0 ... b)
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                rst.add(map.get(sum) + 1);
                rst.add(i);
                return rst;
            }
            map.put(sum, i);
        }//for
        return rst;
    }
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return rst;
        }
        if (nums.length == 1) {
            rst.add(0); rst.add(0);
            return rst;
        }
        int[][] culmulate = new int[nums.length][2];
        culmulate[0][0] = nums[0];
        culmulate[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            culmulate[i][0] = culmulate[i - 1][0] + nums[i];
            culmulate[i][1] = i;
        }

        Arrays.sort(culmulate, new CustomComparator());
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = culmulate[i + 1][0] - culmulate[i][0];
            if (temp <= min) {
                min = temp;
                start = culmulate[i][1];
                end = culmulate[i + 1][1];
            }
        }
        if (start < end) {
            rst.add(start + 1);
            rst.add(end);
        } else {
            rst.add(end + 1);
            rst.add(start);
        }
        return rst;
    }
    private class CustomComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }
    private class point{
        int x;
        int y;
    }
//    Comparator<point> comparator = new Comparator<point>() {
//        @Override
//        public int compare(point o1, point o2) {
//            o1.x
//        }
//    }
    Comparator<point> comparator = new Comparator<point>() {
        @Override
        public int compare(point o1, point o2) {
            return 0;
        }
    };

}
