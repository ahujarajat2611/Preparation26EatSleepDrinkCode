package BasicAlgorithms.Array;

import java.util.*;
/**
 * Created by hadoop on 23/12/17.
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
    private class Interval{
        int start;
        int end;
    }
    /*
      public int[] findRightInterval(Interval[] intervals) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int[] res = new int[intervals.length];
            for(int i=0;i<intervals.length;i++) map.put(intervals[i].publish, i);
            for(int i=0;i<intervals.length;i++) {
                Integer key = map.ceilingKey(intervals[i].end);
                res[i] = key!=null ?map.get(key) : -1;
            }
            return res;
        }


     */
    /*
    Correct me if I am wrong.
Given that, you are using a treemap, which derived from Map. if you put the same key with a different value it will replace the original one with the newer one. In such case, if you have case like
[[4,6],[1,2],[4,8]]
the correct answer should be
[-1,0,-1]

However, the answer you provide will give
[-1,2,1]

Because in the treeMap the [4,8] will store as 4->2 ,which replace the
previously inserted [4,6] stored as 4->0 for the Map property.

Anyway, you guys show me how to use treemap, still be a brilliant solution.

Updated:
Here attached my edited code which can fix this problem while passing all the test case.

     */
/*
 public int[] findRightInterval(Interval[] intervals) {
         TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
         int[] res = new int[intervals.length];
         for(int i=0;i<intervals.length;i++){
        	 if(map.get(intervals[i].publish)==null){
        		 PriorityQueue<Integer> pq=new PriorityQueue<>();
        		 pq.add(i);
        		 map.put(intervals[i].publish, pq);
        	 }
        	 else{
        		 map.get(intervals[i].publish).add(i);
        	 }
         }
         for(int i=0;i<intervals.length;i++) {
             Integer key = map.ceilingKey(intervals[i].end);
             res[i] = key!=null ?map.get(key).peek() : -1;
         }
         return res;
     }
 */
/*
Amazing use of TreeMap! I didn't think about TreeMap so I did the dirty work on my own.
Compared with my solution, we can observe that TreeMap saved a lot of work as follows:
Thank for your sharing!

1.Sort: key is sorted by publish "automatically"
2.Satellite data: Meanwhile value is used to save original index as satellite
3.Out-of-box successor API: ceilingEntry() return successor, particularly the least key >= the given key or null if there is no such key.


 */
    public int[] findRightIntervalAgainBinarySearch(Interval[] ints) {
        if (ints.length == 0) return new int[0];

        // Sort intervals in publish point and save original index
        int n = ints.length;
        Interval[] nints = Arrays.copyOf(ints, n);
        Arrays.sort(nints, Comparator.comparingInt(i -> i.start));
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < ints.length; i++) idx.put(ints[i].start, i);

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) { // Essentially, find closest publish point to ints[i].end
                int m = l + (r - l) / 2;
                if (ints[i].end > nints[m].start) l = m + 1; // m is too small
                else r = m; // m is larger or equal, so keep m (it's OK: l=r-1 -> m=l -> l=r)
            }
            ret[i] = (ints[i].end <= nints[l].start) ? idx.get(nints[l].start) : -1; /* l==r */
        }
        return ret;
    }
}
