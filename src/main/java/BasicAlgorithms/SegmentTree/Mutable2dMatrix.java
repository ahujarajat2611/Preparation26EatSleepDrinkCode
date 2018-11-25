package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 24/10/17.
 */
public class Mutable2dMatrix {
    private int[][] colSums;
    private int[][] matrix;

    public Mutable2dMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        colSums = new int[matrix.length + 1][matrix[0].length];


        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i=row+1;i<=matrix.length;i++){
                colSums[i][col] = colSums[i][col] -matrix[row][col] +val;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum =0;
        for(int i=col1;i<=col2;i++){
            sum = sum + colSums[row2+1][i]-colSums[row1][i];
        }
        return sum;
    }
}