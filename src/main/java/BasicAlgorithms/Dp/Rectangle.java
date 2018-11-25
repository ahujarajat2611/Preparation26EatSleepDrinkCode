package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 26/10/17.
 */
public class Rectangle {
    private int divideAndconquer(int[] heights, int L, int R) {
        if (L > R)
            return 0;

        int M = getMinIndex(heights, L, R);
        int area = heights[M] * (R-L+1);
        int leftArea = divideAndconquer(heights, L, M-1);
        int rightArea = divideAndconquer(heights, M+1, R);

        area = Math.max(leftArea, area);
        area = Math.max(rightArea, area);
        return area;
    }

    private int getMinIndex(int[] heights, int l, int r) {
        // Use Segment Tree to build the solution
        return 1;
    }
    private void buildMinIndex(int[] heights) {
        int n = heights.length;
        int [][]minIdx = new int[n][n];

        // Build minIdx arrary using DP
        for (int i = 0; i < n; i++)
            minIdx[i][i] = i;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;
                if (heights[j] < heights[minIdx[i][j-1]])
                    minIdx[i][j] = j;
                else
                    minIdx[i][j] = minIdx[i][j-1];
            }
        }
    }
}
