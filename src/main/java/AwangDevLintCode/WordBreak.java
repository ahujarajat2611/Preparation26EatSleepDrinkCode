package AwangDevLintCode;

/*
DP
Attemp2, Thought:
Use boolena to denote rst[i]: s[0,i-1] can be break to match dict. For the ease to explain, let's consider rst[i+1] with actually string s[0,i];
How to calculate rst[i+1]?
    As long as there is at least 1 way to break s[0, i], that would work. so do a for loop to check on string s[0, i]:
    For each i, use another index j, j = 0 ~ i. If rst[j] works and s[j,i+1] is in dict, that makes rst[i+1] = true.

Correct: however excceeds time limit at 97% correct
*/
/**
 * Created by hadoop on 6/2/18.
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict.contains(s)) {
            return true;
        }
        boolean[] rst = new boolean[s.length() + 1];
        rst[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (rst[j] && dict.contains(s.substring(j, i + 1))) {
                    rst[i + 1] = true;
                    break;
                }
            }
        }
        return rst[s.length()];
    }

    // Very imp  concepts hidden here
    // i, j --> break at each k and see if you can construct solution {(i, k ) , (k +1,j) }
    // diagonal loop and then i , j iterator and then breakinig of k from i to j
    public boolean wordBreak(String str, int n, Set<String> dictionary) {
        boolean t[][] = new boolean[n][n];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (dictionary.contains(str.substring(i, j + 1))) {
                    t[i][j] = true;
                } else {
                    for (int k = i; k <= j; k++) {
                        t[i][j] = t[i][j] || (t[i][k] && t[k + 1][j]);
                    }
                }
            }
        }
        return t[0][n - 1];
    }
    public List<String> wordBreak2(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return rst;
        }

        boolean[][] isWord = validateWord(s, wordDict);
        boolean[] isValid = validatePossibility(s, wordDict, isWord);

        dfs(rst, new ArrayList<String>(), s, 0, isValid, isWord, wordDict);
        return rst;
    }

    public void dfs(List<String> rst, ArrayList<String> list, String s,
                    int index, boolean[] isValid, boolean[][] isWord, Set<String> set) {
        if (!isValid[index]) {
            return;
        }
        //output
        // ending recursion with index if it exceedss more than string length

        if (index >= s.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(" ");
                }
            }
            rst.add(sb.toString());
            return;
        }
        //dfs
        for (int i = index; i < s.length(); i++) {
            if (!isWord[index][i]) {
                continue;
            }
// there are possible options that can lead to result
            // in normal combinations, we do not have any condition as such all all alternativees becomes our child

            list.add(s.substring(index, i + 1));
            dfs(rst, list, s, i + 1, isValid, isWord, set);
            list.remove(list.size() - 1);
        }
    }

    //dp[i][j] check if s.substring(i,j) is a proper word from dictionary
    public boolean[][] validateWord(String s, Set<String> set) {
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                isWord[i][j] = set.contains(s.substring(i, j + 1));
            }
        }
        return isWord;
    }

    //Build the validation boolean[]
    public boolean[] validatePossibility(String s, Set<String> set, boolean[][] isWord) {
    	/*
    	boolean[] valid = new boolean[s.length() + 1];
    	valid[s.length()] = true;

    	int maxLeng = getMaxLength(set);
    	for (int i = s.length() - 1; i >= 0; i--) {
    		for (int j = i; j < s.length() && (j - i) <= maxLeng; j++) {
    			if (isWord[i][j] && valid[j + 1]) {
    				valid[i] = true;
    				break;
    			}
    		}
    	}*/
//        boolean[] valid = new boolean[s.length() + 1];
//        valid[0] = true;
//        int maxLength = getMaxLength(set);
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < i && j < maxLength; j++) {//iterate [0 ~ i]
//                if (isWord[i - j][i] && isValid[i - j + 1])) {
//                    valid[i + 1] = true;
//                    break;
//                }
//            }
//        }
//
//        return valid;

        boolean[] rst = new boolean[s.length() + 1];
        rst[0] = true;
        if (s == null || set.contains(s)) {
            return rst;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (rst[j] && set.contains(s.substring(j, i + 1))) {
                    rst[i + 1] = true;
                    break;
                }
            }
        }
        return rst;
    }

    //Get max length, a little optimization
    public int getMaxLength(Set<String> dict) {
        int length = 0;
        for (String word : dict) {
            length = Math.max(length, word.length());
        }
        return length;
    }

}


/*
Word break brute force
    public static boolean wordBreak(String s, List<String> dict,Map<String,Boolean> set){

        System.out.println("string is "+s);
        if(dict.contains(s)){
            return true;
        }
        if(s.length() == 1) return false;

        if(set.containsKey(s)) return set.get(s);
        for(int i=0;i<s.length();i++){

            if(!set.containsKey(s.substring(0,i+1))){
                set.put(s.substring(0,i+1),wordBreak(s.substring(0,i+1),dict,set));
            }
            if(!set.containsKey(s.substring(i+1,s.length()))){
                set.put(s.substring(i+1,s.length()),wordBreak(s.substring(i+1,s.length()),dict,set));
            }

            if(wordBreak(s.substring(0,i+1),dict,set) && wordBreak(s.substring(i+1,s.length()),dict,set)){
                set.put(s,true);
                return true;
            }
            else {
                set.put(s,false);
            }
        }
        return false;
    }
 */