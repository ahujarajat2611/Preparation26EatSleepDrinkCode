package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 15/10/17.
 */
public class MinWindowString {
    public String minWindow(String s, String t) {

        int start=0;
        int end = 0;
        HashMap<Character,Integer>shortMap = new HashMap<>();
        int counter=0;
        for(char c:t.toCharArray()){
            if(shortMap.containsKey(c)){
                shortMap.put(c,shortMap.get(c)+1);
                counter++;
            }
            else {
                counter++;
                shortMap.put(c,1);
            }
        }
        String ans = new String();
        int i=0;
        int j=0;
        int leng =Integer.MAX_VALUE;

        HashMap<Character,Integer> longMap = new HashMap<>();
        int totalcount=0;
        while (end<s.length()){
            if(!shortMap.containsKey(s.charAt(end))){
                end++;
                continue;
            }
            if(!longMap.containsKey(s.charAt(end))){
                longMap.put(s.charAt(end),1);
            }
            else {
                longMap.put(s.charAt(end),longMap.get(s.charAt(end))+1);
            }
            if(longMap.get(s.charAt(end))<=shortMap.get(s.charAt(end))){
                counter--;
            }

            // we have found solution ... now trying to optimse
            while (counter<=0){
                if(end-start+1<leng){
                    i = start;
                    j = end;
                    leng = end-start+1;
                    System.out.println("ans"+leng);
                }
                Integer frq = longMap.get(s.charAt(start));
                if(frq == null){
                    start++;
                    continue;
                }
                if(frq>shortMap.get(s.charAt(start))){
                }
                else {
                    counter++;
                }
                frq--;
                if(frq == 0) {
                    longMap.remove(s.charAt(start));
                }
                else {
                    longMap.put(s.charAt(start),frq);
                }
                start++;
            }

            end++;
        }
        return s.substring(i,j+1);
    }
    public static void main(String args[]){
        MinWindowString minWindowString = new MinWindowString();
        System.out.println(minWindowString.minWindow("ADOBECODEBANC","ABC"));
    }
}