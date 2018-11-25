package BasicAlgorithms.String;

import java.util.HashMap;
import java.util.List;
import java.util.*;

class Concatenation{
static class TrieNode {
           int value = 0;
           Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
       }
       TrieNode trie;

    // build a trie tree
    public List<Integer> findSubstring(String S, String[] L) {
        trie = buildTrie(L);
        int length = getTotalLength(L);
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < S.length() - length + 1; i++) {
            if (isSubString(S, i, i + length))
                result.add(i);
        }
        return result;
    }
    
    private int getTotalLength(String[] L) {
        int sum = 0;
        for (String l : L)
            sum += l.length();
        return sum;
    }
    
    private TrieNode buildTrie(String[] L) {
        TrieNode root = new TrieNode();
        for (String l : L)
            addWord(root, l);
        return root;
    }
    
    private void addWord(TrieNode root, String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode next = node.children.get(c);
            if (next == null) {
                next = new TrieNode();
                node.children.put(c, next);
            }
            node = next;
        }
        node.value++;
    }
    
    private boolean isSubString(String S, int start, int end) {
        if (start == end)
    		return true;
        // search in the trie tree
        TrieNode node = trie;
        for (int i = start; i < end; i++) {
            char c = S.charAt(i);
            if (node.children.get(c) == null)
                return false;
            node = node.children.get(c);
            if (node.value > 0) {  // leaf & can be used
                node.value--; // mark as used
                if (isSubString(S, i + 1, end)) {
                    node.value++; // mark as unused
                    return true;
                }
                node.value++; // mark as unused
            }
        }
        return false;
    }
}