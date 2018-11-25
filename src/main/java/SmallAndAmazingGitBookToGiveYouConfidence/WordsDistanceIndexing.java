package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 22/9/17.
 */
import java.util.*;
public class WordsDistanceIndexing {
    private Map<String, List<Integer>> wordIndexMap = new HashMap<>();

    public WordsDistanceIndexing(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (wordIndexMap.containsKey(words[i])) {
                wordIndexMap.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                wordIndexMap.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        List<Integer> indexList1 = wordIndexMap.get(word1);
        List<Integer> indexList2 = wordIndexMap.get(word2);
        int index1 = 0;
        int index2 = 0;
        int mindistance = Integer.MAX_VALUE;
        while (index1 < indexList1.size() && index2 < indexList2.size()) {
            mindistance = Math.min(mindistance, indexList1.get(index1) - indexList2.get(index2));
            if (indexList1.get(index1) < indexList2.get(index2)) {
                index1++;
            } else {
                index2++;
            }
        }
        return mindistance;
    }
}
