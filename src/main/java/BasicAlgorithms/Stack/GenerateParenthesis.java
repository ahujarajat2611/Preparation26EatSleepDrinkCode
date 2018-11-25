package BasicAlgorithms.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 18/10/17.
 */
//https://discuss.leetcode.com/topic/33127/java-easy-to-understand-recursive-dp-method-with-explanations
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {

        return generateParenthesisHelper(0,n-1);
    }

    private List<String> generateParenthesisHelper(int start, int end) {
        List<String> list = new ArrayList<>();
        if(start == end){
            list.add("()");
            return list;
        }
        if(start>end){
            list.add("");
            return list;
        }
        if(start>end){
            return list;
        }
        // iteration from publish to end !!!
        for(int mid = start;mid<=end;mid++) {
            List<String> leftAns = generateParenthesisHelper(start, mid - 1);
            List<String> rightAns = generateParenthesisHelper(mid + 1, end);
            for (String left : leftAns) {
                for (String right : rightAns) {
//                    list.add("(" + left + ")" + right);
                    list.add(left + "(" + right + ")");
                    //[()()(), ()(()), (())(), (()()), ((()))]


                }
            }
        }
        return list;
    }
    public static void main(String args[]){
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }


}
