import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestChain {

    // One more solution apart from DFS is BFS from longest node !
    // and
    // then likewise keep geenrtaing states
    // from that word by removing one
    // word and keep checking if word exsist in the dictiionary !!!
    // so you can keep track of how much level you can traverse and thats how you
    // can keep track of maximum lelve height
    public static void main(String[] args) {
        String[] words = {
                "a",
                "b",
                "ba",
                "bca",
                "bda",
                "bdca"
        };
        System.out.println("Longest Chain Length : " + longest_chain(words));
    }

    static int longest_chain(String[] w) {
        if (null == w || w.length < 1) {
            return 0;
        }

        int maxChainLen = 0;

        HashSet<String> words = new HashSet<>(Arrays.asList(w));
        HashMap<String, Integer> wordToLongestChain = new HashMap<>();

        for (String word : w) {
            if (maxChainLen > word.length()) {
                continue;
            }
            int curChainLen = find_chain_len(word, words, wordToLongestChain) + 1;
            /// keeping visited + ans in the hashmap
            // very nicely done !!!
            wordToLongestChain.put(word, curChainLen);
            maxChainLen = Math.max(maxChainLen, curChainLen);
        }
        return maxChainLen;
    }

    // word is the staring point
    // andd all possible options like removing each char from that
    // thats the deal
    static int find_chain_len(String word, HashSet<String> words, HashMap<String, Integer> wordToLongestChain) {
        int curChainLen = 0;
        for (int i = 0; i < word.length(); i++) {
            String nextWord = word.substring(0, i) + word.substring(i + 1);
            System.out.println(word);
            System.out.println(nextWord);
            System.out.println("====");
            if (words.contains(nextWord)) {
                // if it is already visted
                // then pleasse get the anss from visited state

                if (wordToLongestChain.containsKey(nextWord)) {
                    curChainLen = Math.max(curChainLen, wordToLongestChain.get(nextWord));
                } else {
                    int nextWordChainLen = find_chain_len(nextWord, words, wordToLongestChain);
                    curChainLen = Math.max(curChainLen, nextWordChainLen + 1);
                }
            }
        }
        // hashmap could have been updated here
        // would have been much better i think
        // its mixx of dfs + dp
        // BFS  also could have been user
        // considdering its a graph problme !!!
        return curChainLen;
    }
}