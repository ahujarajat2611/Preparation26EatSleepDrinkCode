package BasicAlgorithms.IntervalProblems;
import java.util.*;

public class AbsentMeetingInterval {

    public List<Interval> absentInterval(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        // Task is to find all absent intervlas

        // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;


        // Usual process in such quesiotns
        // sort by publish and take prev counter to deal with things !!!
        for (Interval interval : intervals) {
            if (interval.start <= end) { // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            } else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(end, interval.start));
                start = interval.start;
                // actually required only for the last case
                // so keep
                end = interval.end;
            }
        }

        // Add the last interval
        // actually not required
        // i think you dont need to add the prev things into the input !!!
        result.add(new Interval(start, end));
        return result;
    }
}