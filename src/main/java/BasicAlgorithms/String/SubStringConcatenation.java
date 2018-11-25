package BasicAlgorithms.String;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

/**
 * Created by hadoop on 15/10/17.
 */
public class SubStringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, !map.containsKey(word) ? 1 : map.get(word) + 1);
        }
        System.out.println(map);
        int start=0;
        int end=0;
        int counter =0;
        int wordlength = words[0].length();
        int totallength = wordlength*words.length;
        for(int i=0;i<s.length()-totallength+1;i++){
            String substring = s.substring(i,i+totallength);
            System.out.println("sub   "+substring);
            if(search(substring,map,wordlength)){
                list.add(i);
            }
        }
        return list;

    }

    private boolean search(String substring, HashMap<String, Integer> map, int wordlength) {
        HashMap<String,Integer> clone = new HashMap<>();
        for(int i=0;i<substring.length()-wordlength+1;i=i+wordlength){
            String sub = substring.substring(i,i+wordlength);
            System.out.println("sub sub "+sub);
            Integer freq = map.get(sub);
            if(freq == null){
                return false;
            }
            freq = freq -1;
            if(freq == 0){
                map.remove(sub);
            }
            else {
                map.put(sub,freq);
            }
        }
        return true;
    }
    public static void main(String args[]){
        SubStringConcatenation subStringConcatenation = new SubStringConcatenation();
        String s= "barfoothefoobarman";
        String words[]={"foo", "bar"};
        System.out.print(subStringConcatenation.findSubstring(s,words));
    }
}