package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 21/9/17.
 */
public class Airplanes {
    private Comparator<Interval> startTimeComp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    };
    int count(List<Interval> airplanes){
        int ans=0;
        Collections.sort(airplanes,startTimeComp);
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        for(Interval interval:airplanes){
            while (!endTimeQueue.isEmpty() && interval.start>=endTimeQueue.peek()){
                endTimeQueue.poll();
            }
            endTimeQueue.add(interval.end);
            ans = Math.max(ans,endTimeQueue.size());
        }
        return ans;
    }

    private class Interval {
        int start;
        int end;
    }
}
