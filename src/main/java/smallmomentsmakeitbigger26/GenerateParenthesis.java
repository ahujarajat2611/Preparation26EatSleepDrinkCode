package smallmomentsmakeitbigger26;
import java.util.*;

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
        for(int mid = start;mid<=end;mid++) {
            List<String> leftAns = generateParenthesisHelper(start, mid - 1);
            List<String> rightAns = generateParenthesisHelper(mid + 1, end);
            for (String left : leftAns) {
                for (String right : rightAns) {
                    list.add("(" + left + ")" + right);
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
