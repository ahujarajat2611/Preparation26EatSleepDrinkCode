package BasicAlgorithms.IntervalProblems;
import java.util.*;

public class CeilingEntry {
    public int[] findRightInterval(Interval[] intervals) {
        int []result = new int[intervals.length];
        NavigableMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<intervals.length;i++){
            // map of publish andd index
            map.put(intervals[i].start,i);
            // map of publish and index of that publish // key value pair !!!
        }
        for(int i=0;i<intervals.length;i++){
            // take end of each interval and find the ceil entry based on the end time in the map generated based on publish!!!
            Integer end = intervals[i].end;
            // we will search based on end time .. very imp
            // if entry is not null // we found result else -1
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