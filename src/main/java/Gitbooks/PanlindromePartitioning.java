package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 15/9/17.
 */
public class PanlindromePartitioning {
    public static void main(String[] args) {

    }
    public List<List<String>> solution(String a){
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0,result,path,a);
        return result;
    }

    private void helper(int index, List<List<String>> result, List<String> path, String a) {
            if(index == a.length()){
                result.add(new ArrayList<>(path));
                return;
            }
            for( int i=index;i<a.length();i++){
                if(validpalndromde(index,i,a)){
                    path.add(a.substring(index,i+1));
                    helper(index+1,result,path,a);
                    path.remove(path.size()-1);
                }

            }

    }

    private boolean validpalndromde(int start, int end,String s) {
        while (start<end){
            if(s.charAt(start) ==s.charAt(end)){
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
