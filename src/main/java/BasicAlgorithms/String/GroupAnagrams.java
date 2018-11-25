package BasicAlgorithms.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hadoop on 14/10/17.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        for (String word : strs) {
            int hashCode = getHashCode(word);
            if (!hashMap.containsKey(hashCode)) {
                hashMap.put(hashCode, new ArrayList<>());
            }
            hashMap.get(hashCode).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(hashMap.values());
        return result;
    }
    int getHashCode(String word){
        int []hashing = new int[26];
        generatecount(hashing,word);
        int seed = 31;
        int hashcode = 0;
        for(int x:hashing){
            hashcode = hashcode*31 + x;
        }
            return hashcode;
        }

    private void generatecount(int[] hashing, String word) {
        for(char a:word.toCharArray()){
            hashing[a-'a']++;
        }
    }
}