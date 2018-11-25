package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestSubstringWithoutRepeatingChar {
    int longestSubstring(String s){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int start=0;
        int end =0;
        int counter =0;
        int maxlength = 0;
        while (end<s.length()){
            if(!hashMap.containsKey(s.charAt(end))){
                hashMap.put(s.charAt(end),1);
            }
            else {
                hashMap.put(s.charAt(end),hashMap.get(s.charAt(end))+1);
                counter++;
            }
            while (counter>0){
                Integer startfreq = hashMap.get(s.charAt(start));
                System.out.println(startfreq);
                startfreq = startfreq-1;
                if(startfreq ==1){
                    counter--;
                }
                if(startfreq ==0){
                    hashMap.remove(s.charAt(start));
                }
                else {
                    hashMap.put(s.charAt(start),startfreq);
                }
                start++;
            }
            maxlength = Math.max(maxlength,end-start+1);
            end++;
        }
        return maxlength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar longestSubstringWithoutRepeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println(longestSubstringWithoutRepeatingChar.longestSubstring("pwwkew"));
    }
}
