package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
public class DataStream {

    public class SummaryRanges {

        /**
         * Use treemap, key is the publish of the Interval.
         */
        TreeMap<Integer, Interval> treeMap;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            if (treeMap.containsKey(val)) {
                return;
            }
            Integer lower = treeMap.lowerKey(val);
            Integer higher = treeMap.higherKey(val);

            // only three cases are possible
            // here
            // Mapping of startvalue to interval !!!
            // find lowerKey
            // higherKey
            // if lowekey.end +1 = val && val+1 = higher
            // if lowerkey.end+1 >val then just igore since already covered in the range
            // if(val+1 = higher then update higher's key value
            // but i guess that is very dificult //
            // rmeove higher and addd anitjer entry
            // else add value to the tree map

            if (lower != null && higher != null && treeMap.get(lower).end + 1 == val && higher == val + 1) {
                treeMap.get(lower).end = treeMap.get(higher).end;
                treeMap.remove(higher);
            } else if (lower != null && treeMap.get(lower).end + 1 >= val) {
                treeMap.get(lower).end = Math.max(treeMap.get(lower).end, val);
            } else if (higher != null && higher == val + 1) {
                treeMap.put(val, new Interval(val, treeMap.get(higher).end));
                treeMap.remove(higher);
            } else {
                treeMap.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(treeMap.values());
        }
    }
    private class Interval{
        int start;
        int end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    class SummaryRangesAgain {
        private List<Interval> Intervals;
        /** Initialize your data structure here. */
        public SummaryRangesAgain() {
            Intervals = new ArrayList<>();
        }

        public void addNum(int val) {
            Interval newInterval = new Interval(val, val);
            List<Interval> newIntervals = new ArrayList<>();
            int pos = 0;
            // its like addding interval to sorted interval

            for (Interval curr : Intervals) {
                if (curr.end + 1 < val) {
                    newIntervals.add(curr);
                    pos++;
                } else if (curr.start - 1 > val) {
                    newIntervals.add(curr);
                } else {
                    newInterval.start = Math.min(curr.start, newInterval.start);
                    newInterval.end = Math.max(curr.end, newInterval.end);
                }
            }
            newIntervals.add(pos, newInterval);
            Intervals = newIntervals;
        }

        public List<Interval> getIntervals() {
            return Intervals;
        }
    }
}
