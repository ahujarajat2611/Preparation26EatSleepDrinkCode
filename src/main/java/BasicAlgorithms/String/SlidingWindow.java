package BasicAlgorithms.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hadoop on 15/10/17.
 */
public class SlidingWindow {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s == null){
            return list;
        }
        if(words.length == 0){
            return list;
        }

        int length = words[0].length();
        int totalwords = words.length;
        if(length == 0){
            return list;
        }
        HashMap<String,Integer> wordsCount = new HashMap<>();
        for (String w : words) {
            if (wordsCount.containsKey(w)) {
                wordsCount.put(w, wordsCount.get(w) + 1);
            } else {
                wordsCount.put(w, 1);
            }
        }

        for(int i=0;i<length;i++) {
            int start = i;
            int end = i;
            HashMap<String, Integer> partMap = new HashMap<>();
            int counter = 0;
            while (end < s.length() - length + 1) {
                String sub = s.substring(end, end + length);
                if (wordsCount.containsKey(sub)) {
                    if (partMap.containsKey(sub)) {
                        partMap.put(sub, partMap.get(sub) + 1);
                        counter++;
                    } else {
                        partMap.put(sub, 1);
                        counter++;
                    }
                    while (partMap.get(sub) > wordsCount.get(sub)) {
                        String startword = s.substring(start,start + length);
                        partMap.put(startword, partMap.get(startword) - 1);
                        counter--;
                        start = start+length;
                    }
                    if (counter == totalwords) {
                        list.add(start);
                    }
                } else {
                    // this is addition step apart from sliding window.....
                    //
                    partMap.clear();
                    counter = 0;
                    start = end + length;
                }
                end = end + length;
            }
        }
        return list;
    }
    public static void main(String args[]){
        SlidingWindow slidingWindow = new SlidingWindow();
        String s= "barfoothefoobarman";
        String []words= {"foo", "bar"};
        System.out.println(slidingWindow.findSubstring(s,words));
    }
}