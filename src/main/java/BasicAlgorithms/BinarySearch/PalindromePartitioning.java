package BasicAlgorithms.BinarySearch;

import java.util.*;
public class PalindromePartitioning{
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<List<String>>();
        List<String> temp = new LinkedList<String>();
        helper(result, temp, 0, s);
        return result;
    }
    private void helper(List<List<String>> result, 
    List<String> temp, int pos, String s){
        if (pos == s.length()){
            result.add(new LinkedList<String>(temp));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++){
            String sub = s.substring(pos, i);
            if (!isPalindrome(sub)){
                continue;
            }
            temp.add(sub);
            helper(result, temp, i, s);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}