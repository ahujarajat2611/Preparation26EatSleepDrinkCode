package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
/*
Thoughts:
For word A and B.
At one time,
A can only be most close to two possible B's from left or right.
For the current A, left-B is known and right-B is unkown, but will encounter in the future.
Therefore, we always only have to keep the two index: indexA, indexB updated and always try to calculate the latest amount the two.
This is quite Greedy.
*/
public class ShorrtestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int indexWord1 = -1;
        int indexWord2 = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                indexWord1 = i;
            } else if (words[i].equals(word2)) {
                indexWord2 = i;
            }
            if (indexWord1 >= 0 && indexWord2 >= 0) {
                distance = Math.min(distance, Math.abs(indexWord2 - indexWord1));
            }
        }
        return distance;
    }
}
