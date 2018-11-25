package BasicAlgorithms.BinarySearchTechnique;

/**
 * Created by hadoop on 8/1/18.
 */
public class KthElementInMatrix {
    // return # of elements in a that are <= x
    private int rank(int[][] a, long x) {
        int rank = 0;
        int i = a.length - 1, j = 0;
        while (i >= 0 && j < a[0].length) {
            if (a[i][j] <= x) {
                rank += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return rank;
    }

    public int kthSmallest(int[][] matrix, int k) {
        long left = Integer.MIN_VALUE;
        long right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (rank(matrix, mid) >= k) right = mid;
            else left = mid;
        }
        return (int) right;
    }

}

/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 */