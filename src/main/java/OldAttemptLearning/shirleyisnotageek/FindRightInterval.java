package OldAttemptLearning.shirleyisnotageek;
import java.util.*;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Basically we need to sort the array, then for each interval, search all nodes to its right and find the first one that has publish greater than its end. Searching for the first "right" node can have multiple ways, the most efficient way is to use binary search. But the easiest way is, to just traverse the nodes to its right and find the first right node.

I used a structure to track the original index of the interval. Alternatively we can also do it by using maps.

 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int len = intervals.length;
        int[] rst = new int[len];
        if (len == 0) {
            return rst;
        }

        IntervalNode[] intervalNodes = new IntervalNode[len];
        int pos = 0;
        for (int i = 0; i < len; i++) {
            intervalNodes[pos++] = new IntervalNode(intervals[i], i);
        }

        Arrays.sort(intervalNodes, new Comparator<IntervalNode>() {
            @Override
            public int compare(IntervalNode in1, IntervalNode in2) {
                if (in1.interval.start != in2.interval.start) {
                    return in1.interval.start - in2.interval.start;
                } else {
                    return in1.index - in2.index;
                }
            }
        });
        for (int i = 0; i < len; i++) {
            IntervalNode curr = intervalNodes[i];
            int end = curr.interval.end;
            int j = i + 1;

            while (j < len && curr.interval.end > intervalNodes[j].interval.start) {
                j++;
            }
            rst[curr.index] = j == len ? - 1 : intervalNodes[j].index;
        }
        return rst;
    }

    private class IntervalNode {
        Interval interval;
        int index;

        public IntervalNode(Interval interval, int index) {
            this.interval = interval;
            this.index = index;
        }
    }
    private class Interval{
        int start;
        int end;
    }
}
