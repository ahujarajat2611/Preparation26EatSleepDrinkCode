package Gitbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hadoop on 15/9/17.
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, List<Character>> hashMap = new HashMap<>();
        hashMap.put(1, new ArrayList<>());
        hashMap.put(2, new ArrayList<>());
        hashMap.put(3, new ArrayList<>());
        hashMap.put(4, new ArrayList<>());
        hashMap.put(5, new ArrayList<>());
        hashMap.put(6, new ArrayList<>());
        hashMap.put(7, new ArrayList<>());
        hashMap.put(8, new ArrayList<>());
        hashMap.put(9, new ArrayList<>());
        hashMap.get(1);
        int index = 2;
        int charone = 0;
        for (char i = 0; i <= 25; i++) {
            char tobeAdded = (char) ('a' + i);
            charone++;
            if (index != 7 && index != 9 && charone == 4) {
                index = index + 1;
                charone = 1;
            }
            if ((index == 7) && charone == 5) {
                index = index + 1;
                charone = 1;
            }
            hashMap.get(index).add(tobeAdded);
        }
        System.out.println(hashMap);
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0,result,path,digits,hashMap);
        return result;
    }

    private void helper(int i, List<String> result, List<String> path, String digits, HashMap<Integer, List<Character>> hashMap) {
            if(i == digits.length()){
                String ans = new String();
                for(String a:path){
                    ans = ans+a;
                }
                result.add(ans);
                return;
            }
            for(Character c:hashMap.get(digits.charAt(i)-'0')){
                path.add(String.valueOf(c));
                helper(i+1,result,path,digits,hashMap);
                path.remove(path.size()-1);
            }
    }
}
