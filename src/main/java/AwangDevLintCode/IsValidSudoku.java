package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */

import java.util.*;
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
            return false;
        }
        HashSet<Character> row,col,block;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            row = new HashSet<Character>();
            col = new HashSet<Character>();
            for (int j = 0; j < n; j++) {
                //Check row
                if (!row.contains(board[i][j])) {
                    row.add(board[i][j]);
                } else if (board[i][j] != '.'){
                    return false;
                }
                //Check col
                if (!col.contains(board[j][i])) {
                    col.add(board[j][i]);
                } else if (board[j][i] != '.'){
                    return false;
                }
            }
        }

        for (int i = 0; i < n; i+=3) {
            for (int j = 0; j < n; j+=3) {
                block = new HashSet<Character>();
                //Check block
                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 3; h++) {
                        if (!block.contains(board[i+k][j+h])) {
                            block.add(board[i+k][j+h]);
                        } else if (board[i+k][j+h] != '.'){
                            return false;
                        }
                    }
                }
            }

        }


        return true;
    }
}
