package BasicAlgorithms.Array;

/**
 * Created by hadoop on 11/10/17.
 */
public class ZigZag {
    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int result[] = zigzag(matrix);
        for (int x : result) {
            System.out.print(x);
        }
    }

    static int[] zigzag(int[][] matrix) {
        int r = 0;
        int c = 0;

        int endrow = matrix.length;
        int endcol = matrix[0].length;
        int count = 0;
        int total = endrow * endcol;
        int ans[] = new int[total];
        while (count < total) {
            // see the reason why we operated with r-1 and c+1;
            while (count < total && r - 1 >= 0 && c + 1 < endcol) {
                ans[count++] = matrix[r--][c++];
            }
            if (count < total && c + 1 < endcol) {
                ans[count++] = matrix[r][c++];
            } else if (count < total) {
                ans[count++] = matrix[r++][c];
            }

            while (count < total && r + 1 < endrow && c - 1 >= 0) {
                ans[count++] = matrix[r++][c--];
            }
            if (count < total && r + 1 < endrow) {
                ans[count++] = matrix[r++][c];
            } else if (count < total) {
                ans[count++] = matrix[r][c++];
            }
        }
        return ans;
    }

    public int[] printZMatrix(int[][] matrix) {
        int[] rst = null;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return rst;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        rst = new int[n * m];
        if (matrix.length == 1) {
            return matrix[0];
        }
        int i = 0, j = 0;
        int ind = 0;
        rst[ind] = matrix[i][j];
        ind++;
        while (ind < rst.length) {
            //Right 1 step, or down
            if (j + 1 < m || i + 1 < n) {
                if (j + 1 < m) j++;
                else if (i + 1 < n) i++;
                rst[ind++] = matrix[i][j];
            }
            //Move left-bottom:
            while (j - 1 >= 0 && i + 1 < n) {
                rst[ind++] = matrix[++i][--j];
            }
            //Move down, or right
            if (j + 1 < m || i + 1 < n) {
                if (i + 1 < n) i++;
                else if (j + 1 < m) j++;
                rst[ind++] = matrix[i][j];
            }
            //Move right-up:
            while (j + 1 < m && i - 1 >= 0) {
                rst[ind++] = matrix[--i][++j];
            }
        }//end while
        return rst;
    }

    public int[] printZMatrixAgain(int[][] matrix) {
        int i=0;
        int j =0;
        int ind=0;
        int []res = new int[matrix.length * matrix[0].length];
        res[ind++] = matrix[i][j];
        int n = matrix.length;
        int m = matrix[0].length;

        while (ind<matrix.length*matrix[0].length){

            // move right or down
            if(j+1<n || i+1 <m){
                if(i+1 <n){
                    i++;
                }
                else if(j+1<m){
                   j++;
                }
                res[ind++] = matrix[i][j];
            }
            while (i+1<n && j-1>=0){
                res[ind++] = matrix[++i][--j];
            }
            // move right or down
            if(j+1<n || i+1 <m){
                if(j+1 <m){
                    j++;
                }
                else if(i+1<n){
                    i++;
                }
                res[ind++] = matrix[i][j];
            }
            while (j + 1 < m && i - 1 >= 0) {
                res[ind++] = matrix[--i][++j];
            }

        }
        return res;
    }
}