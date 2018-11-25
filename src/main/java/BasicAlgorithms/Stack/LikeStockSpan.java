package BasicAlgorithms.Stack;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Stack;

/**
 * Created by hadoop on 24/12/17.
 */
public class LikeStockSpan {
    public int[] dailyTemperatures(int[] temperatures) {

        int res [] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>() ;
        for(int i=temperatures.length-1;i>=0;i--){
            while (!stack.empty() && temperatures[i] >temperatures[stack.peek()] ){
                    stack.pop();
            }
            if(stack.empty()){
                res[i] = 0;
            }
            else {
                res[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return res;
    }
    public int[] dailyTemperaturesFromFront(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        LikeStockSpan stockSpan = new LikeStockSpan();
        int []ar = {100, 80, 60, 70, 60, 75, 85};
        int []ar1 = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        ConsoleWriter.printIntArray(stockSpan.dailyTemperaturesFromFront(ar));
    }
}