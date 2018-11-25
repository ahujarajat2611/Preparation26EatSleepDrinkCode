package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 13/9/17.
 */
public class Queens {
    static int counter = 0;

    public static void main(String[] args) {
        int n;
        n = 4;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();

        Queens queens = new Queens();
        queens.solveQueen(board,0,result,n);
        System.out.println(result);
    }
    void solveQueen(char[][] board, int index, List<List<String>> result,int size){
        if(index == size){
        //    System.out.println("coming here");
            ArrayList<String>list = new ArrayList<>();
            for(int i=0;i<4;i++) {
          //      System.out.println("ans"+String.valueOf(board[i]));
                list.add(String.valueOf(board[i]));
            }
            result.add(new ArrayList<>(list));
            return ;
        }
        //System.out.println("index out"+index);
        for(int col=0;col<size;col++){
            //System.out.println("index in"+index);

            if(valid(index,col,board)){
                //System.out.println("index"+index);
                //System.out.println("ans here");

                board[index][col] ='a';
                if(index ==1 && col ==3){
                    System.out.println("special case");
                    for(int s=0;s<4;s++) {
                        System.out.println(String.valueOf(board[s]));
                        //list.add(String.valueOf(board[i]));
                    }
                    System.out.println("end");

                }
                if(index ==2 && col ==0){
                    System.out.println("special case new again");
                    for(int s=0;s<4;s++) {
                        System.out.println(String.valueOf(board[s]));
                        //list.add(String.valueOf(board[i]));
                    }
                    System.out.println("end");

                }
                //System.out.println("call");
                solveQueen(board,index+1,result,size);
                board[index][col] ='.';
            }
        }
    }

    private boolean valid(int index, int col,char[][] board) {


            for(int  i=0;i<index;i++){
                if(board[i][col] =='a'){
                       // if(index ==3) {
                            //for(int s=0;s<4;s++) {
                                      //System.out.println(String.valueOf(board[s]));
                                //list.add(String.valueOf(board[i]));
                          //  }
                            System.out.println("colmatched" + i);
                        //}
                        return false;
                }
            }

            for(int j=0;j<board.length;j++){
                if(board[index][j] =='a'){
                    if(index == 7 && col == 5) {
                        System.out.println("row");
                    }
                    return false;
                }
            }
            for(int i=0;i<index;i++) {
                for (int j = 0; j < board.length; j++) {
                    if(board[i][j]=='a') {
                        if(j>col) {
                            if (i + j == index + col) {
                                System.out.println("right");
                                return false;

                            }
                        }
                        if(j<col){
                        if (Math.abs(i - j) == Math.abs(index - col)) {
                            System.out.println("left" + i + " " + j);
                            return false;
                        }
                        }

                    }
                }
            }

        return true;
    }
    private boolean validagain(int index, int col,char[][] board) {

        for(int  i=0;i<index;i++){
            if(board[i][col] =='a'){
                return false;
            }
        }
        int row = index;
        int column = col;

        while (row>=0 && column>=0){
            if(board[row][column] =='a'){
                return false;
            }
            row--;
            column--;
        }
        row = index;
        column = col;
        while (row>=0 && column<=board.length-1){
            if(board[row][column] =='a'){
                return false;
            }
            row--;
            column++;
        }
        //  }
        return true;
    }
}
