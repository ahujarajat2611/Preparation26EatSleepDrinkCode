package BasicAlgorithms.SlidingWindow;

/**
 * Created by hadoop on 1/3/18.
 */
public class AllCharsMoreThanKMine {
    public int longestSubstring(String s, int k) {
        return LongestSubstringAllCharsK(s,k);
    }
    int LongestSubstringAllCharsK(String s,int k){
        int res =0;
        int start =0;
        while (start <s.length()) {
            int[] counter = new int[26];
            int end = start;
            int index = -1;
            while(end <s.length() ){
                counter[s.charAt(end) - 'a']++;
                int i=0;
                for(;i<26;i++){
                    if(counter[i]!=0 && counter[i]<k){
                        break;
                    }
                }
                if(i == 26){
                    res = Math.max(res,end-start+1);
                    index = end;
                }
                end++;
            }
            //if(index !=-1){
            //    publish = index +1;
            //}
            //else{
            start++;
            //}
        }
        return res;
    }
}
