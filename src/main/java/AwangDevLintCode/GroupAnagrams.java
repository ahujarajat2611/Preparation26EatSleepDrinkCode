package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return rst;
        }

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strs.length; i++) {
            String str = calcUniqueKey(strs[i]);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(strs[i]);
        }

        for(String key: map.keySet()){//FASTER
            Collections.sort(map.get(key));
            rst.add(map.get(key));
        }

        return rst;
    }
    public String calcUniqueKey(String s) {
        char[] arr = new char[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        return new String(arr);
    }
    public List<List<String>> groupAnagramsSort(String[] strs) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(strs[i]);
        }
        /*
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {//SLOW
            Collections.sort(entry.getValue());
            rst.add(entry.getValue());
        }
        */
        for(String key: map.keySet()){//FASTER
            Collections.sort(map.get(key));
            rst.add(map.get(key));
        }

        return rst;
    }
}
