package AwangDevLintCode;

/**
 * Created by hadoop on 23/2/18.
 */
import java.util.*;
public class CountAirplanesInSkyBetter {
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int ans=0;
        Collections.sort(airplanes,startTimeComp);
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        for(Interval interval:airplanes){
            if (!endTimeQueue.isEmpty() && interval.start>=endTimeQueue.peek()){
                endTimeQueue.poll();
            }
            endTimeQueue.add(interval.end);
            //ans = Math.max(ans,endTimeQueue.size());
        }
        return endTimeQueue.size();
    }
    private Comparator<Interval> startTimeComp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    };
}
