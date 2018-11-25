package PracticeOneWeek26;
import java.util.*;
public class ValidWordAbbr {
    HashMap<String, ArrayList<String>> map;
    public ValidWordAbbr(String[] dict) {
        if (dict == null || dict.length == 0) {
        	return;
        }
        map = new HashMap<String, ArrayList<String>>();
        for (String s : dict) {
        	String str = "";
        	if (s.length() <= 2) {
        		str = s;
        	} else {
        		str += s.charAt(0) + (s.length() - 2 + "") + s.charAt(s.length() - 1);
        	}
        	if (!map.containsKey(str)) {
        		ArrayList<String> list = new ArrayList<String>();
 				list.add(s);
 				map.put(str, list);
        	} else {
        	    if (!map.get(str).contains(s)) {
        	       	map.get(str).add(s); 
        	    }
        	
        	}
        }
    }

    public boolean isUnique(String word) {
        if (map == null || map.size() == 0) {
            return true;
        }
        String str = "";
        if (word.length() <= 2) {
        	str =  word;
        } else {
        	str += word.charAt(0) + (word.length() - 2 + "") + word.charAt(word.length() - 1);
        }
        if (map.containsKey(str) && map.get(str).size() == 1 && map.get(str).get(0).equals(word)) {
        	return true;
        }
        return !map.containsKey(str);
    }
}