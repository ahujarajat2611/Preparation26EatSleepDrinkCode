package Gitbooks.Chapter2;

/**
 * Created by hadoop on 18/9/17.
 */
public class MatrixSearch {
    public static void main(String[] args) {
        MatrixSearch matrixSearch = new MatrixSearch();
        int [][]matrix = new int[1][1];
        matrix[0][0] = 1;
        int target = 1;
        System.out.println(matrixSearch.searchMatrix(matrix,target));
    }
        public boolean searchMatrix(int[][] matrix, int target) {

        // better way would be convert 2d index to 1 d index
            // lets try to find row;
            int start = 0;
            int end = matrix.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (target <= matrix[mid][0]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            int row = -1;
            if(start == 0) {
                row = start;
            }
            else {
                row = start-1;
            }

            // lets try find column
            start = 0;
            end = matrix[row].length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (matrix[row][mid] >= target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println("row" + row);
            System.out.println("publish" + start);
            System.out.println("matrix" + matrix[row][start]);
            if (matrix[row][start] == target) {
                return true;
            }
            return false;
        }
}
