package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
import java.util.*;
class CustomComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}
/*
 TREEMAP could have been better choice since anyways we are required to soort the array

 */

public class SubarraySumClosest {
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
            // if not closest to zero then we need to take difference with that sum
            //
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

    public ArrayList<Integer> subarraySumClosestMine(int[] nums) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int prefixsum =0;
        treeMap.put(prefixsum,-1);
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            prefixsum = prefixsum + nums[i];
            System.out.println(prefixsum);
            Map.Entry<Integer,Integer> floor = treeMap.floorEntry(prefixsum);
            Map.Entry<Integer,Integer> ceil = treeMap.ceilingEntry(prefixsum);
            System.out.println(" floor "+floor);
            System.out.println(" ceil "+ceil);
            System.out.println("===");
            if(floor!= null){
                int floorSubArraySum = Math.abs(prefixsum-floor.getKey());
                if(diff>=Math.abs(floorSubArraySum)){
                    diff =  Math.abs(floorSubArraySum);
                    rst.clear();
                    // think why i did tht
                    rst.add(floor.getValue()+1);
                    rst.add(i);
                }
            }

            if(ceil!= null){
                int ceilSubarraySum = Math.abs(prefixsum-ceil.getKey());
                if(diff>= Math.abs(ceilSubarraySum)){
                    diff =  Math.abs(ceilSubarraySum);
                    rst.clear();
                    // think why i did tht
                    rst.add(ceil.getValue()+1);
                    rst.add(i);
                }
            }
            System.out.println(diff);
            treeMap.put(prefixsum,i);
        }
        return rst;
    }
    public ArrayList<Integer> subarraySumClosestTOkMine(int[] nums, int k ) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int prefixsum =0;
        treeMap.put(prefixsum,-1);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            prefixsum = prefixsum + nums[i];
            //System.out.println(prefixsum);
            Map.Entry<Integer,Integer> floor = treeMap.floorEntry(prefixsum-k);
            Map.Entry<Integer,Integer> ceil = treeMap.ceilingEntry(prefixsum-k);
        //    System.out.println(" floor "+floor);
         //   System.out.println(" ceil "+ceil);
         //   System.out.println("===");
            if(floor!= null){
                int floorSubArraySum = Math.abs(prefixsum-floor.getKey());
                if(diff>=Math.abs(floorSubArraySum-k)){
                    diff =  Math.abs(floorSubArraySum-k);
                    ans = floorSubArraySum;
                    rst.clear();
                    // think why i did tht
                    rst.add(floor.getValue()+1);
                    rst.add(i);
                }
            }

            if(ceil!= null){
                int ceilSubarraySum = Math.abs(prefixsum-ceil.getKey());
                if(diff>= Math.abs(ceilSubarraySum-k)){
                    diff =  Math.abs(ceilSubarraySum-k);
                    ans = ceilSubarraySum;
                    rst.clear();
                    // think why i did tht
                    rst.add(ceil.getValue()+1);
                    rst.add(i);
                }
            }
           // System.out.println(diff);
            treeMap.put(prefixsum,i);
        }
        System.out.println("ans is "+ans);
        return rst;
    }
    public  int closestToT(int[] x, int t){
        int prefix = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(prefix);
        int leastDiff = Integer.MAX_VALUE;

        for(int i : x){
            prefix += i; // the cumulative sum up to i

            int rest = prefix - t; // how far away we are from t
            if(set.first() <= rest){
                // check for nearest element prefix-t and prefix +t
                // we can deal with such things
                int theSum = prefix - set.floor(rest);
                leastDiff = Math.min(leastDiff, Math.abs(theSum - t));
            }

            if(set.last() >= rest){
                int theSum = prefix - set.ceiling(rest);
                leastDiff = Math.min(leastDiff, Math.abs(theSum - t));
            }
            set.add(prefix);
        }
        return leastDiff;
    }

    public static void main(String[] args) {
        SubarraySumClosest subarraySumClosest = new SubarraySumClosest();
        int ar []={-3, 1, -3, 1, 5};
        System.out.println(subarraySumClosest.subarraySumClosestTOkMine(ar,10));
        System.out.println(subarraySumClosest.closestToT(ar,10));
       // System.out.println(subarraySumClosest.subarraySumClosest(ar));
    }
}
