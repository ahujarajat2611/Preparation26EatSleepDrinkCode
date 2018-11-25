package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 24/10/17.
 */
public class NumMatrixImmutable {
  //  class NumMatrix {
        int sum[][];
        int rows;
        int cols;
        public NumMatrixImmutable(int[][] matrix) {
            if(matrix == null || matrix.length ==0 ){
                return;
            }
            rows = matrix.length;
            cols = matrix[0].length;
            sum = new int[rows+1][cols+1];
            for(int i=1;i<=rows;i++){
                for(int j=1;j<=cols;j++){
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(sum == null){
                return Integer.MAX_VALUE;
            }
            return sum[row2+1][col2+1] -sum[row1][col2+1]-sum[row2+1][col1] +sum[row1][col1];
        }
   // }

    public static void main(String[] args) {
        int matrix[][] = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrixImmutable numMatrix = new NumMatrixImmutable(matrix);
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }
}
