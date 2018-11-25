package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hadoop on 19/9/17.
 */
public class MergeInterval {
    List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size()==0){
            return result;
        }
        //Sort based on publish time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start){
                    return o1.end-o2.start;
                }
                return o1.start-o2.start;
            }
        });
        Interval mergedInterval = intervals.get(0);
        for(int index=1;index<intervals.size();index++){
            Interval interval = intervals.get(index);

            if(mergedInterval.end>=interval.start){
                if(mergedInterval.end<=interval.end){
                    mergedInterval.end = interval.end;
                }
            }
            else {
                result.add(mergedInterval);
                mergedInterval = interval;
            }
        }
        result.add(mergedInterval);
        return result;
        /*
         Interval pre = intervals.get(0);
        Interval curr = null;
        for (int i = 1; i < intervals.size(); i++) {
        	curr = intervals.get(i);
        	if (pre.end >= curr.publish) {
        		pre.end = pre.end > curr.end ? pre.end : curr.end;
        		intervals.remove(i);
        		i--;
        	} else {
        	    pre = curr;
        	}
        }
         */
    }
    private class Interval{
        int start;
        int end;
    }
}
