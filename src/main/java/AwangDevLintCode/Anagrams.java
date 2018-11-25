package AwangDevLintCode;
import java.util.*;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Given an array of strings, return all groups of strings that are anagrams.

Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

Note
All inputs will be in lower-case

Tags Expand
String Hash Table

use int[26] assuming it's all lowercase letters
 count each string char in a letter array int[], convert the array into string.
 HashMap carray string as key, and actualy string as value
 outupt all values
 1. HashMap 的做法. sort每个string, 存进HashMap, 重复的就是anagrams,最后输出。
   toCharArray
   Arrays.sort
   Stirng.valueOf(char[])
   时间n*L*O(logL),L是最长string的长度。

2. Arrays.toString(arr)的做法。arr是int[26], assuming only have 26 lowercase letters.
Count occurrance, 然后convert to String，作为map的key.
Time complexity: nO(L)

 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> rst = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {

            // thats like basic basic thing !!! you should have in ur mind .. ellse doors are closssed straight forwrd!!
            char []array = strs[i].toCharArray();

            // THATS ONE WAY OF SORTING STRING ANOTHER WOULD BE
            StringBuilder sb = new StringBuilder(strs[i]);
            // note you can reverse only using stringbuilder but not sort it
            // to sort string you have to convert to char array and then use Arrays.sort()//
            // fuck how can you forget this !!!!!!!
            //
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            // lets keep things simple anagrams sorted would be same so keep a hashmap that has things like that !!!
            String s = String.valueOf(arr);
            if (!map.containsKey(s)) {
                ArrayList<String> list = new ArrayList<String>();
                map.put(s, list);
            }
            map.get(s).add(strs[i]);
        }
        //check instance occurs >= 2
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                rst.addAll(entry.getValue());
            }
        }
        return rst;
    }
}
