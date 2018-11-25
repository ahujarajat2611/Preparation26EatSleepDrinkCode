package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 15/10/17.
 */
public class LongestSubstringKdistinctChar {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int counter=0;
        int start=0;
        int end =0;
        int dis =0;
        while (end<s.length()){
            if(!hashMap.containsKey(s.charAt(end))){
                counter++;
                hashMap.put(s.charAt(end),1);
            }
            else {
                hashMap.put(s.charAt(end),hashMap.get(s.charAt(end))+1);
            }
            while (counter>k){
                int freq = hashMap.get(s.charAt(start));
                freq= freq-1;
                if(freq == 0){
                    counter--;
                    hashMap.remove(s.charAt(start));
                }
                else {
                    hashMap.put(s.charAt(start), freq);
                }
                start++;
            }
            dis = Math.max(dis,end-start+1);
            end++;
        }
        return dis;
    }
}
