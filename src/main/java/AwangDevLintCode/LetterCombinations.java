package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class LetterCombinations {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return rst;
        }
        ArrayList<String[]> map = new ArrayList<String[]>();
        map.add(new String[]{});//key 0: nothing
        map.add(new String[]{});//key 1: nothing
        map.add(new String[]{"a","b","c"});
        map.add(new String[]{"d","e","f"});
        map.add(new String[]{"g","h","i"});
        map.add(new String[]{"j","k","l"});
        map.add(new String[]{"m","n","o"});
        map.add(new String[]{"p","q","r","s"});
        map.add(new String[]{"t","u","v"});
        map.add(new String[]{"w","x","y","z"});

        ArrayList<String> list = new ArrayList<String>();
        helper(rst, list, map, digits, 0);

        return rst;
    }

    public void helper(ArrayList<String> rst, ArrayList<String> list,
                       ArrayList<String[]> map, String digits, int level){
        //If level is finished, compress into string
        if (level == digits.length()) {
            StringBuffer sb = new StringBuffer();
            for (String s : list) {
                sb.append(s);
            }
            rst.add(sb.toString());
            return;
        }
        //For a specific list of candidates, face the level of chars
        int num = Integer.parseInt(digits.substring(level, level + 1));
        String[] strs = map.get(num);

        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
            helper(rst, list, map, digits, level + 1);
            list.remove(list.size() - 1);
        }
    }
}
