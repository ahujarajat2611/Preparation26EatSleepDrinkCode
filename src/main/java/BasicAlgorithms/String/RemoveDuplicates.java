package BasicAlgorithms.String;

import java.util.*;

/**
 * Created by hadoop on 15/10/17.
 */
public class RemoveDuplicates {
    public String removeDuplicateLetters(String s) {

        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),1);
            }
            else {
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }
        }
        int end =0;
        List<Character> list = new LinkedList<>();
        while (end<s.length()){
            char c= s.charAt(end);
            int freq = hashMap.get(s.charAt(end));
            freq = freq -1;
            if(freq == 0){
                hashMap.remove(s.charAt(end));
            }
            hashMap.put(s.charAt(end),freq);
            end++;
            if(list.contains(c))continue;
            while (!list.isEmpty() && c<list.get(list.size()-1) && hashMap.get(list.get(list.size()-1))>0){
                list.remove(list.size()-1);
            }
                list.add(c);
        }
        String ans = "";
        for(Character c:list) {
            ans = ans + c;
        }
        return ans;
    }
    public static void main(String ar[]){
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicateLetters("cbacdcbc"));
    }
}