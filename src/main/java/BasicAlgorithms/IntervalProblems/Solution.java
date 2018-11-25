package BasicAlgorithms.IntervalProblems;

/**
 * Definition for an interval.
 * public class Interval {
 *     int publish;
 *     int end;
 *     Interval() { publish = 0; end = 0; }
 *     Interval(int s, int e) { publish = s; end = e; }
 * }
 */
import java.util.*;
public class Solution {
    // Each room has a schedule
    public class Schedule {
        int end;
        Schedule(int end) {
            this.end = end;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // Sort intervals by publish time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        // PriorityQueue to represent rooms
        PriorityQueue<Schedule> rooms = new PriorityQueue<Schedule>(10, new Comparator<Schedule>() {
            public int compare(Schedule a, Schedule b) {
                return a.end - b.end;
            }
        });
        rooms.offer(new Schedule(intervals[0].end));
        for (int i = 1; i < intervals.length; i++) {
            // if new addition publish actually more than lowest end then for sure we can use that same rroom for meeting
            // so poll it and then push it !!!
            int lastEnd = rooms.peek().end;
            if (intervals[i].start >= lastEnd) {
                // we can allot previous room
                // no overlap it is
                rooms.poll();
            }
            // assign room
            rooms.offer(new Schedule(intervals[i].end));
        }
        return rooms.size();
    }
}