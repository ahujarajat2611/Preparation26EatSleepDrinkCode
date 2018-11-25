package SoundarCourse;

import java.util.Arrays;

public class LRS {

    // return the longest common prefix of s and t
    public static String lcp(String s, String t) {

        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);

    }


    // return the longest repeated string in s
    public static String lrs(String s) {

        // form the N suffixes
        int N  = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }
        int lcp[] = new int[N];
        // sort them
        Arrays.sort(suffixes);

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        int index = 0;
        lcp[index++] = 0;
        for (int i = 0; i < N - 1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }



    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring
    public static void main(String[] args) {
        String s = "banana";
        s = s.replaceAll("\\s+", " ");
        System.out.println("rajat");
//        StdOut.println("'" + lrs(s) + "'");
    }
}