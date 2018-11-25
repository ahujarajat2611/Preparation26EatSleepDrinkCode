package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Thoughts:
1. We know left-parentheses numL <= numR; otherwise it'll be incorrect
2. Pick left or right parentheses always gives up to 2 options at one node: it becomes a tree. We can use DFS and find the leaf
3. Always populate the List<String>
*/
import java.util.*;
public class GenerateParentheses {
    private final static String LEFT = "(";
    private final static String RIGHT = ")";
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs(result, new StringBuffer(), n, n);
        return result;
    }

    private void dfs(List<String> result, StringBuffer sb, int numL, int numR) {
        if (numL == 0 && numR == 0) {
            result.add(sb.toString());
            return;
        }
        if (numL > 0) {
            dfs(result, sb.append(LEFT), numL - 1, numR);
            sb.deleteCharAt(sb.length() - 1);
        }
        // if numr? numl then staright forward you can add right parenthese as well
        // and recursion pass one less
        if (numR > 0 && numL < numR) {
            dfs(result, sb.append(RIGHT), numL, numR - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
