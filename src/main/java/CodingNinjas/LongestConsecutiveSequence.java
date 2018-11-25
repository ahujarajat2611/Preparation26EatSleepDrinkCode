package CodingNinjas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by hadoop on 11/10/17.
 */
public class LongestConsecutiveSequence {
    public static void main(String args[]) {
        System.out.println(methodcall());
    }

    static int methodcall() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int index = 0;
        int[] array = new int[i];
        Set set = new HashSet<>();
        while (i-- > 0) {
            array[index] = sc.nextInt();
            set.add(array[index]);
            index++;
        }
        int ans = Integer.MIN_VALUE;
        for (int k = 0; k < array.length; k++) {
            if (set.remove(array[k])) {
                int size = 1;
                int val = array[k];
                while (set.remove(val - 1)) {
                    val = val - 1;
                }
                size = size + (array[k] - val);

                val = array[k];

                while (set.remove(val + 1)) {
                    val = val + 1;
                }
                size = size + (val - array[k]);

                ans = Math.max(size, ans);
            }
        }
        return ans;
    }
}
