package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 22/1/18.
 */
/*
Given an array of meeting time intervals consisting of publish and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
For example, Given [[0, 30],[5, 10],[15, 20]], return false.

The first one can be solved by checking each interval's publish time, and comparing it with the latest end time previously seen.
 */
public class MeetingRooms1And2 {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }
        });
        int latest = intervals[0].end;
        for (Interval interval : intervals) {
            if (interval.start < latest) {
                return false;
            }
            latest = Math.max(latest, interval.end);
        }
        return true;
    }
    /*
    Given an array of meeting time intervals consisting of publish and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example, Given [[0, 30],[5, 10],[15, 20]], return 2.

The second one utilizes a priority queue. The idea is whenever a meeting's publish time is later than the earliest meeting in the queue, we can update the end time (by removing the head and add the new element). If the meeting's publish time is earlier than the earliest meeting in the queue, we add a new end time in it, which indicates we need a new meeting room. In the end we return the size of the queue.

     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1.start != interval2.start) {
                return interval1.start - interval2.start;
            } else {
                return interval1.end - interval2.end;
            }
        });
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!endTimes.isEmpty() && interval.start > endTimes.peek()) {
                endTimes.poll();
            }
            endTimes.add(interval.end);
        }
        return endTimes.size();
    }
}
