package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class SudokuSOlver {

    public void solveSudoku(char[][] board) {
        if (board.length == 0) return;
        dfs(board);
    }

    public boolean dfs(char[][] board){

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    for (char ch = '1'; ch <= '9'; ch++){
                        if (valid(board, i, j, ch)){

                            board[i][j] = ch;
                            if (dfs(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    // here returning false
                    return false;
                }
            }
        }
        //// very very very imp point
        return true;
    }

    public boolean valid(char[][] board, int i, int j, char ch){

        // normal decent loopin
        // no fancy stfuff
        for (int col = 0; col < board[0].length; col++)
            if (board[i][col] == ch) return false;

        for (int row = 0; row < board.length; row++)
            if (board[row][j] == ch) return false;

        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++){
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++){
                if (board[row][col] == ch) return false;
            }
        }
        return true;
    }
}
