package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 21/1/18.
 */
/*
So, a method to check if the added number is valid is necessary. A hashset is used. Basically, check the entire row, the column and the sub-box where the number is at and see if the same number has already added, if it has, return false. Note the indices of the first element in the sub-box is calculated by row / 3 * 3  and col / 3 * 3. For example, row = 4, col = 5, we get the indices x = 3 and y = 3.

The main method is a boolean method. The game is solved by recursion. That is, when we add a valid number, we recursively check the next number we can add to the board until we find a solution. If a number added is not valid, we remove the number and add the next one.

That is, yeah, of course you love it, the backtracking!

 */
public class Sudoku {
    public void solveSudoku(char[][] board) {
        if (!canBeSolved(board))
            System.out.println("Cannot be solved!");
    }
    private boolean canBeSolved (char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (int k = 1; k <= 9; k++) {
                    board[i][j] = (char) (k + '0');
                    if (isValid(board, i, j) && canBeSolved(board))
                        return true;
                    //return to '.' for next recursion
                    board[i][j] = '.';
                }

                return false;
            }
        }
        //go through the whole board
        return true;
    }
    private boolean isValid(char[][] board, int row, int col) {
        HashSet<Character> hs = new HashSet<Character> ();
        //the column
        for (int j = 0; j < board[0].length; j++) {
            if(hs.contains(board[row][j]))
                return false;
            //only add numbers
            if (board[row][j] != '.')
                hs.add(board[row][j]);
        }
        //the row
        hs.clear();
        for (int i = 0; i < board.length; i++) {
            if (hs.contains(board[i][col]))
                return false;
            if (board[i][col] != '.')
                hs.add(board[i][col]);
        }
        //the sub-box
        hs.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = row / 3 * 3 + i;
                int y = col / 3 * 3 + j;
                if (hs.contains(board[x][y]))
                    return false;
                if (board[x][y] != '.')
                    hs.add(board[x][y]);
            }
        }
        return true;
    }
}

