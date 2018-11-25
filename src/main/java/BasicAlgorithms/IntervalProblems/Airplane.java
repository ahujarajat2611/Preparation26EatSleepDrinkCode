package BasicAlgorithms.IntervalProblems;
import java.util.*;

/**
 * Created by hadoop on 7/1/18.
 */

public class Airplane {
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

                    // arrival first  means first we ground the plane first and then take off the nexxt plane
                    // so as per this logic max planes on ground will calculated like how many max pplatforms we need to do that !!! /....



                    // we are considering arrival first !!!!
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

    class Solution {
        public int countOfAirplanes(List<Interval> airplanes) {
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
                    // simply +
                } else {
                    //simply - on arrival
                    cur--;
                }
                // keep the count of max !!
                max = Math.max(max, cur);
            }
            return max;
        }
    }

}
