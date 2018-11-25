package OldAttemptLearning.zhengyang2015;

/**
 * Created by hadoop on 23/8/17.
 */
public class LargestRectangleHistogram {
    public static void main(String args[]){
        LargestRectangleHistogram largestRectangleHistogram= new LargestRectangleHistogram();
        int height []= {2,1,5,6,2,3};
        largestRectangleHistogram.largestRectangleArea(height);
    }
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            System.out.println("i "+i);
            int minv = height[i];
            for (int j = i; j < height.length; j++) {
                minv = Math.min(minv,height[j]);
                int area = (j - i + 1) * minv;
                if (area > maxArea) {
                    System.out.println("max area is "+area);
                    System.out.println("max i and j is"+i);
                    System.out.println("max i and j is "+j);
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}

