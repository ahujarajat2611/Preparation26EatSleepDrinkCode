package AwangDevLintCode;

/**
 * Created by hadoop on 5/2/18.
 */
/*
Given a string and a string dictionary, find the longest string
in the dictionary that can be formed
by deleting some characters of the given string.
 If there are more than one possible results, return the longest word with the
  smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output:
"a"
 */
import java.util.*;
public class LongestWordDictionary {
    private boolean isSubSeq(String s, String p) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == p.length();
    }

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else {
                    return o2.length()-o1.length();
                }
            }
        });
        for(String a:d){
            // System.out.println(a);
            if(isSubSeq(s,a)){
                return a;
            }
        }
        return "";
    }
    /*
    Given a list of strings words representing an English Dictionary,
     find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
     */
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        final ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        Collections.sort(wordList, new Comparator<String>(){
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        final ArrayList<String> result = matchWords(wordList);
        Collections.sort(result);

        if (result.size() != 0) {
            return result.get(0);
        }
        return null;
    }

    private ArrayList<String> matchWords(final ArrayList<String> wordList) {
        int maxWordLength = Integer.MIN_VALUE;
        final ArrayList<String> result = new ArrayList<>();
        for (int i = wordList.size() - 1; i >= 0; i--) {
            String word = wordList.get(i);
            // Validate if word can be built by with wordList
            while(word.length() != 0) {
                if (wordList.contains(word)) {
                    if (word.length() == 1) {
                        if (wordList.get(i).length() < maxWordLength) {
                            return result;
                        } else {
                            result.add(wordList.get(i));
                            maxWordLength = wordList.get(i).length();
                        }
                    }
                    word = word.substring(0, word.length() - 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
