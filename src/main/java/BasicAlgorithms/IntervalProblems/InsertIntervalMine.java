package BasicAlgorithms.IntervalProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 28/2/18.
 */
public class InsertIntervalMine {
    public List<Interval> insertMine(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() ==0){
            intervals.add(newInterval);
            return intervals;
        }
        int insertpos = -1;

        int i=0;
        while (i<intervals.size()){
            if(intervals.get(i).start<newInterval.start){
                i++;
            }
            else {
                insertpos =i;
                break;
            }
        }
        if(insertpos == -1){
            intervals.add(newInterval);
        }
        else {
            intervals.add(insertpos,newInterval);
        }

        Interval prev = intervals.get(0);

        List<Interval> myans = new ArrayList<>();
        for(int k =1;k<intervals.size();k++){
            Interval curr = intervals.get(k);
            if(curr.start<=prev.end){ //overlap
                prev.end = Math.max(curr.end,prev.end);
            }
            else{
                myans.add(prev);
                prev = curr;
            }
        }
        myans.add(prev);
        return myans;
    }
}
