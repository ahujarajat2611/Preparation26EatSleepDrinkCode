package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Given n non-negative integers a1, a2, ..., an, where each

represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Example
Given [1,3,2], the max area of the container is 2.

Note
You may not slant the container.

Tags Expand
Two Pointers Array
*/
/*
Thoughts:
Start from 2 sides with 2 pointers, use those as 2 walls.

Height of water is limited by the lower wall.
 For example, left wall < right wall, width = right.x - left.x
	Now, if we move right wall: right--, then width = width-1, and the whole block is still limited by the lower left wall.\
	 So, this is not a good move.
	Instead, when left wall < right wall, we move left++.
	On the other hand, if lett wall > right wall, right--.
*/
/*



If we move on higher side, there is no way we can get water max than counteed now !!! no way !!!!
since it is limted by left side size which is smaller
if we move from smaller size, we might get better match for right pipe and can contain max water than calculated right now !!
 */
public class ContainerMostWater {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int maxWater = Integer.MIN_VALUE;
        while (left < right) {
            maxWater = Math.max(maxWater, (right-left) * (heights[left] < heights[right] ? heights[left] : heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
