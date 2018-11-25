package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 14/10/17.
 */
public class PermutationPalindrome {
    public boolean canPermutePalindrome(String s) {
        int i=0;
        int j = s.length()-1;
        HashMap<Character,Integer> hashMap= new HashMap<>();
        for(char c:s.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.remove(c);
            }
            else {
                hashMap.put(c,1);
            }
        }
        return hashMap.size()<=1;
    }
}