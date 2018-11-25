package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 13/9/17.
 */
public class Parenthesis {
    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        int n = 2;
        System.out.println(parenthesis.generateParenthesis(0,n-1));
    }

    List<String> generateParenthesis(int start,int end) {
        List<String> strings = new ArrayList<>();
        if(start>end){
            strings.add("");
            return strings;
        }
        if(start == end){
            strings.add("()");
            return strings;
        }
        else {
            for(int i=start;i<=end;i++) {
                List<String> leftStrings = generateParenthesis(start,i-1);
                List<String> rightStrings = generateParenthesis(i+1,end);
                System.out.println("leftstrings"+leftStrings);
                System.out.println("right"+rightStrings);
                for(String left:leftStrings){
                    for(String right:rightStrings){
                        strings.add("("+left+")"+right);
                    }
                }
            }
        }
        return strings;
    }

}