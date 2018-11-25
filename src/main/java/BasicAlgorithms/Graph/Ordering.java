package BasicAlgorithms.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.lang.StrictMath.min;

/**
 * Created by hadoop on 17/3/18.
 */
/*
Given two input arrays, return true if the words array is sorted according to the ordering array
Input:
words = ['cc', 'cb', 'bb', 'ac']
ordering = ['c', 'b', 'a']
Output: True

Input:
words = ['cc', 'cb', 'bb', 'ac']
ordering = ['b', 'c', 'a']
Output: False


 */
public class Ordering {

    public static void main(String args[]) throws Exception {
        String words[] = { "cc", "cb", "bb", "ac" };
        char ordering[] = { 'b', 'c', 'a' };
        System.out.println(checkIfSortedArray(words, ordering));
    }

    public static boolean checkIfSortedArray(String strs[], char orderings[]) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < orderings.length; i++) {
            map.put(orderings[i], i);
        }
        for (int i = 1; i < strs.length; i++) {
            int mismatch = getFirstMismatch(strs[i - 1], strs[i]);
            if (mismatch != -1) {
                char from = strs[i - 1].toCharArray()[mismatch];
                char to = strs[i].toCharArray()[mismatch];
                if (map.get(from) > map.get(to))
                    return false;
            }
        }
        return true;
    }

    public static int getFirstMismatch(String str1, String str2) {
        char elem[] = str1.toCharArray();
        char elem2[] = str2.toCharArray();
        return IntStream.range(0, min(elem.length, elem2.length)).filter(temp -> elem[temp] != elem2[temp]).findFirst()
                .orElse(-1);
    }
}
