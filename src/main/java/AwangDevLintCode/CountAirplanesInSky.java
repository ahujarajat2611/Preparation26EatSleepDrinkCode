package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class CountAirplanesInSky {
    class Point {
        int x;
        int flag;
        public Point(int x, int flag) {
            this.x = x;
            this.flag = flag;
        }
    }

    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        // create point class assign start end + 1 -1
        // then process is as per increasing order in priority queue
        // make use of flag and count variable
        PriorityQueue<Point> queue = new PriorityQueue<Point>(10,
                new Comparator<Point>(){
                    public int compare(Point a, Point b) {
                        return a.x - b.x;
                    }
                });
        for (Interval interval : airplanes) {
            queue.offer(new Point(interval.start, 1));
            queue.offer(new Point(interval.end, -1));
        }
        int count = 0;
        int max = 0;
        // we have not sorted rather relyiing on queue
        // to process events as per increasing time order
        // then count based on flags ( of + and -ve )
        //
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            count+= p.flag;
            while (!queue.isEmpty() && queue.peek().x == p.x) {

                //It handles the case of
                // fly&&land @ same time. Which result in 1 -1 = 0.

                p = queue.poll();
                count += p.flag;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    private Comparator<Interval> startTimeComp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    };
    int count(List<Interval> airplanes){
        int ans=0;
        Collections.sort(airplanes,startTimeComp);
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        for(Interval interval:airplanes){
            while (!endTimeQueue.isEmpty() && interval.start>=endTimeQueue.peek()){
                endTimeQueue.poll();
            }
            endTimeQueue.add(interval.end);
            ans = Math.max(ans,endTimeQueue.size());
        }
        return ans;
    }

    private class Interval {
        int start;
        int end;
    }






    public int countOfAirplanesInSKy(List<Interval> airplanes) {
        int max = 0;
        int cur = 0;
        List<Event> events = new ArrayList<Event>();
        for (Interval airplane: airplanes){
            events.add(new Event(airplane.start, true));
            events.add(new Event(airplane.end, false));
        }
        Collections.sort(events);
        for(Event event: events){
            if (event.isDeparture){
                cur++;
            } else {
                cur--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }




    class Event implements Comparable<Event> {
        int time;
        boolean isDeparture;

        public Event(int time, boolean isDeparture){
            this.time = time;
            this.isDeparture = isDeparture;
        }

        @Override
        public int compareTo(Event that){
            if (this.time == that.time && this.isDeparture != that.isDeparture){
                if (!this.isDeparture){
                    // very very tricky
                    // if some plane is arrival we need to consider that
                    // first since we need to calcultae how many
                    // in the sky not how many paltforms required
                    // very very tricky1! cas e
                    return -1;
                } else {
                    // if it is
                    return 1;
                }
            }
            // increasing order
            return this.time - that.time;
        }
    }

}
