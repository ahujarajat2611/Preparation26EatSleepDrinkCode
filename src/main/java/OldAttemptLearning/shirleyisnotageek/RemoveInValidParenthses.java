package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
/*
Remove Invalid Parentheses
Remove the minimum number of invalid parentheses in order to make the input String valid. Return all possible results.
Note: The input String may contain letters other than the parentheses ( and ).
Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

 */
/*
Because we want to remove the least number of parentheses to make the String valid, BFS is a good solution. Start from the String itself, remove one of the "(" or ")" in the String every time, if we haven't seen the String, add it to the queue. For every String polled from queue, we check if it is valid, if it is, we know we've found the longest valid String, and we set the length to current String's length, so whenever we see a String that is shorter than this length, the iteration finishes.
 */
public class RemoveInValidParenthses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> validParentheses = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        int done = -1;
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.length() < done)
                break;
            if (isValid(curr)) {
                validParentheses.add(curr);
                done = curr.length();
            } else {
                for (int i = 0; i < curr.length(); i++) {
                    if ("()".indexOf(curr.charAt(i)) < 0)
                        continue;
                    String next = curr.substring(0, i) + curr.substring(i + 1);
                    if (visited.add(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return validParentheses;

    }

    private boolean isValid(String s) {
        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.add(i);
            } else if (s.charAt(i) == ')') {
                if (left.isEmpty())
                    return false;
                else
                    left.pop();
            }
        }
        return left.isEmpty();
    }
}
