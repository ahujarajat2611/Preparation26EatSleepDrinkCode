package BasicAlgorithms.Array;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 21/10/17.
 */
public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        if(rowLength == 0 || columnLength == 0){
            return;
        }
        boolean firstRowZero = false;
        for(int j=0;j<columnLength;j++){
            if(matrix[0][j] == 0){
                firstRowZero= true;
            }
        }
        boolean firstColumnZero = false;

        for(int i=0;i<rowLength;i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
            }
        }
        ConsoleWriter.printIntArray(matrix);
        System.out.println();

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<columnLength;j++){
                if(matrix[i][j] ==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        ConsoleWriter.printIntArray(matrix);
        System.out.println();

        for(int i=1;i<matrix.length;i++){
                if(matrix[i][0]==0) {
                    for (int j = 0; j < columnLength; j++) {
                        matrix[i][j] = 0;
                    }
                }
        }
       // ConsoleWriter.printIntArray(matrix);
        System.out.println();

        for(int j=0;j<columnLength;j++){
            if(matrix[0][j] ==0){
                for(int i=0;i<rowLength;i++){
                    matrix[i][j] = 0;
                }

            }
        }
        ConsoleWriter.printIntArray(matrix);
        System.out.println();


//        for(int i=0;i<rowLength;i++){
//            for(int j=0;j<columnLength;j++){
//                if(matrix[0][j] == 0|| matrix[i][0] == 0 ){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
        if(firstRowZero){
            for(int j=0;j<columnLength;j++){
                matrix[0][j] =0;
            }
        }
        if(firstColumnZero){
            for(int i=0;i<rowLength;i++){
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String args[]){

        SetMatrixZero setMatrixZero = new SetMatrixZero();
        int [][]matrix =
                {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setMatrixZero.setZeroes(matrix);
        ConsoleWriter.printIntArray(matrix);
    }
}