package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class FindMaxNumberZerosOnes {
    /*
    Find the row with maximum number of 1s
2.7
Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

Example
Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2
     */
    public int findRowWithMax1s(int a[][], int m, int n) {
        int maxRow = -1;
        int j = n - 1;
        for (int i = 0; i < m; i++) {
            while (j >= 0 && a[i][j] == 1) {
                j--;
                maxRow = i;
            }
        }
        return maxRow;
    }

    public int findRowWithMax0s(int a[][], int m, int n) {
        int maxRow = -1;
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && a[i][j] == 0) {
                j++;
                maxRow = i;
            }
        }
        return maxRow;
    }
}
