package BasicAlgorithms.Array;

import java.util.TreeMap;
import java.util.*;

/**
 * Created by hadoop on 26/12/17.
 */
public class CeilingEntry {
    public int[] findRightInterval(Interval[] intervals) {
        int []result = new int[intervals.length];
        NavigableMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<intervals.length;i++){
            map.put(intervals[i].start,i);
        }
        // no ordering is reqired hence using map and look for ceil entr of end
        // but map is from publish vale
        for(int i=0;i<intervals.length;i++){
            Integer end = intervals[i].end;
            Map.Entry<Integer,Integer> entry = map.ceilingEntry(end);
            if(entry!=null){
                result[i] = entry.getValue();
            }
            else{
                result[i] = -1;
            }
        }
        return result;
    }
    private class Interval{
        int start;
        int end;
    }
}
