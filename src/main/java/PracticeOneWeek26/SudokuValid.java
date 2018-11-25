package PracticeOneWeek26;

import java.util.HashSet;

/**
 * Created by hadoop on 9/12/17.
 */
public class SudokuValid {
    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == c) {
                return false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (j != col && board[row][j] == c) {
                return false;
            }
        }
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (i != row && j != col && board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuFaster(char[][] board) {
        for(int i=0;i<9;i++){
            if(!validrange(board,0,8,i,i)){
                return false;
            }
            if(!validrange(board,i,i,0,8)){
                return false;
            }
        }
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                if(!validrange(board,i,i+2,j,j+2)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validrange(char board[][],int xstart, int xend, int ystart, int yend) {
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=xstart;i<=xend;i++){
            for(int j=ystart;j<=yend;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(hashSet.contains(board[i][j])){
                    return false;
                }
                hashSet.add(board[i][j]);
            }
        }
        return true;
    }
}
