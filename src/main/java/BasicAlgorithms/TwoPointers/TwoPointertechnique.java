package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 5/12/17.
 */
public class TwoPointertechnique {
}
/*


If you want max value from left then we need decreeasing stack
             to main tain decreasing stack if i see cureen value more than stack peek ..
             // pop and maintain result whatever be !!!!!
if you want min value frmo left then we need increasing stack
               to maintain increasing stack the moment i see a current vlaue less than pee
               pop and maintain reuslt

               That's how you can build solution !!!

 */
/*
class Solution:
    # @param {integer[]} height
    # @return {integer}
    def trap(self, height):
        s = []
        water = 0

        for i in range(len(height)):
            while s and height[i] > height[s[-1]]:
                tmp = height[s.pop()]
                if s:
                    water += (min(height[i], height[s[-1]]) - tmp) * (i - s[-1] - 1)
            s.append(i)

        return water






class Solution:
    # @param {integer[]} height
    # @return {integer}
    def largestRectangleArea(self, height):
        height.append(-1)
        s = [-1]
        ans = 0

        for i in range(len(height)):
            while height[i] < height[s[-1]]:
                tmp = s.pop()
                ans = max(ans, height[tmp] * (i - s[-1] - 1))
            s.append(i)

        return ans



 */
