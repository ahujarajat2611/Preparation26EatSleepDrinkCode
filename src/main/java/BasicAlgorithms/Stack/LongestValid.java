package BasicAlgorithms.Stack;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Stack;

/**
 * Created by hadoop on 18/10/17.
 */
public class LongestValid {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        int start = 0;
        int longest = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='('){
                stack.push(i);
            }
            else {
                if(stack.isEmpty()){
                    start = i+1;
                }
                else {
                    stack.pop();

                    if(stack.isEmpty()){
                        longest = Math.max(longest,i-start+1);
                    }
                    else {
                        longest = Math.max(longest,i-stack.peek());
                    }
                }
            }
        }
        return longest;
    }
    private boolean matching(Character peek, Character c) {
        if (peek == '(' && c == ')') {
            return true;
        }
        if (peek == '[' && c == ']') {
            return true;
        }
        if (peek == '{' && c == '}') {
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        LongestValid longestValid = new LongestValid();
       // System.out.println(longestValid.longestValidParentheses(")()())"));
        System.out.println(longestValid.getLongestValidParen(")()()("));

    }

    int getLongestValidParen(String s){
        Stack<Integer> stack= new Stack<>();

        char []sarray = s.toCharArray();
        ConsoleWriter.printArray(sarray);
        System.out.println(sarray[0]);
        System.out.println(sarray[1]);
        System.out.println(sarray[2]);
        if(sarray[0] == sarray[1]){
            System.out.println("true");
        }
        for(int i=0;i<sarray.length;i++){
            if(sarray[i] == '('){
                stack.push(i);
            }
            else {
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else {
                    if(sarray[stack.peek()] == '('){
                        //System.out.println("enter");
                        stack.pop();
                    }
                    else {
                        //System.out.println("pushing");
                        stack.push(i);
                    }
                }
            }
        }
        int right = s.length();
        int left = 0;
        if(stack.isEmpty()){
            return right;
        }
        int ans= 0;
        while (!stack.isEmpty()){
            left = stack.pop();
            System.out.println("right "+right);
            System.out.println("left "+left);
            ans = Math.max(ans,right-left-1);
            right = left;
        }
        return ans;
    }
}
