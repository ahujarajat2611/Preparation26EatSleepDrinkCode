package BasicAlgorithms.TwoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
Reverse Words in a String III
Source

    Interview Question from Uber

    The question is almost the same as Reverse Words in a String.

    However, when reversing words, keep all punctuations in the original positions.

    Example

    Given s = "the... sky is blue.",

    return "blue... is sky the.".

    Note

        There can be leading and trailing spaces, but the result should not contain leading and trailing spaces.
        There can be mutilple consecutive spaces, the result should only contain one space
        The can be mutilple consecutive punctuations, but in this case, there is no spaces between them, the result should has no space before punctuation but has one space after it.

Analysis

The idea is to use a map to record the position of each punctuation.
Complexity

Time: O(N)

Space: O(N)
Code
Java
 */

public class ReverseString {

  public static String reverseString(String s) {
    Map<Integer, String> punctuationMap = new HashMap<>();
    Stack<String> wordStack = new Stack<>();
    int start = 0;
    int end = 0;
    int wordCount = 0;
    while (end < s.length()) {
      start = end;
      while (start < s.length() && s.charAt(start) == ' ') {  // skip spaces
        start++;
      }
      if (start == s.length()) {
        break;
      }
      end = start + 1;
      while (end < s.length() && Character.isLetter(s.charAt(end))) {
        System.out.println(s.charAt(end));
        end++;
      }
      wordCount++;
      if (Character.isLetter(s.charAt(end - 1))) {
        wordStack.push(s.substring(start, end));
      } else {  // record the position of punctuation
        punctuationMap.put(wordCount, s.substring(start, end));
      }
    }

    StringBuilder sb = new StringBuilder();
    if (punctuationMap.containsKey(1)) {
      sb.append(punctuationMap.get(1));
    } else {
      sb.append(wordStack.pop());
    }
    for (int i = 2; i <= wordCount; i++) {
      if (punctuationMap.containsKey(i)) {
        sb.append(punctuationMap.get(i));
      } else {
        sb.append(" " + wordStack.pop());
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "the,,,, sky is blue.";
    System.out.println(reverseString(str));
  }
}
