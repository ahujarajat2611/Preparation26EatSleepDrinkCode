package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 22/9/17.
 */
public class QueenSolutionBest {
    private class Solution {
        private boolean[] colConflict;
        private boolean[] diagConflict;
        private boolean[] revDiagConflict;
        private int numSolutions;

        public int totalNQueens(int n) {
            colConflict = new boolean[n];
            diagConflict = new boolean[2 * n];
            revDiagConflict = new boolean[2 * n];
            numSolutions = 0;
            dfs(n, new int[n], 0);
            return numSolutions;
        }

        private void dfs(int n, int[] colPos, int row) {
            if (row == n) {
                numSolutions++;
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isConflict(n, row, col)) {
                    continue;
                }
                setConflict(n, row, col, true);
                colPos[row] = col;
                dfs(n, colPos, row + 1);
                setConflict(n, row, col, false);
            }
        }

        private boolean isConflict(int n, int row, int col) {
            if (colConflict[col] || diagConflict[row - col + n] ||
                    revDiagConflict[row + col]) {
                return true;
            }
            return false;
        }

        private void setConflict(int n, int row, int col, boolean conflict) {
            colConflict[col] = conflict;
            diagConflict[row - col + n] = conflict;
            revDiagConflict[row + col] = conflict;
        }
    }
}
