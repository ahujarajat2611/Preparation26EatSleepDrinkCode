package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 21/1/18.
 */
/*
Gray code
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative Integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
This problem is not a special one. Typical recursion follows Gray code rules. If n = 1, put 0 and 1 into the list and return. From n = 2, get grayCode(n - 1). Reverse the list ((0, 1) -> (1, 0)), add the reversed list by 1 << (n - 1), (1, 0) -> (11, 10), add the reversed list to the rst list and we are done!
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<Integer> ();
        if (n <= 1){
            for(int i = 0; i <= n; i++)
                rst.add(i);
            return rst;
        }
        List<Integer> reverseRst = grayCode(n - 1);
        rst = new ArrayList(reverseRst);
        Collections.reverse(reverseRst);
        int x = (1 << (n - 1));
        for(int i = 0; i < reverseRst.size(); i++){
            reverseRst.set(i, reverseRst.get(i) + x);
        }
        rst.addAll(reverseRst);
        return rst;
    }
}
