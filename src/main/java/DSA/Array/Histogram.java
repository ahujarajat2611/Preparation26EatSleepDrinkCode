package DSA.Array;

import java.util.Stack;

/**
 * Created by hadoop on 10/2/18.
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
}
