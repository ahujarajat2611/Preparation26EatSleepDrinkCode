package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 19/1/18.
 */
/*
Maximum Product of Word Lengths
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".
Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".
Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

Brutal force is to go through all pair of words and check if all letters are unique, then calculate the product.

One way to optimize is to create a matrix in advance. One dimension is the index of the word,
 the other is 26. Go through all words and mark the character it has to 1.
  Now Go through the matrix and check if two words are all unique,
   if they are, calculate the product.

One way to optimize is to create a matrix in advance. One dimension is the index of the word, the other is 26. Go through all words and mark the character it has to 1. Now Go through the matrix and check if two words are all unique, if they are, calculate the product.
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[][] matrix = getMatrix(words);
        int product = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                boolean allUnique = true;
                for (int k = 0; k < 26; k++) {
                    if (matrix[i][k] != 0 && matrix[j][k] != 0) {
                        allUnique = false;
                        break;
                    }
                }
                product = allUnique ? Math.max(product, words[i].length() * words[j].length()) : product;
            }
        }
        return product;
    }

    private int[][] getMatrix(String[] words) {
        int[][] matrix = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int j = 0; j < curr.length(); j++)
                matrix[i][curr.charAt(j) - 'a'] = 1;
        }
        return matrix;
    }
}
