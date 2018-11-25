package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
	Thoughts:
	Inspired by:http://stackoverflow.com/questions/5212037/find-the-pair-across-2-arrays-with-kth-largest-sum

	User a priority queue <Point[x,y]> and
	sort based on the smallest sum
	Add k-1 times into the heap.
	Each time poll the smallest and expand.
	Finally poll the top of the heap, which will be the smallest

	Note: There will be duplicates,
	so use a hashstet to mark duplicates.
	Becareful with what we put int hashset.
*/
import java.util.*;
public class KthSmallestSum {
    public class Point{
        int x,y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSmallestSum(int[] A, int[] B, int k) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || k < 0) {
            return -1;
        }
        PriorityQueue<Point> queue = new PriorityQueue<Point>(2, new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                return p1.val - p2.val;
            }
        });
        HashSet<String> set = new HashSet<String>();
        Point min = new Point(0, 0, A[0] + B[0]);
        queue.offer(min);
        set.add(min.x + "," + min.y);

        int n = A.length;
        int m = B.length;

        for (int i = 0; i < k - 1; i++) {
            min = queue.poll();

            if (min.x + 1 < n) {
                Point newP = new Point(min.x + 1, min.y, A[min.x + 1] + B[min.y]);
                if (!set.contains(newP.x + "," + newP.y)) {
                    set.add(newP.x + "," + newP.y);
                    queue.offer(newP);
                }
            }
            if (min.y + 1 < m) {
                Point newP = new Point(min.x, min.y + 1, A[min.x] + B[min.y + 1]);
                if (!set.contains(newP.x + "," + newP.y)) {
                    set.add(newP.x + "," + newP.y);
                    queue.offer(newP);
                }
            }
        }

        min = queue.poll();
        return min.val;
    }
}
