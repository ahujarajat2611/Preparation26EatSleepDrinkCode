package smallmomentsmakeitbigger26;

import java.util.*;
public class DifferentWays {
    public List<Integer> diffWaysToCompute(String input) {
        if (input.isEmpty())
            return null;
        return diffWaysToCompute(input, 0, input.length()-1);
    }
    boolean isOprator(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }
    private static int cal(int left, int right, char operator) {
        if (operator == '+') {
            return left + right;
        } else if (operator == '-') {
            return left - right;
        } else {
            return left * right;
        }
    }
    public List<Integer> diffWaysToCompute(String input, int L, int R) {
        List<Integer> all = new ArrayList<Integer>();
        List<Integer> left;
        List<Integer> right;
        // check if no operator in the string then simply return from here addding that vvalue
        // in the list ....

        for (int i = L; i <= R; i++) {
            if (isOprator(input.charAt(i))) {
                left = diffWaysToCompute(input, L, i-1);
                right = diffWaysToCompute(input, i+1, R);
                //if we had to pick total total combinations possible
                // then we had to rerturn left * right /// boom
                // since here we want to have all the anserwers we are litellaly calculating all combinations
                // by selecting one item fromm left and one from riight !!!
                for (int l : left) {
                    for (int r : right) {
                        all.add(cal(l, r, input.charAt(i)));
                    }
                }
            }
        }
        if (all.size() == 0) {
            all.add(Integer.parseInt(input.substring(L, R+1)));
        }
        return all;
    }
}