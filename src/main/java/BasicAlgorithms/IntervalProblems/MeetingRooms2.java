package BasicAlgorithms.IntervalProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 16/10/17.
 */
public class MeetingRooms2 {
    private class Point{
        int pos;
        int flag;
        Point(int pos,int flag){
            this.pos = pos;
            this.flag = flag;
        }
    }

    int meetingrooms(Interval[] intervals){


        if(intervals == null || intervals.length==0){
            return 0;
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
        int maxmeetingrooms=0;
        while (!priorityQueue.isEmpty()){
            Point point = priorityQueue.poll();
            count = count+point.flag;
            while (!priorityQueue.isEmpty() && point.pos == priorityQueue.peek().pos){
                Point point1 = priorityQueue.poll();
                count = count +point1.flag;
            }
            maxmeetingrooms = Math.max(maxmeetingrooms,count);
        }
        return maxmeetingrooms;
    }

}
