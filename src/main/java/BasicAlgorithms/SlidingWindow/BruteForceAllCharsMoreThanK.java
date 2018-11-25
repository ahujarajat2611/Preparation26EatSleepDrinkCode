package BasicAlgorithms.SlidingWindow;

/**
 * Created by hadoop on 21/12/17.
 */
public class BruteForceAllCharsMoreThanK {

    int LongestSubstringAllCharsK(String s,int k){
        int i=0;
        int res =0;
        while (i + k <s.length()) {
            int[] counter = new int[26];
            int maxIndex =i;
            for (int j = i; j < s.length(); j++) {
                counter[s.charAt(j) - 'a']++;
                boolean allmorethank = true;
                for (int p = 0; i < 26; p++) {
                    if (counter[p] != 0 && counter[p] < k) {
                        allmorethank = false;
                        break;
                    }
                }
                if (allmorethank) {
                    res = Math.max(res, j - i + 1);
                    maxIndex = j;
                }
            }
            i = maxIndex+1;
        }
        return res;
    }
}
