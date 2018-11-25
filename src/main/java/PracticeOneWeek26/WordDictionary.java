package PracticeOneWeek26;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    class TrieNode{
        HashMap<Character, TrieNode> children;
        boolean isEnd;
        
        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isEnd = false;
        }
    }
    
    TrieNode root;
    public WordDictionary(){
        this.root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    public boolean searchHelper(TrieNode root, String word, int index) {
        if (index == word.length()) {
            return root.isEnd;
        }
        TrieNode node = root;
        char c = word.charAt(index);
        //border conditon:
        if (node.children.containsKey(c)) {
            return searchHelper(node.children.get(c), word, index + 1);
        } else if (c == '.'){
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                if (searchHelper(entry.getValue(), word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        } 
    }
}