package Gitbooks;

/**
 * Created by hadoop on 14/9/17.
 */
public class Sudoku {
    public static void main(String args[]){

    }
    public boolean validSudoku(char [][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    return false;
                }
                for(char c='1';c<='9';c++){
                    if(valid(i,j,board,c)){
                        board[i][j] = c;
                        if(validSudoku(board))
                            return true;
                        board[i][j] = '.';
                    }
                }
            }
        }
        return true;
    }

    private boolean valid(int i, int j, char[][] board, char c) {
        if(board[i][j] !='.') return false;
        for( int k=0;k<9;i++){
            if( board[k][j] ==c) return false;
            if( board[i][k] == c) return false;
        }
        for( int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(board[3*(i/3) +k][3*(j/3)+l] == c){
                    return false;
                }
            }
        }
        return true;
    }
}
