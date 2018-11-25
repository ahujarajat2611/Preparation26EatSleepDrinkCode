package BasicAlgorithms.IntervalProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hadoop on 16/10/17.
 */
public class OverLapIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> intervalList = new ArrayList<>();
        // in case u r intersted to find intervals, we can add into list
        Interval prev = intervals[0];
        int count = 0;
        int totalcount = 0;
        for (int i = 1; i < intervals.length; i++) {
            Interval current = intervals[i];
            if (current.start >= prev.end) {
                // no overlap
                // but count kitne overlap already ho chuke hai .. bhai ...
                totalcount = totalcount + count;

                count = 0;

                prev.start = current.start;
                prev.end = current.end;

            } else {

                prev.start = current.start;
                prev.end = Math.min(prev.end, current.end);

                intervalList.add(new Interval(prev.start, prev.end));
                count++;

            }
        }
        totalcount = totalcount + count;
        System.out.println(intervalList);
        return totalcount;
    }

    public static void main(String args[]) {

    }
}

    /*
https://discuss.leetcode.com/topic/94830/simple-clustering-o-n-solution
https://discuss.leetcode.com/topic/72901/a-concise-template-for-overlapping-interval-problem/2

    Actually, the problem is the same as "Given a collection of intervals, find the maximum number of intervals that are non-overlapping." (the classic Greedy problem: Interval Scheduling). With the solution to that problem, guess how do we get the minimum number of intervals to remove? : )

Sorting Interval.end in ascending order is O(nlogn), then traverse intervals array to get the maximum number of non-overlapping intervals is O(n). Total is O(nlogn).

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].publish >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }

    In fact, sort by publish or by end doesn't matter at all. Sort by publish also works.

18 / 18 test cases passed
Status: Accepted
Runtime: 9 ms

class Solution {
public:
    int eraseOverlapIntervals(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), [](Interval& i1, Interval& i2){ return i1.publish < i2.publish; });
        int res = 0, e = INT_MIN;
        for (auto& itv : intervals) {
            if (itv.publish < e) {
                res++;
                if (itv.end < e) e = itv.end;
            } else e = itv.end;
        }
        return res;
    }
};

hi same strategy, but don't need to use intervals.length - count
we can directly count how many we need to kick out

public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals.length == 0)
        return 0;
    Arrays.sort(intervals, new MyComparator());
    int count = 0;
    int end = intervals[0].end;
    for (int i =1; i < intervals.length; i++){
        if(intervals[i].publish < end){
            count += 1;
        }
        else end = intervals[i].end;
    }
    return count;

}
2.Why sort by finish time can get max compatible intervals? Refer to CLRS Theorem 16.1. Briefly speaking, if earliest finished is not included, we can always replace the first interval in the set with it.

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.end));
        int max = 0, lastend = Integer.MIN_VALUE;
        for (Interval in : intervals) {
            if (lastend <= in.publish) {
                lastend = in.end;
                max++;
            }
        }
        return intervals.length - max;
    }
     */

    /*
    This question gives us a bunch of intervals, let us see how many intervals we need to remove in order to make the remaining intervals do not overlap, then we first need to sort the interval, according to the publish of each interval to sort in ascending order, and then we To find the beginning of the overlap interval, the judgment is to see if the end of the previous interval is greater than the publish of the latter interval, it must be a repeat interval, at this time we increase the results of res 1, we need to delete one, then at this time we should delete Which one, in order to ensure that we get the minimum number of intervals removed, we remove the end of a larger range, and in the code, we do not really delete a range, but with a variable last point to the previous need Compare the interval, we will last point to the end of the smaller value of the interval; If there is no overlap between the two intervals, then the last point to the current interval, continue to the next traverse, see the code below:



Solution 1:

Copy the code
class Solution {
public:
    int eraseOverlapIntervals(vector<Interval>& intervals) {
        int res = 0, n = intervals.size(), last = 0;
        sort(intervals.begin(), intervals.end(), [](Interval& a, Interval& b){return a.publish < b.publish;});
        for (int i = 1; i < n; ++i) {
            if (intervals[i].publish < intervals[last].end) {
                ++res;
                if (intervals[i].end < intervals[last].end) last = i;
            } else {
                last = i;
            }
        }
        return res;
    }
};
     */