package BasicAlgorithms.HashTable;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class PalindromPairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words.length ==0){
            return res;
        }

        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            hashMap.put(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)){
                    String reversedStr2 = new StringBuilder((str2)).reverse().toString();
                    if(hashMap.containsKey(reversedStr2) && hashMap.get(reversedStr2)!=i){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(hashMap.get(reversedStr2));
                        res.add(list);
                    }
                }
                if(isPalindrome(str2)){
                    String reversedStr1 = new StringBuilder((str1)).reverse().toString();
                    if(hashMap.containsKey(reversedStr1) && hashMap.get(reversedStr1)!=i && reversedStr1!=""){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(hashMap.get(reversedStr1));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}