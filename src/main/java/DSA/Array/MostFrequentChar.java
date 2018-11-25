package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class MostFrequentChar {
    public char findMostFrequentCharacter(char[] a, int n) {
        int t[] = new int[256];
        for (int i = 0; i < n; i++) {
            t[a[i]]++;
        }
        int maxCount = 0;
        char frequentChar = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > maxCount) {
                maxCount = t[i];
                frequentChar = (char) i;
            }
        }
        return frequentChar;
    }
}
