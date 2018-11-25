package OldAttemptLearning.VideoLectures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 28/8/17.
 */
public class MinimumMeetingRooms {
    private static class Interval{
        int start;
        int end;
    }

    public static void main(String[] args) {

    }
    public int minmeetingrooms(Interval [] intervals){
        if(intervals == null || intervals.length ==0){
            return 0;
        }
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        };
        Arrays.sort(intervals,comparator);
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });
        for ( int i=0;i<intervals.length;i++){
            if(queue.isEmpty()) {
                queue.add(intervals[i]);
            }
            else{
                // if we use WHile loop
                // then we need to keep track of max size
                // here we are maintaing all rooms
                Interval finishedMeetingTime = queue.poll();
                // there is overlap !!!
                if(intervals[i].start <finishedMeetingTime.end){
                    queue.add(intervals[i]);
                }
                else{

                    finishedMeetingTime.end = intervals[i].end;
                }
                queue.add(finishedMeetingTime);
            }
        }
        return queue.size();
    }
}
