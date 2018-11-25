package AwangDevLintCode;

/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

    * Integers in each row are sorted from left to right.

    * Integers in each column are sorted from up to bottom.

    * No duplicate integers in each row or column.

Example
Consider the following matrix:

[

    [1, 3, 5, 7],

    [2, 4, 7, 8],

    [3, 5, 9, 10]

]

Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space

*/
/**
 * Created by hadoop on 8/2/18.
 */
/*
    Thoughts: 11.29.2015. LintCode updated. Practice again.
    Understand that:
    1. Each row has exactly 1 instance of that integer, no duplicates.
    2. Each row begins with smallest number. So, if matrix[x][y] < target, first thing to do is x++.
    3. Each col ends with largest number. So if matrix[x][y] > target,
        (no need to care x++ since it's alreay too large for this row), then simply just y--.
    4. If match, next step will be x--,y++.
        x-- because it has to change a row;
        y++ because [x-1, y] can't be the target since no duplicate in column
    Beneftis of going from bottown-left: No matter which condition, always have 1 possible way to move.
*/
public class SearchMatrixRowColumnSorted {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1;
        int y = 0;
        int count = 0;
        while (x >= 0 && y < col) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {//matrix[x][y] == target
                // if equal in both direction !!
                // go in both dirrection onc eyo meet target
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}
