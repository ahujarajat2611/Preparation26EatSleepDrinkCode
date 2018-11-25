package DSA.Dp;

/**
 * Created by hadoop on 19/1/18.
 */
public class AndroidUnlockPatternsEasy {
    static int dfs2(boolean vis[], int[][] skip, int cur, int curLen, int totalLen) {
        if (curLen == totalLen)
            return 1;
        vis[cur] = true;
        int rst = 0;
        for (int i = 1; i <= 9; ++i) {
            // If vis[i] is not visited and (two numbers are adjacent or skip
            // number is already visited)
            if (!vis[i] && (skip[cur][i] == 0 || (vis[skip[cur][i]]))) {
                rst += dfs2(vis, skip, i, curLen + 1, totalLen);
            }
        }
        vis[cur] = false;
        return rst;
    }

    public static int numberOfPatterns2(int m, int n) {
        // Skip array represents number to skip between two pairs
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean vis[] = new boolean[10];
        int rst = 0;
        // DFS search each length from m to n
        for (int i = m; i <= n; ++i) {
            rst += dfs2(vis, skip, 1, 1, i) * 4; // 1, 3, 7, 9 are symmetric
            rst += dfs2(vis, skip, 2, 1, i) * 4; // 2, 4, 6, 8 are symmetric
            rst += dfs2(vis, skip, 5, 1, i); // 5
        }
        return rst;
    }
}
