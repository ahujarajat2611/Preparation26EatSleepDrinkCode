package BasicAlgorithms.Stack;

import java.util.Stack;

/**
 * Created by hadoop on 21/10/17.
 */
public class Histogram {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int toppedHeight = heights[stack.pop()];
                int width = 0;
                if (!stack.isEmpty()) {
                    width = i - stack.peek() - 1;
                } else {
                    width = i;
                }
                max = Math.max(max, toppedHeight * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int toppedHeight = heights[stack.pop()];
            int width = 0;
            if (!stack.isEmpty()) {
                width = heights.length - stack.peek() - 1;
            } else {
                width = heights.length;
            }
            max = Math.max(max, toppedHeight * width);
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[] histogram = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j]++;
                }
            }
            max = Math.max(max, largestRectangleArea(histogram));
        }
        return max;
    }

    public static int maxSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            int rowsum[] = new int[matrix[0].length];
            for(int j=0;j<matrix.length;j++){

                for(int k=0;k<matrix[0].length;k++){
                    rowsum[k] = rowsum[k]+matrix[j][k];
                }

                max = Math.max(max,kadanesAlgo(rowsum));
            }
        }
        return max;
    }

    private static int kadanesAlgo(int[] rowsum) {
        int left[] = new int[rowsum.length];
        int currentmax = 0;
        int globalmax = 0;
        for(int i=0;i<rowsum.length;i++){
            if(i ==0){
                left[i] = rowsum[i];
                currentmax = rowsum[i];
            }
            else {
                currentmax = Math.max(rowsum[i],currentmax +rowsum[i]);
                left[i] =Math.max(left[i-1],currentmax);
            }
            globalmax = Math.max(globalmax,left[i]);
        }
        return globalmax;
    }
    public static void main(String args[]){
        Histogram histogram = new Histogram();
        int array[] = {2,1,5,6,2,3};
        System.out.println(histogram.largestRectangleArea(array));
    }
}