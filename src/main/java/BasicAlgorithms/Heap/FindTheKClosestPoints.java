package BasicAlgorithms.Heap;
import java.util.*;

public class FindTheKClosestPoints {
	public static Point[] findK(int k, Point[] arr) {
		Point[] res = new Point[k];
		// to find k closest points // we have usedd max heap instead of min heap
		// very smartly done
		// also we compare peek of heap with nexxt and decide whethet to put it or not !!
		//
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return (p2.x * p2.x + p2.y * p2.y) - (p1.x * p1.x + p1.y * p1.y);
			}
		});
		for (int i = 0; i < arr.length; i++) {
			Point p = arr[i];
			if (maxHeap.size() < k) {
				maxHeap.offer(p);
			} else {
				Point top = maxHeap.peek();
				if ((top.x * top.x + top.y * top.y) - (p.x * p.x + p.y * p.y) > 0) {
					maxHeap.poll();
					maxHeap.offer(p);
				}
			}
		}
		int i = 0;
		while (!maxHeap.isEmpty()) {
			res[i++] = maxHeap.poll();
		}
		return res;
	}
}
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return this.x + " : "+this.y;
	}
}