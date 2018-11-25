package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Game of Life
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
Follow up:
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
/*
The tricky part is whenever you update a cell, its neighbors may already have been updated, and that leads a problem of tracking their state before update. We know all live states = 1 and dead states = 0, i.e., liveStates & 1 = 1 and deadStates & 1 = 0. So our updated states can follow this pattern, if current state is 1, its updated state will be an odd number (e.g., 3), and if current state is 0, its updated state will be an even number (e.g., 2).

Then in the end how can we change it back to 0 and 1? From the question we know there are at most 4 changing states:

0. Dead -> Dead
1. Live  -> Dead
2. Dead -> Live
3. Live  -> Live

So we label these states according late and in the end divide them by 2, we get the answer.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0  || board[0].length == 0)
            return;
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        int len = board.length;
        int hei = board[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < hei; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    if (i + dx[k] >= 0
                            && i + dx[k] < len
                            && j + dy[k] >= 0
                            && j + dy[k] < hei
                            && (board[i + dx[k]][j + dy[k]] & 1) == 1)
                        count++;
                }
                int stats = (board[i][j] & 1);
                if ((count < 2 || count > 3 ) && stats== 1)
                    board[i][j] = 1;
                if ((count == 2 || count == 3) && stats == 1)
                    board[i][j] = 3;
                if (count == 3 && stats == 0)
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < hei; j++) {
                board[i][j] /= 2;
            }
        }
    }
}
