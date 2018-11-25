package BasicAlgorithms.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hadoop on 23/10/17.
 */
public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=s.length()-p.length();i++){
            if(i<p.length()-1){
                sb.append(s.charAt(i));
                continue;
            }
            if(i>p.length()-1){
                sb.deleteCharAt(i-p.length());
            }
            sb.append(s.charAt(i));
            if(isAnagram(sb.toString(),p)){
               list.add(i);
            }
        }
        return list;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int counter=0;
        for(int i=0;i<s.length();i++){
            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),1);
                counter++;
            }
            else {
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
                counter++;
            }
        }
        for(int i=0;i<t.length();i++){
            if(hashMap.containsKey(t.charAt(i))){
                System.out.println(hashMap);
                int freq = hashMap.get(t.charAt(i));
                freq = freq-1;
                System.out.println("t.charat"+t.charAt(i));
                System.out.println("frq"+freq);
                if(freq == 0){
                    hashMap.remove(t.charAt(i));
                }
                else {
                    hashMap.put(t.charAt(i),freq);
                }
                counter--;
            }
            else {
                return false;
            }
        }
        System.out.println(counter);
        return counter ==0;
    }
}