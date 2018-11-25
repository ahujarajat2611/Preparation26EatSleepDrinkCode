package zrzahid;

/**
 * Created by hadoop on 7/9/17.
 */
public class TicTacToe {
    private int []rows;
    private int []cols;
    int diagonal;
    int antidiagonal;
    TicTacToe(int n){
        cols = new int[n];
        rows = new int[n];
    }
    // every row has array of row and cols and according add
    //if + 3 or -3 ans reached
    // if row or col == or row = col.l-1-col
    public int move(int row,int col,int player){
        int toAdd = player == 1?1:-1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if(row == col){
            diagonal+=toAdd;
        }
        // very imp condition for diagonal check
        if(col == cols.length-1-row){
        // andti diagoal addition
            antidiagonal += toAdd;
        }

        int size = rows.length;

        if(Math.abs(rows[row]) == size|| Math.abs(cols[col]) == size
                || Math.abs(diagonal) ==size
        || Math.abs(antidiagonal)== size){
            return player;
        }
        return 0;
    }
}
