package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
import java.util.*;
public class ValidAbbrervation {
    /*
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true

Tags: Hash Table, Design
Similar Problems: (E) Two Sum III - Data structure design



*/
/*
Thought:
Originally,
 used a hashset to store all existing pattern.
  If checked word exist in dict hashset,
  then return false.
However, there is a case that: the word existed in the dict only for once, which is by accident the same as the checked work, then return true.
Therefore, we need to keep track of what word has been catagrize into pattern. SO, use a HashMap<String, ArrayList> instead.

Note: Dealing with char, integer, string. Be careful if char are turnning int integers.
*/
        HashMap<String, ArrayList<String>> map;
        public ValidAbbrervation(String[] dict) {
            if (dict == null || dict.length == 0) {
                return;
            }
            map = new HashMap<String, ArrayList<String>>();
            for (String s : dict) {
                String str = "";
                if (s.length() <= 2) {
                    str = s;
                } else {
                    str += s.charAt(0) + (s.length() - 2 + "") + s.charAt(s.length() - 1);
                }
                if (!map.containsKey(str)) {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(s);
                    map.put(str, list);
                } else {
                    // we dont have put duplicate strings as well in
                    // like we need to handle cases where duplicates values are coming to our system for that
                    // map.get().contains to check if it is already added into our system !!!
                    if (!map.get(str).contains(s)) {
                        map.get(str).add(s);
                    }

                }
            }
        }

        public boolean isUnique(String word) {
            if (map == null || map.size() == 0) {
                return true;
            }
            String str = "";
            if (word.length() <= 2) {
                str =  word;
            } else {
                str += word.charAt(0) + (word.length() - 2 + "") + word.charAt(word.length() - 1);
            }
            // it is kind of indexing in hashmap .. --> you index via abbrevations and see if on that
            // index oonly one item is present and use equals method on that one vlaue !!!
            if (map.containsKey(str) && map.get(str).size() == 1 && map.get(str).get(0).equals(word)) {
                return true;
            }
            // if it does not contains key then fuck it has to return true /// there was problem in understaing this problem
            //
            return !map.containsKey(str);
        }
}
