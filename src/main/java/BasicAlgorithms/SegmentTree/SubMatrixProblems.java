package BasicAlgorithms.SegmentTree;

import java.util.HashMap;

/**
 * Created by hadoop on 24/10/17.
 */
public class SubMatrixProblems {
    public static int maxSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int rowsum[] = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {

                for (int k = 0; k < matrix[0].length; k++) {
                    rowsum[k] = rowsum[k] + matrix[j][k];
                }

                max = Math.max(max, kadanesAlgo(rowsum));
            }
        }
        return max;
    }

    private static int kadanesAlgo(int[] rowsum) {
        int left[] = new int[rowsum.length];
        int currentmax = 0;
        int globalmax = 0;
        for (int i = 0; i < rowsum.length; i++) {
            if (i == 0) {
                left[i] = rowsum[i];
                currentmax = rowsum[i];
            } else {
                currentmax = Math.max(rowsum[i], currentmax + rowsum[i]);
                left[i] = Math.max(left[i - 1], currentmax);
            }
            globalmax = Math.max(globalmax, left[i]);
        }
        return globalmax;
    }
//    Submatrix Sum
//    Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.
//
//    Example
//    Given matrix
//
//            [
//	  [1 ,5 ,7],
//              [3 ,7 ,-8],
//              [4 ,-8 ,9],
//              ]
//              return [(1,1), (2,2)]
//
//    Challenge
//    O(n3) time.
//if max sum asked then kadan's approach if zero asked then this approach

    public int[][] submatrixSum(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[][]{};
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int sum[][] = new int[rows + 1][columns + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int row1 = 1;
        int col1 = 2;
        int row2 = 2;
        int col2 = 3;
        int sumsub = getSum(row1, col1, row2, col2, sum);
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j <= rows; j++) {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                hashMap.put(0, 0);
                for (int k = 1; k <= columns; k++) {
                    int diff = sum[j][k] - sum[i][k];
                    if (hashMap.containsKey(diff)) {
                        // please see why are we doing this ... with index
                        return new int[][]{{i, hashMap.get(diff)}, {j - 1, k - 1}};
                    }
                }
            }
        }
        return new int[][]{{}};
    }
    public int[][] submatrixSumEasyMethod(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[][]{};
        }
        for(int i=0;i<matrix.length;i++){
                int []cumulativeRow = new int[matrix[0].length];
            for(int j=i;j<matrix.length;j++){

                for(int k =0;k<matrix[0].length;k++){
                    cumulativeRow[k] = cumulativeRow[k] + matrix[j][k];
                }
                int []ans = getAnsFromOneD(cumulativeRow);
                if(ans!=null){
                    return new int[][]{{i,ans[0]},{j,ans[1]}};
                }
            }
        }
        return new int[][]{{}};
    }

    private int[] getAnsFromOneD(int[] cumulativeRow) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0;
        for(int i=0;i<cumulativeRow.length;i++){
            sum = sum +cumulativeRow[i];
            if(hm.containsKey(sum)){
                return new int[]{hm.get(sum)+1,i};
            }
            hm.put(sum,i);
        }
        return null;
    }


    private int getSum(int row1, int col1, int row2, int col2, int[][] sum) {
        return sum[row2 + 1][col2 + 1] + sum[row1][col1] - sum[row2][col1] - sum[row1][col2];
    }

    public static int[] sumZero(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum +nums[i];
            if(hm.containsKey(sum)){
                return new int[]{hm.get(sum)+1,i};
            }
            hm.put(sum,i);
        }
        return new int[]{};
    }
}