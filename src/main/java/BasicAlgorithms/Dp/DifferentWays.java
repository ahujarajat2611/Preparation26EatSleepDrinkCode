package BasicAlgorithms.Dp;

import java.util.*;
/// left ans * right ans ( divide conquer DP)
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
        for (int i = L; i <= R; i++) {
            if (isOprator(input.charAt(i))) {
                left = diffWaysToCompute(input, L, i-1);
                right = diffWaysToCompute(input, i+1, R);
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