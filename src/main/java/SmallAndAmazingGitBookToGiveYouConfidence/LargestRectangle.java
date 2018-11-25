package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Stack;

/**
 * Created by hadoop on 21/9/17.
 */
public class LargestRectangle {
    public int largestRectangle(int []heights){
        if(heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int area = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            while (!stack.isEmpty()  && heights[i]<heights[stack.peek()]){
                int localarea = heights[stack.peek()]*(i-stack.pop());
           //     System.out.println("localarea"+localarea);
                area = Math.max(area,localarea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int localarea = heights[stack.peek()]*(heights.length-stack.pop());
         //   System.out.println("localarea"+localarea);

            area = Math.max(area,localarea);

        }
        return area;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        for (int i = 0; i < heights.length; ++i) {
            while (indexStack.peek() != -1 && heights[i] < heights[indexStack.peek()]) {
                int index = indexStack.pop();
                maxArea = Math.max(maxArea, (i - indexStack.peek() - 1) * heights[index]);
            }
            indexStack.push(i);
        }
        while (indexStack.peek() != -1) {
            int index = indexStack.pop();
            maxArea = Math.max(maxArea,
                    (heights.length - indexStack.peek() - 1) * heights[index]);
        }

        return maxArea;
    }
    public int largestRectangleAreaWorking(int[] heights) {
        if(heights == null || heights.length ==0){
            return 0;
        }
        int area = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<heights.length;i++){
            while (!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int index = stack.pop();
                if(!stack.isEmpty()){
                    int localarea = heights[index] *(i-stack.peek()-1);
                    area = Math.max(localarea,area);

                }
                else{
                    int localarea = heights[index]*i;
                    area = Math.max(localarea,area);

                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            if(!stack.isEmpty()){
                int localarea = heights[index] *(heights.length-stack.peek()-1);
                area = Math.max(localarea,area);
            }else{
                int localarea = heights[index]*heights.length;
                area = Math.max(localarea,area);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        LargestRectangle largestRectangle = new LargestRectangle();
        int []height = {2,1,5,6,2,3};
        System.out.println(largestRectangle.largestRectangle(height));
    }
}
