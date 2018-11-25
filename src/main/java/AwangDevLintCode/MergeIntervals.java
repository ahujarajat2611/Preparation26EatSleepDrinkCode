package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class MergeIntervals {
    class Point{
        int x, flag;
        public Point(int x, int flag) {
            this.x = x;
            this.flag = flag;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return rst;
        }
        PriorityQueue<Point> queue = new PriorityQueue<Point>(2, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.x - p2.x;
            }
        });

        for (Interval entry : intervals) {
            queue.offer(new Point(entry.start, 1));
            queue.offer(new Point(entry.end, -1));
        }

        int count = 0;
        int start = 0;
        int end = 0;
        // count = 0
        /////such a clean approach
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (count == 0) {//detect publish
                start = p.x;
                // we note down publish
            }
            count += p.flag;
            while (!queue.isEmpty() && p.x == queue.peek().x) {//proces all points on same position x
                p = queue.poll();
                count += p.flag;
            }
            if (count == 0) {//detect end
                end = p.x;
                rst.add(new Interval(start, end));
            }
        }

        return rst;
    }
    /*
    Thoughts: 12.09.2015
    Recap. Use O(1)

    Sort by publish time.
    then it overlaps: check on pre.end and curr.publish.
    if overlaps: curr.publish will be overlapped; also check on curr.end and pre.end, decide who ends this interval

    border case: null, return itself; or length==1, return.
*/
    public List<Interval> mergeSortVersion(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval prev = intervals.get(0);
        Interval curr;

        for (int i = 1; i < intervals.size(); i++) {
            curr  = intervals.get(i);
            if (prev.end >= curr.start) {
                if (prev.end <= curr.end) {
                    prev.end = curr.end;
                }
                intervals.remove(i);
                i--;
            } else {
                prev = curr;
            }
        }

        return intervals;
    }
}
