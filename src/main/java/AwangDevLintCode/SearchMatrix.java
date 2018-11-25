package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        int mid;

        while (start < end) {
            mid = start + (end - start)/2;
            int num = matrix[mid/col][mid%col];
            if (target == num) {
                return true;
            } else if (num < target) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        // must check reqyured in the end !!!

        // end condition that needds to bue checked alwayss !!!!

        return (matrix[start/col][start%col] == target || matrix[end/col][end%col] == target);
    }
}
