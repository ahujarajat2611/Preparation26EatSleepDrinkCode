package BasicAlgorithms.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
import java.util.*;
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return rst;
        }
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    // a little trick is that we should save the value(prevResult) that is to be multiplied in the next recursion.

    // previous number eval !! These are two numbers that i have to deal with

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long prevNum) {
        if (pos == num.length()) {
            if (target == eval) {
                rst.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // 0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it
            // too.
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            // overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                /*@formatter:off
                 * suppose num = 234 and target=  14 , result is : 2+3*4
                 *  Step1 : 2
                 *  Step2 : 2+3(5), 2-3(-1),2*3(6)
                 *  Step3 : evalution should be : 2+3"+4", 2+3"-4", 2+3"*4". For + and -, doing operation on previous result(i.e. 5) is fine.
                 *          However, for multiplication it also tries to 5*4. Which is wrong. Instead, it should multiply wit prevNum(i.e.3).
                 *          For that case, we do cur*prevNum and also deduct prevNum from 'eval' since we are considering 'prevNum' for multiplication.
                 *
                 *
                 *@formatter:on
                 */
                helper(rst, path + "*" + cur, num, target, i + 1, eval - prevNum + prevNum * cur, prevNum * cur);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators obj = new ExpressionAddOperators();
        List<String> res = null;
        res = obj.addOperators("123", 6);
        System.out.println(res);

        res = obj.addOperators("232", 8);
        System.out.println(res);

        res = obj.addOperators("105", 5);
        System.out.println(res);

        res = obj.addOperators("00", 0);
        System.out.println(res);

        res = obj.addOperators("3456237490", 9191);
        System.out.println(res);

    }

    public List<String> addOperatorsMyLong(String num, int target) {
        List<String> path = new LinkedList<>();
        List<List<String>> result = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        if (num.length() == 1) {
            if (Integer.parseInt(num) == target) {
                ans.add(num);
                return ans;
            } else {
                return ans;
            }
        }

        String previousChar = "";
        addOperatorsHelper(num, 0, path, result, target, 0, 0, 0, previousChar);
        for(List<String> list :result){
            String start="";
            for(String x:list){
                start = start+x;
            }
            ans.add(start);
        }
        return ans;
    }

    private void addOperatorsHelper(String num, int start, List<String> path, List<List<String>> result, long target, long calculatedTillNow, long calculatedTillPrevious, long previousNumber, String previousChar) {
        // System.out.println("publish "+publish);
        if (start == num.length()) {
            //  System.out.println("entry here "+calculatedTillNow);
            if (calculatedTillNow == target) {
                //    System.out.println("target"+target);
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int index = start; index < num.length(); index++) {

            String currentString = num.substring(start, index + 1);
            Long number = Long.parseLong(currentString);
            if(currentString.startsWith("0") && currentString.length()>1){
                continue;
            }
            if (start == 0) {
                path.add(currentString);
                addOperatorsHelper(num, index+1, path, result, target, number, 0, number, previousChar);
                path.remove(path.size() - 1);
            } else {
                path.add("+" + currentString);
                addOperatorsHelper(num, index + 1, path, result, target, calculatedTillNow+number, calculatedTillNow, number, "+");
                path.remove(path.size() - 1);
                path.add("-" + currentString);
                addOperatorsHelper(num, index + 1, path, result, target, calculatedTillNow-number, calculatedTillNow, number, "-");
                path.remove(path.size() - 1);

                path.add("*" + currentString);

                if (previousChar == "+") {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious +previousNumber*number, calculatedTillPrevious, previousNumber*number, "+");
                }
                else if (previousChar == "-") {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious -previousNumber*number, calculatedTillPrevious, previousNumber*number, "-");
                }
                else if (previousChar == "*") {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious +previousNumber*number, calculatedTillPrevious, previousNumber*number, "*");
                }
                else {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious +previousNumber*number, calculatedTillPrevious, previousNumber*number, "*");
                }
                path.remove(path.size() - 1);
            }
        }
    }
}
