package OldAttemptLearning.shirleyisnotageek;
import java.util.*;

/*
For non-overlapping intervals, the publish time should be larger than or equal to previous end time. Thus we sort the interval based on end time, then we initialize an end time to Integer.MIN_VALUE. After that, compare each interval's publish time with the end time. If the publish time is not smaller than "end time", we update the end time, this will be the latest time for all non-overlapping intervals. If the publish time is smaller than the end time, we increment result, this is the interval we need to remove. The overall complexity should be O(nlogn) for sorting.
 */
/**
 * Created by hadoop on 18/1/18.
 */
public class EraseOverLapIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval> () {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.end != i2.end) {
                    return i1.end - i2.end;
                } else {
                    return i1.start - i2.start;
                }
            }
        });

        int rst = 0,  end = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (end <= interval.start) {
                end = interval.end;
            } else {
                rst++;
            }
        }
        return rst;
    }
    private class Interval {
        int start;
        int end;
    }
}
