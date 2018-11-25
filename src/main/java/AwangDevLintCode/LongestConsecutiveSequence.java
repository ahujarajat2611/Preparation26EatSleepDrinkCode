package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */

/*
Thinking process:
0. This problem can be done using sorting, but time complexity of sorting is O(nlogn). This problem requires O(n).
1. Want to check if a number's left and right is consecutive to itself, but cannot do it due to the given unsorted array: think about a Hashmap.
2. HashMap(Key, Value) = (the number itself, boolean: have been counted or not). If you count a number as a consecutive, you only need to count it once.
3. How HashMap works:
	when checking a number's consecutive, look at number--, number++, see if they are in the HashMap. If exist, means consecutive.
	If a number exist in the hashmap and its value is 'true', then we need to skip this number beacuse it has been checked.
4. Track the total number consecutives of 1 perticular number, compare it with the maxL. Save the Math.max to maxL.
5. Depending on the problem, we can store a consecutive sequence or simply just its length: maxL. This problem wants the maxL.
*/

import java.util.*;
public class LongestConsecutiveSequence {
    /*
10.19.2015
Thougths:
1. sort
2. use a 'count' and 'max' to keep track of consecutive elements
3. one-pass

Note:
Take care of equal numbers: skip/continue those

*/
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return 1;
        }
        int count = 1;
        int max = 1;
        Arrays.sort(num);
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] == num[i]) {
                continue;
            } else if (num[i - 1] + 1 == num[i]) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }
        return max;
    }
    public int longestConsecutiveMap(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int maxL = 1;
        HashMap<Integer, Boolean> history = new HashMap<Integer, Boolean>();
        for (int i : num) {
            history.put(i, false);
        }
        for (int i : num) {
            if (history.get(i)) {
                continue;
            }
            //check ++ side
            int temp = i;
            int total = 1;
            while (history.containsKey(temp + 1)) {
                total++;
                temp++;
                history.put(temp, true);
            }
            //check -- side
            temp = i;
            while (history.containsKey(temp - 1)) {
                total++;
                temp--;
                history.put(temp, true);
            }
            maxL = Math.max(maxL, total);
        }
        return maxL;
    }
}
