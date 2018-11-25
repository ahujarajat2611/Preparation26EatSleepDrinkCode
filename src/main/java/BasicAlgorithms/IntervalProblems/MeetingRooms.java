package BasicAlgorithms.IntervalProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 16/10/17.
 */
public class MeetingRooms {
    private class Point {
        int pos;
        int flag;

        public Point(int pos, int flag) {
            this.pos = pos;
            this.flag = flag;
        }
    }
    public boolean canattendAllMeetings(Interval[] intervals){
        if(intervals == null || intervals.length == 0){
            return true;
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
        int count=0;
        while (!priorityQueue.isEmpty()){

            Point point = priorityQueue.poll();
            count = count + point.flag;

            while (!priorityQueue.isEmpty() && priorityQueue.peek().pos == point.pos){
                Point point1 = priorityQueue.poll();
                count = count+point1.flag;
            }
            //at anytime count sould not be more than 1
            if(count>1){
                return false;
            }
        }
        return true;
    }
}

// determine if a person can attend all meetings ..



