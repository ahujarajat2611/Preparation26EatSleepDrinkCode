package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
/*
Zig zag matrix we pick first element in our result
and then decide whether i can go down or right . move
then normal diagonal iteration
// make sure you dont go out of loop so we are using i-1, j+1 techiqieue

in other direction decide whether i can go right or move down
and then same diagonal movemenet
 */
public class ZigZagMatrix {
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
}
