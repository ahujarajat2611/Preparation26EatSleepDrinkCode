package SoundarCourse;

import java.util.Arrays;

/**
 * Created by hadoop on 16/10/17.
 */

public class Asthon {

    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    public static char lrs(String s) {

        int N  = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }
        String lcp[] = new String[N];
        Arrays.sort(suffixes);

        String lrs = "";
        int index = 0;
        lcp[index++] = "";
        for (int i = 0; i < N - 1; i++) {
            lcp[index++] = lcp(suffixes[i], suffixes[i+1]);
        }
        System.out.println(index);
        int numberofstrings = 0;

        for(int i=0;i<N;i++){

            int diffferentsubstrings =  (suffixes[i].length() *(suffixes[i].length()+1))/2;
            int commonsubstrings = (lcp[i].length()*(lcp[i].length()+1))/2;
            diffferentsubstrings = diffferentsubstrings-commonsubstrings;
            numberofstrings = numberofstrings + diffferentsubstrings;
            if(numberofstrings < 2){
                continue;
            }
            System.out.println("diffferentsubstrings"+diffferentsubstrings);
            numberofstrings = numberofstrings-diffferentsubstrings;
            System.out.println(numberofstrings);
            for(int p=lcp[i].length();p<suffixes[i].length();p++){
                    numberofstrings = numberofstrings+(p+1);
                if(numberofstrings>=2){
                    System.out.println("final"+numberofstrings);
                    System.out.println(suffixes[i]);
                    System.out.println(suffixes[i].charAt((numberofstrings-2)));
                    return suffixes[i].charAt((numberofstrings-2));
                }
            }
        }
        return ' ';
    }


    public static void main(String[] args) {
        String s = "dbac";
        s = s.replaceAll("\\s+", " ");
        lrs(s);
    }
}