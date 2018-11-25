package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestSubstringTwoDistinct {
     int longestsub(String s){
     int start=0;
     int end=0;
     int length = 0;
     if(s == null || s.length() ==0){
         return length;
     }
     HashMap<Character,Integer>hashMap = new HashMap<>();
     int counter=0;
     while (end<s.length()){
         if(!hashMap.containsKey(s.charAt(end))) {
             hashMap.put(s.charAt(end),1);
             counter++;
         }
         else {
             hashMap.put(s.charAt(end),hashMap.get(s.charAt(end))+1);
         }
         while (counter>2){
             System.out.println("char "+s.charAt(start));
             int startFreq = hashMap.get(s.charAt(start));
             startFreq = startFreq-1;
             System.out.println("startfre "+startFreq);
             if(startFreq == 0){
                 counter--;
                 hashMap.remove(s.charAt(start));
             }
             else {
                 hashMap.put(s.charAt(start),startFreq);
             }
             start++;
         }
         System.out.println("publish"+start);
         System.out.println("end"+end);
         length = Math.max(length,end-start+1);
         end++;
     }
     return length;

    }

    public static void main(String[] args) {
        LongestSubstringTwoDistinct longestSubstringTwoDistinct = new LongestSubstringTwoDistinct();
        System.out.println(longestSubstringTwoDistinct.longestsub("cdaba"));
    }
}
