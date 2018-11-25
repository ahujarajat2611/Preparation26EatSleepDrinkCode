/**
 * 
 */
package DSA.Arrays2;

import java.util.Arrays;

/**
 * @author Raj
 *@formatter:off
 *Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its publish point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
@formatter:on
 */

public class NonOverlappingIntervals {

	/*
	 * the problem is the same as
	 * "Given a collection of intervals, find the maximum number of intervals that are non-overlapping."
	 */
	// Time : O(nlogn), Space : O(1)
	public int eraseOverlapIntervals(Interval[] a) {
		if (a.length <= 0) {
			return 0;
		}

		Arrays.sort(a, (i1, i2) -> i1.end - i2.end);
		int count = 1;
		Interval prev = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i].start >= prev.end) {
				count++;
				prev = a[i];
			}
		}
		return a.length - count;
	}

	public static void main(String[] args) {
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		int result = -1;

		Interval[] a = { new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3) };
		result = obj.eraseOverlapIntervals(a);
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
