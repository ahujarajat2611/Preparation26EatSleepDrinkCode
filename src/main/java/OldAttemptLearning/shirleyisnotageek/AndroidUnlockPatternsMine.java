package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 4/3/18.
 */
public class AndroidUnlockPatternsMine {
    public static int numberOfPatterns2(int m, int n) {
        // Skip array represents number to skip between two pairs
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        int rst = 0;

        boolean visited[] = new boolean[10];
        for (int k = m; k <= n; k++) {
            for (int i = 1; i <= 9; i++) {
                visited[i] = true;
                rst = rst + patternsStarting(i, skip, visited, 1, k);
                visited[i] = false;
            }
        }
        return rst;
    }

    private static int patternsStarting(int startingpoint, int[][] skip, boolean[] visited, int index, int k) {
        if (index == k) {
            return 1;
        }

        int ways = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && skip[startingpoint][i] == 0 || (visited[skip[startingpoint][i]]  && !visited[i])) {
                visited[i] = true;
                ways = ways + patternsStarting(i, skip, visited, index + 1, k);
                visited[i] = false;
            }
        }
        return ways;
    }

    public static void main(String[] args) {

    }
}
