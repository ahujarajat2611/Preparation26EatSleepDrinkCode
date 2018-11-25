package DSA.Dp;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 19/2/18.
 */
public class DecodeWays {
    public static int decodeWaysDp(String str) {
        int t[] = new int[str.length() + 1];
        t[0] = t[1] = 1;
        for (int i = 2; i <= str.length(); i++) {

            if (str.charAt(i - 1) > '0') {
                t[i] = t[i - 1];
            }

            if ((str.charAt(i - 2) > '0' && str.charAt(i - 2) < '2')
                    || (str.charAt(i - 2) == '2' && str.charAt(i - 1) < '7')) {
                t[i] += t[i - 2];
            }
        }
        ConsoleWriter.printArray(t);
        return t[str.length()];
    }

    // Time : O(2^n)
    public static int decodeWaysBruteForce(String str, int n) {
        if (0 == n || 1 == n)
            return 1;
        int count = 0;
        if (str.charAt(n - 1) > '0') {
            count = decodeWaysBruteForce(str, n - 1);
        }
        if ((str.charAt(n - 2) > '0' && str.charAt(n - 2) < '2')
                || (str.charAt(n - 2) == '2' && str.charAt(n - 1) < '7')) {
            count += decodeWaysBruteForce(str, n - 2);
        }
        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int result = decodeWaysBruteForce("1203", 4);
        System.out.println(result);

        result = decodeWaysDp("1203");
        System.out.println(result);



    }
}

