package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

Hide Tags Backtracking String

*/

/*
	Thoughts:
	NOT DONE. NEED CLEAR MIND
	Break into 4 parts.
	At each index, either close it as one IP spot, or not.
		recursive down.
		If level == 4 validate if valid IP address. If so, add it.
	pass along: rst, list (store the 4 IP spots), level (0 ~ 3), s,
	for (0 ~ 2): can pick 1 digit, 2 digits, or 3 digits
*/
import java.util.*;
public class RestoreIpAddresses {
    public  List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        if (s.length() < 4 || s.length() > 12) {
            return rst;
        }
        ArrayList<String> list = new ArrayList<String>();
        helper(rst, list, 0, s);

        return rst;
    }


    public boolean isValid(String str) {
        // if first char is zero then whole string has to be zero
        // to have valid ip case
        // if starts with zero better be zero !!!
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        int num = Integer.parseInt(str);
        return num <= 255 && num >= 0;
    }
    public  void helper(List<String> rst, ArrayList<String>list,
                        int start, String s) {
        if (list.size() == 4) {
            // index should reach to end as simple as that !!!
            if (start != s.length()) {
                return;
            }
            StringBuffer sb = new StringBuffer();
            for (String str : list) {
                sb.append(str + ".");
            }
            rst.add(sb.substring(0, sb.length() - 1).toString());
            return;
        }
        //run for loop 3 times: one IP spot has at most 3 digits
        for (int i = start; i < s.length() && i <= start + 3; i++) {
            String temp = s.substring(start, i + 1);
            if (isValid(temp)) {
                list.add(temp);
                helper(rst, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
    /*
    private static void helper(int index, List<String> result, List<String> path, String s) {

        if(index == s.length()){
            if(path.size() ==4) {
                String ans = new String();
                for (String a : path) {
                    ans = ans + "." + a;
                }
                result.add(ans.substring(1));
                return;
            }
            return;
        }
        for( int i=index;i<s.length() && i<index+3;i++){
            if(isvalid(s.substring(index,i+1))){
                path.add(s.substring(index,i+1));
                helper(i+1,result,path,s);
                path.remove(path.size()-1);
            }
        }


    }

    private static boolean isvalid(String substring) {
        if(substring.startsWith("0"))
            return substring.equalsIgnoreCase("0");
        int value = Integer.parseInt(substring);
        if(value >255)return false;
        return true;
    }
     */

}
