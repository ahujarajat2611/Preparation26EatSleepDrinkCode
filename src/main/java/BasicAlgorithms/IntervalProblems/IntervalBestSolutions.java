package BasicAlgorithms.IntervalProblems;
import java.util.*;

/**
 * Created by hadoop on 5/1/18.
 */
public class IntervalBestSolutions {
    class Solution {
        /**
         * @param intervals: Sorted interval list.
         * @return: A new sorted interval list.
         */
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals == null || intervals.isEmpty()) return intervals;

            List<Interval> result = new ArrayList<Interval>();
            // sort with Comparator
            Collections.sort(intervals, new IntervalComparator());
            Interval prev = intervals.get(0);
            for (Interval interval : intervals) {
                if (prev.end < interval.start) {
                    // no fucking overlap
                    // add to mergedlist( which is new )
                    result.add(prev);
                    prev = interval;
                } else {
                    // there is overlapped caseeeeeeee
                    // there is overlap so
                    // taj=ke min from prev and current
                    // take max from prev and current
                    prev.start = Math.min(prev.start, interval.start);
                    prev.end = Math.max(prev.end, interval.end);
                }
            }
            // must at the end add prev intervval as well
            result.add(prev);

            return result;
        }

        private class IntervalComparator implements Comparator<Interval> {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }

    }
}
