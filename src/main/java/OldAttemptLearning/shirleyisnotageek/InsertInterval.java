package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public class InsertInterval {
        public ArrayList<Interval> insert(ArrayList<Interval> Intervals, Interval newInterval) {
            ArrayList<Interval> rst = new ArrayList<Interval>();
            if (Intervals == null || newInterval == null)
                return Intervals;

            Collections.sort(Intervals, new IntervalComparator());
            int insert_pos = 0;
            // insert + merge
            // very nice technique
            // til now failed to do this way !!
            // keep this one inn mind !!
            for (Interval intv : Intervals)
            {
                if (intv.end < newInterval.start)
                {
                    rst.add(intv);
                    insert_pos++;
                }
                else if (intv.start > newInterval.end)
                    rst.add(intv);
                else
                {
                    newInterval.start = Math.min(intv.start, newInterval.start);
                    newInterval.end = Math.max(intv.end, newInterval.end);
                }
            }
            rst.add(insert_pos, newInterval);
            return rst;
        }
        private class IntervalComparator implements Comparator<Interval>
        {
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        }
}
