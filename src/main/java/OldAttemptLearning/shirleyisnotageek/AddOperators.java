package OldAttemptLearning.shirleyisnotageek;
import java.util.*;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Expression Add Operators
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or *between the digits so they evaluate to the target value.
Examples:
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
Usually this kind of problem
 involves backtracking.
 My first solution is very complicated,
 which is not quite good looking.
 I found another one online,
  which is much shorter and neater.
  It still uses backtracking. However
  , instead of doing the calculation
   and checking if the expression is valid,
    it calculates throughs the recursion.
     The function tracks the current result
     (sum), last number added (lastNum)
     and all other parameters we always need.
      If the operator is "+", sum increments by current number,
      lastNum = current number. If the operator is "-",
       sum decrements by current number,
       and lastNum = - current number.
       If the operator is "*"(that's when we need lastNum),
        sum decrements by lastNum then increments by
        lastNum * current_number.
         This is because multiplication is prior to
         addition and subtraction. Say if we had sum = a + b * c
         and lastNum = b * c, now we have operator *.
         Then sum = sum - b * c + b * c * d = a + b * c * d.
 */
public class AddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() <= 1)
            return rst;
        getResult(num, target, rst, "", 0, 0, 0);
        return rst;
    }

    private void getResult(String num, int target, List<String> rst, String curr,
                           int start, long sum, long lastNum) {
        if (start == num.length()) {
            if (sum == target) {
                rst.add(curr);
            }
            return;
        }
        for (int i = start + 1; i <= num.length(); i++) {
            String curNumString = num.substring(start, i);
            if (curNumString.length() > 1 && curNumString.charAt(0) == '0') {
                break;
            }
            long currNum = Long.parseLong(curNumString);
            if (start == 0) {
                getResult(num, target, rst, curr + currNum, i, currNum, currNum);
            } else {
                getResult(num, target, rst, curr + "+" + currNum, i, sum + currNum, currNum);
                getResult(num, target, rst, curr + "-" + currNum, i, sum - currNum, -currNum);
                getResult(num, target, rst, curr + "*" + currNum, i, sum - lastNum + lastNum * currNum, lastNum * currNum);
            }
        }

    }
}
