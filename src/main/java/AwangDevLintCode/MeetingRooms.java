package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class MeetingRooms{
    class Point {
        int pos, flag;
        public Point(int pos, int flag) {
            this.pos = pos;
            this.flag = flag;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {

    if (intervals == null || intervals.length == 0) {
        return 0;
    }

    PriorityQueue<Point> queue = new PriorityQueue<Point>(2, new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            return p1.pos - p2.pos;
        }
    });

        for (int i = 0; i < intervals.length; i++) {
        queue.offer(new Point(intervals[i].start, 1));
        queue.offer(new Point(intervals[i].end, -1));
    }
    int count = 0;
    int rst = 0;
        while (!queue.isEmpty()) {
        Point p = queue.poll();
        count += p.flag;
        while (!queue.isEmpty() && p.pos == queue.peek().pos) {
            p = queue.poll();
            count += p.flag;
        }
        rst = Math.max(count, rst);
    }

        return rst;
}
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        PriorityQueue<Point> queue = new PriorityQueue<Point>(2, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.pos - p2.pos;
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            queue.offer(new Point(intervals[i].start, 1));
            queue.offer(new Point(intervals[i].end, -1));
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            count += p.flag;
            while (!queue.isEmpty() && p.pos == queue.peek().pos) {
                p = queue.poll();
                count += p.flag;
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
