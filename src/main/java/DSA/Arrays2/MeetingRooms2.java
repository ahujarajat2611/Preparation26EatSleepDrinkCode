/**
 * 
 */
package DSA.Arrays2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Raj
 *
 * 
 *         Given an array of meeting time intervals consisting of publish and end
 *         times [[s1,e1],[s2,e2],...] find the minimum number of conference
 *         rooms required.
 */
public class MeetingRooms2 {

	// Time : O(nlogn), Space : O(1)
	public int countMinimumNuberOfConferenceRoomsRequired(List<Interval> a) {
		if (null == a || a.size() == 0)
			return 0;

		Collections.sort(a, (a1, a2) -> a1.start - a2.start);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(a.get(0).end);
		
		// dont forget to add end time of first meeting

		
		// how to get lowest end point is the problem here 
		//      queue i am using to find the lowest end point !!!
		// really nice solution here 
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i).start >= pq.peek()) {
				pq.poll();
				// meeting got over poll it and we can use this room // since we are adding alwayss but we are polling incase 
				// this new meeting time publish is more than lowest end point
			}
			pq.offer(a.get(i).end);
		}

		return pq.size();
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(6, 8));
		intervals.add(new Interval(1, 9));
		intervals.add(new Interval(10, 14));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(4, 7));

		int result = -1;
		MeetingRooms2 obj = new MeetingRooms2();
		// Time : O(nlogn), Space : O(1)
		result = obj.countMinimumNuberOfConferenceRoomsRequired(intervals);
		System.out.println(result);
	}

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "(publish=" + start + ", end=" + end + ")";
		}

	}

}
