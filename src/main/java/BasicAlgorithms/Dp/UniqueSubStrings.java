package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 15/1/18.
 */
/*
After failed with pure math solution and time out with DFS solution, I finally realized that this is a DP problem…
The idea is, if we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z', then the summary of them is the answer. Why is that?

The max number of unique substring
ends with a letter equals to the length of
 max contiguous substring ends with that
 letter. Example "abcd", the max number
  of unique substring ends with 'd' is 4, apparently they are "abcd", "bcd", "cd" and "d".
If there are overlapping, we only need to consider the longest one because it covers all the possible substrings. Example: "abcdbcd", the max number of unique substring ends with 'd' is 4 and all substrings formed by the 2nd "bcd" part are covered in the 4 substrings already.
No matter how long is a contiguous substring in p, it is in s since s has infinite length.
Now we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z' and those substrings are all in s. Summary is the answer, according to the question.
Hope I made myself clear…
 */
public class UniqueSubStrings {
    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];

        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }

        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}

/*
O(n^3) check each substr, a hashtable is used to remove duplicate strings.
    int findSubstringInWraproundString(string p) {
        int n = p.size();
        unordered_set<string> ht;
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++) {
                if(j>i && p[j-1]+1!=p[j] && p[j-1]-p[j]!=25) break;
                ht.insert(p.substr(i,j-i+1));
            }
        return ht.size();
    }
O(n^2 logn), Each valid substr can be represented by the first char and the length, instead of the whole string.
    int findSubstringInWraproundString(string p) {
        int n = p.size();
        set<pair<char,int>> bst;
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++) {
                if(j>i && p[j-1]+1!=p[j] && p[j-1]-p[j]!=25) break;
                bst.insert(pair<char,int>(p[i],j-i+1));
            }
        return bst.size();
    }
O(n^2). For substrs starting at the same char, we only need to record the longest one. Because it covers all the shorter substrs starting from the char. The length is the number of substrings starting at the char.
    int findSubstringInWraproundString(string p) {
        int n = p.size(), len[26]={0};
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++) {
                if(j>i && p[j-1]+1!=p[j] && p[j-1]-p[j]!=25) break;
                len[p[i]-'a'] = max(len[p[i]-'a'],j-i+1);
            }
        return accumulate(len,len+26,0);
    }
 */