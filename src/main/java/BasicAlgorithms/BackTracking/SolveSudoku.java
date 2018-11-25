package BasicAlgorithms.BackTracking;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 23/10/17.
 */
public class SolveSudoku {
    int count = 0;
    public void solveSudoku(char[][] board) {
        int emptySlot = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    emptySlot++;
                }
            }
        }
        boolean solveit = dfs(board,emptySlot);
    }

    private boolean dfs(char[][] board,int emptySlot) {
        count++;
        if(count>100000){
            System.exit(1);
        }
        if(emptySlot == 0){
            System.out.println("Entring here");
            return true;
        }
        System.out.println("em "+emptySlot);
        System.out.println("em "+count);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] =='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,c,i,j)){
                            System.out.println("i "+i);
                            System.out.println("j "+j );
                            board[i][j] = c;
                            emptySlot--;
                            if(dfs(board,emptySlot)){
                                return true;
                            }
                            board[i][j] = '.';
                            emptySlot++;
                        }
                    }
                    return false;
                }
                else {
                    continue;
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, char c, int row, int col) {
        for(int i=0;i<9;i++){
            if(board[i][col] == c ){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(board[row][j] == c){
                return false;
            }
        }
        for(int i=(row/3)*3;i<(row/3)*3+3;i++){
            for(int j=(col/3)*3 ;j<(col/3)*3 +3;j++){
                if(board[i][j] == c){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char [][]board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        ConsoleWriter.printIntArray(board);
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(board);
        ConsoleWriter.printIntArray(board);

    }
}