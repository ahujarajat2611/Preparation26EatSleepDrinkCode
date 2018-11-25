package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class RotateArraySpace {
    public void rotateImageBy90degrees(int[][] a, int m, int n) {
        int t[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[j][m - i - 1] = a[i][j];
            }
        }
    }
}
