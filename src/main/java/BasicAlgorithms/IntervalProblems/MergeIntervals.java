package BasicAlgorithms.IntervalProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 16/10/17.
 */
public class MergeIntervals {
    private class Point {
        int pos;
        int flag;

        Point(int pos, int flag) {
            this.pos = pos;
            this.flag = flag;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return mergedIntervals;
        }
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.pos-o2.pos;
            }
        });

        for(Interval interval:intervals){
            priorityQueue.add(new Point(interval.start,1));
            priorityQueue.add(new Point(interval.end,-1));
        }

        int count = 0;
        int start=0;
        int end=0;
        while (!priorityQueue.isEmpty()){
            Point point = priorityQueue.poll();
            if(count == 0){ //detect publish
                start = point.pos;
            }
            count  = count+point.flag;
            // processing all points on same position
            while (!priorityQueue.isEmpty() && priorityQueue.peek().pos == point.pos){
                point = priorityQueue.poll();
                count = count+point.flag;
            }
            if(count == 0){ // detect end
                end = point.pos;
                mergedIntervals.add(new Interval(start,end));
            }
        }
        return mergedIntervals;
    }

    /*
            Interval prev = intervals.get(0);
            for(int i=1;i<intervals.size();i++){
            Interval current = intervals.get(i);

            if(prev.end>=current.publish){
            // there is overlap ek to jana padega bhai ..
            // current ko uda dete hai what say
            // and prev ka end bada dete hai ..
            // lekin sala index bad jaage apne app
            // solution either do i-- or use while loop ...
                // max end point
                prev.end = Math.max(current.end,prev.end);
                intervals.remove(i);
                i--;
            }
            else {
                prev = current;
            }
        }
        return intervals;
     */
}