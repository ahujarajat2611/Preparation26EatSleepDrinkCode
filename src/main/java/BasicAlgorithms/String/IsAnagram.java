package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 14/10/17.
 */
public class IsAnagram {
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

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        isAnagram.isAnagram("aacc","ccac");
    }
}