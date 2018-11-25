package AwangDevLintCode;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 8/2/18.
 */
public class RototeMatrix {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int width = matrix.length;
        System.out.println("ros "+width/2);
        System.out.println("col "+Math.ceil(width/2.0));
        for (int i = 0; i < width/2; i++) {
            for (int j = 0; j < Math.ceil(width/2.0); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[width - 1 - j][i];
                matrix[width - 1 - j][i] = matrix[width - 1 - i][width - 1 - j];
                matrix[width - 1 - i][width - 1 - j] = matrix[j][width - 1 - i];
                matrix[j][width - 1 - i] = temp;
            }
            System.out.println("after every step ");
            ConsoleWriter.printIntArray(matrix);

        }
    }
    // NOT RIGHT SOLUTION
//    public void rotateMatrix(int a[][], int m, int n) {
//        int left = 0, right = n - 1, top = 0, bottom = m - 1;
//        int prev, cur;
//        while (left <= right && top <= bottom) {
//            prev = a[top + 1][left];
//            for (int i = left; i <= right; i++) {
//                cur = a[top][i];
//                a[top][i] = prev;
//                prev = cur;
//            }
//            top++;
//            for (int i = top; i <= bottom; i++) {
//                cur = a[i][right];
//                a[i][right] = prev;
//                prev = cur;
//            }
//            right--;
//            for (int i = right; i >= left; i--) {
//                cur = a[bottom][i];
//                a[bottom][i] = prev;
//                prev = cur;
//            }
//            bottom--;
//            for (int i = bottom; i >= top; i--) {
//                cur = a[i][left];
//                a[i][left] = prev;
//                prev = cur;
//
//            }
//            left++;
//        }
//    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};

        RototeMatrix rototeMatrix  = new RototeMatrix();
        rototeMatrix.rotate(matrix);
        ConsoleWriter.printIntArray(matrix);
//        System.out.println("=========");
//        rototeMatrix.rotate(matrix);
//        ConsoleWriter.printIntArray(matrix);
//        System.out.println("=========");
//        rototeMatrix.rotate(matrix);
//        ConsoleWriter.printIntArray(matrix);
//        System.out.println("=========");
//        rototeMatrix.rotate(matrix);
//        ConsoleWriter.printIntArray(matrix);

//        rototeMatrix.rotateMatrix(matrix1,matrix1.length,matrix1[0].length);
//        ConsoleWriter.printIntArray(matrix1);
//        System.out.println("=========");
//        rototeMatrix.rotateMatrix(matrix1,matrix1.length,matrix1[0].length);
//        ConsoleWriter.printIntArray(matrix1);

    }
}
