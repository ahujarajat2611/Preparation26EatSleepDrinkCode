package BasicAlgorithms.Array;

/**
 * Created by hadoop on 25/2/18.
 */
public class ContainerMaxWater {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        int left = 0;
        int right = heights.length - 1;

        int area = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                area = heights[left] * (right - left);
                max = Math.max(area, max);
                left++;
            } else {
                area = heights[right] * (right - left);
                max = Math.max(area, max);
                right--;
            }
        }
        return max;
    }
}

/*

Question: Why shorter pointer to move to the middle?
Can assume that the distance between the two columns n, the shorter the height of the column h, then the middle of the water area can be stored n * h. Suppose the initial state heights[left] < heights[right].
If left++this n - 1is the case h1, then the distance between the pillars and the shorter one is then area1 = (n - 1) * h1; if so right--, the distance between the pillars n - 1and the shorter ones is h2then area2 = (n - 1) * h2;
The difference between the areas obtained in both directions:
area1 - area2 = (n - 1) * h1 - (n - 1) * h2 = (n - 1) * (h1 - h2)
Suppose n - 1 >= 1that (n - 1 <0 means heights [] is empty, n - 1 <1 means n = 1, then there is only one area, not to be discussed)
Do some inequalities
area1 - area2 >= h1 - h2
Because heights[left] < heights[right]setting (considering only the middle and left / right sides of the column above, since if less than heights[left], heights[right]the area can not be larger water) If right--, the water level will be less than the maximum height left++, the maximum height of the water level .
 */
