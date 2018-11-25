package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 22/10/17.
 */
import java.util.*;
public class Queens {
    Set<Integer> sameColumn = new HashSet<>();
    Set<Integer> sameLeftDialgonal = new HashSet<>();
    Set<Integer> sameRightDiagonal = new HashSet<>();
    int n;
    char board[][];
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int count = solveNQueensHelper(0,n);
        return result;
    }
    int solveNQueensHelper(int row,int length){
        path.clear();
        if(row == n){
            for(int i=0;i<row;i++){
                path.add(String.valueOf(board[i]));
            }
            result.add(new ArrayList<>(path));
            return 1;
        }
        int count =0;
        // all possible options that particular row has to deal with !!!!
        //
        for(int column=0;column<n;column++){
            if(valid(row,column)){
                makeMove(row,column);
                count +=solveNQueensHelper(row+1,length);
                unmakeMove(row,column);
            }
        }
        return count;
    }

    private void unmakeMove(int row, int column) {
        board[row][column] ='.';
        sameColumn.remove(column);
        sameLeftDialgonal.remove(row-column+n);
        sameRightDiagonal.remove(row+column);
    }

    private void makeMove(int row, int column) {
        board[row][column] = 'Q';
        sameColumn.add(column);
        sameLeftDialgonal.add(row-column+n);
        sameRightDiagonal.add(row+column);
    }

    private boolean valid(int row, int column) {
        if(sameColumn.contains(column))
            return false;
        if(sameRightDiagonal.contains(row+column)){
            return false;
        }
        if(sameLeftDialgonal.contains(row-column+n)){
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        Queens queens = new Queens();
        System.out.println(queens.solveNQueens(4));
    }

}