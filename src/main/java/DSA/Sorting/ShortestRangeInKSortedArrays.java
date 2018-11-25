/**
 * 
 */
package DSA.Sorting;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Raj
 *
 */
/*
 * http://algorithms.tutorialhorizon.com/shortest-range-in-k-sorted-lists/
 */
public class ShortestRangeInKSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ShortestRangeInKSortedArrays obj = new ShortestRangeInKSortedArrays();

		int res = -1;

		// int[][] a = new int[5][];
		// a[0] = new int[] { 1, 5, 8, 9 };
		// a[1] = new int[] { 2, 3, 7, 10 };
		// a[2] = new int[] { 4, 6, 11, 15 };
		// a[3] = new int[] { 9, 14, 16, 19 };
		// a[4] = new int[] { 2, 4, 6, 9 };

		// int[][] a = new int[3][];
		// a[0] = new int[] { 4, 10, 13, 14 };
		// a[1] = new int[] { 0, 9, 15, 18 };
		// a[2] = new int[] { 5, 18, 22, 30 };

		int[][] a = new int[3][];
		a[0] = new int[] { 4, 10, 15, 24, 26 };
		a[1] = new int[] { 0, 9, 12, 20 };
		a[2] = new int[] { 5, 18, 22, 30 };

		// int[][] a = new int[3][];
		// a[0] = new int[] { 3, 10, 15, 24 };
		// a[1] = new int[] { 0, 1, 2, 20 };
		// a[2] = new int[] { 1, 18, 21, 30 };

		// Time : O(nklogk), Space : O(nk)
		res = obj.mergeUsingHeap(a, a.length, a[0].length);
		System.out.println(res);
	}

	// using optimized method
	// n = number of cols, k = number of arrays or rows
	private int mergeUsingHeap(int[][] a, int k, int n) {

		int curMax = Integer.MIN_VALUE;
		int shortRange = Integer.MAX_VALUE;
		int ptr[] = new int[k];
		Comparator<HeapNode> comparator = new Comparator<HeapNode>() {
			@Override
			public int compare(HeapNode o1, HeapNode o2) {
				return o1.value-o2.value;
			}
		};
		PriorityQueue<HeapNode> heap = new PriorityQueue<>(comparator);
		for (int i = 0; i < k; i++) {
			if (ptr[i] < n) {
				heap.add(new HeapNode(a[i][ptr[i]], i));
				curMax = Math.max(curMax, a[i][ptr[i]]);
			} else {
				heap.add(new HeapNode(Integer.MAX_VALUE, i));
			}
		}

		int r, c, gMin = Integer.MAX_VALUE, gMax = Integer.MIN_VALUE;
		int res[] = new int[n * k];
		HeapNode temp;
		for (int i = 0; i < n * k; i++) {
			temp = heap.poll();
			res[i] = temp.value;
			ptr[temp.listNumber]++;

			if (shortRange > curMax - temp.value) {
				gMax = curMax;
				gMin = temp.value;
				shortRange = gMax - gMin;
			}

			r = temp.listNumber;
			c = ptr[temp.listNumber];

			if (ptr[temp.listNumber] < a[r].length) {
				heap.add(new HeapNode(a[r][c], r));
				curMax = Math.max(curMax, a[r][c]);
			} else {
				System.out.println("gMax=" + gMax + ",gMin=" + gMin + ",range=" + shortRange);
				return shortRange;
			}
		}

		System.out.println("gMax=" + gMax + ",gMin=" + gMin + ",range=" + shortRange);
		return shortRange;
	}
	private class HeapNode{
		int value;
		int listNumber;
		HeapNode(int value,int listNumber) {
			this.value = value;
			this.listNumber = listNumber;
		}
	}

}
