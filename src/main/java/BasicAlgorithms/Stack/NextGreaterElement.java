package BasicAlgorithms.Stack;
import java.util.*;

/**
 * Created by hadoop on 25/12/17.
 */
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        return nextGreaterElementsFromFront(nums);
    }
    public int[] nextGreaterElementsFromFront(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int []ans = new int[n];
        for(int i=0;i<ans.length;i++){
            ans[i] =-1;
        }
        for(int i=0;i<2*nums.length;i++){
            while (!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
                ans[stack.pop()]=nums[i%n];
            }
            if(i<n){
                stack.push(i);
            }
        }
        return ans;
    }
}
