package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 19/1/18.
 */
    public class TicTacToe {
        int[] rows;
        int[] cols;
        int[] diags;
        int[] revDiags;
        int n;

        public TicTacToe (int n) {
// for diagnola tracking we need a variable
            /// diag andd revrsediag not entire array
            // thsi logic seems wrong !!
            this.n = n;
            rows = new int[n];
            cols = new int[n];
            diags = new int[n];
            revDiags = new int[n];
        }

        public int move(int row, int col, int player) {
            if (player == 1) {
                rows[row]++;
                cols[col]++;
                if (row == col) {
                    diags[row]++;
                }
                if (row + col == n - 1) {
                    revDiags[row]++;
                }
                if (rows[row] == n
                        || cols[col] == n
                        || diags[row] == n
                        || revDiags[row] == n) {
                    return player;
                }
            } else {
                rows[row]--;
                cols[col]--;
                if (row == col) {
                    diags[row]--;
                }
                if (row + col == n - 1) {
                    revDiags[row]--;
                }
                if (rows[row] == -n
                        || cols[col] == -n
                        || diags[row] == -n
                        || revDiags[row] == -n) {
                    return player;
                }
            }
            return 0;
        }
    }
