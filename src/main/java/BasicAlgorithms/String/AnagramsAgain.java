package BasicAlgorithms.String;
import java.util.*;

/**
 * Created by hadoop on 19/12/17.
 */
public class AnagramsAgain {
    private int getHash(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c-'a']++;
        }
        int hash = 0;
        int base = 29;
        for (int i : count) {
            hash = hash * base + i;
        }
        return hash;
    }
    private int getHashAgain(String s){
        int []count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int hash = 0;

        int base = 29;
        for(int i=0;i<count.length;i++){
            hash = base * hash + count[i];
        }
        return hash;
    }
    public List<String> anagrams2(String[] strs) {
        List<String> res = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        for (String s : strs) {
            int hash = getHash(s);
            if (!map.containsKey(hash)) {
                ArrayList<String> item = new ArrayList<String>();
                item.add(s);
                map.put(hash, item);
            } else
                map.get(hash).add(s);
        }
        for (ArrayList<String> list : map.values()) {
            if (list.size()>1)
                res.addAll(list);
        }
        return res;
    }
}
