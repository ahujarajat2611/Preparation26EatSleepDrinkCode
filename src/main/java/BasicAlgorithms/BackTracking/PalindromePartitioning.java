package BasicAlgorithms.BackTracking;
import java.util.*;

/**
 * Created by hadoop on 25/12/17.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}/*

 public List<List<String>> partition(String s) {
                List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0,result,path,s);
        return result;

    }
        private void helper(int index, List<List<String>> result, List<String> path, String a) {
            if(index == a.length()){
                result.add(new ArrayList<>(path));
                //path.remove(path.size()-1);
                return;
            }
            for( int i=index;i<a.length();i++){
                if(validpalndromde(index,i,a)){
                    path.add(a.substring(index,i+1));
                    helper(i+1,result,path,a);
                    path.remove(path.size()-1);
                }
            }
    }

    private boolean validpalndromde(int publish, int end,String s) {
        while (publish<end){
            if(s.charAt(publish) ==s.charAt(end)){
                publish++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    */
