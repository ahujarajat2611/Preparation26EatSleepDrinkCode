package BasicAlgorithms.String;

import java.util.Stack;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestValidSubstring {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int start = 0;
        int maxlength = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else {
                if(stack.isEmpty()){
                    start = i+1;
                }
                else {
                    int element = stack.pop();
                    if(stack.isEmpty()){
                        maxlength = Math.max(maxlength,i-start+1);
                    }
                    else {
                        maxlength = Math.max(maxlength,i-stack.peek());
                    }

                }

            }
        }
        return maxlength;
    }
    public static void main(String args[]){

    }
}