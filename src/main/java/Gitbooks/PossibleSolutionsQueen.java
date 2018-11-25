package Gitbooks;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hadoop on 14/9/17.
 */
public class PossibleSolutionsQueen {
    Set<Integer> sameColumn = new HashSet<>();
    Set<Integer> leftDiagonal = new HashSet<>();
    Set<Integer> rightDiagonal = new HashSet<>();
    int n=4;
    public static void main(String args[]){
        PossibleSolutionsQueen possibleSolutionsQueen = new PossibleSolutionsQueen();
        System.out.println("ans"+possibleSolutionsQueen.queen(0,4));
    }
    int queen(int row,int size){

        if(row ==size ){
            return 1;
        }
        int count = 0;
        for(int col = 0;col<size;col++){
            if(valid(row,col)){
                setMove(row,col);
                count+= queen(row+1,size);
                unsetMove(row,col);
            }
        }
        return count;
    }

    private void unsetMove(int row, int col) {
        sameColumn.remove(col);
        leftDiagonal.remove(row-col+n);
        rightDiagonal.remove(row+col);
    }

    private void setMove(int row, int col) {
        sameColumn.add(col);
        leftDiagonal.add(row-col+n);
        rightDiagonal.add(row+col);
    }

    private boolean valid(int row, int col) {
        if(sameColumn.contains(col)) return  false;
        if(leftDiagonal.contains(row-col+n)) return false;
        if(rightDiagonal.contains(row+col)) return false;
        return true;
    }
}
