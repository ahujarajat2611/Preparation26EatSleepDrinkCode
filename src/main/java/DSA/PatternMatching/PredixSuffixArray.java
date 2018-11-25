package DSA.PatternMatching;

/**
 * Created by hadoop on 14/2/18.
 */
public class PredixSuffixArray {
    public static int[] prefixArray(String str) {
        //build the KMP pattern.
        int n = str.length();
        int cur = 0;
        int j = 1;
        int[] pattern = new int[n];
        pattern[0] = 0;

        while (j < n) {
            if (str.charAt(cur) == str.charAt(j)) {
                pattern[j++] = ++cur;
            } else {
                if (cur == 0) {
                    pattern[j++] = 0;
                } else {
                    cur = pattern[cur - 1];//publish from beginning of current matching pattern.
                }
            }
        }
        return pattern;
    }
    public static void matchPattern(String str,String pattern) {
        int[] patternArray = prefixArray(pattern);
        int i = 0;
        int cur = 0;
        while (i < str.length()) {
            if (str.charAt(i) == pattern.charAt(cur)) {
                if (cur == pattern.length() - 1) {
                    System.out.println("Found pattern at " + i);
                    i++;
                    cur = 0;
                }
                else {
                    i++;
                    cur++;
                }
            } else {
                if (cur > 0) {
                    cur = patternArray[cur - 1];
                } else {
                    // does it even require ?/
                    cur = 0;
                    i++;
                }
            }
        }
    }
    public static void main(String args[]){
        PredixSuffixArray predixSuffixArray = new PredixSuffixArray();
        predixSuffixArray.matchPattern("cdABABD","AB");
    }

}
