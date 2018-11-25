package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 15/9/17.
 */
public class RestoreIpAddress {
    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        String s="255255255255";
        helper(0,result,path,s);
        System.out.println(result);
    }

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

}
