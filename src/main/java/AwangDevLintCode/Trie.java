package AwangDevLintCode;

import java.util.*;


public class Trie {
    private class TrieNode {
        char c;
        boolean isEnd = false;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        // Initialize your data structure here.
        public TrieNode() {
        }
        public TrieNode(char c) {
            this.c = c;
        }
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        HashMap<Character, TrieNode> children = node.children;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (!children.containsKey(c)) {
        		TrieNode newNode = new TrieNode(c);
        		children.put(c, newNode);
        	}
        	node = children.get(c);
        	children = node.children;
        	if (i == word.length() - 1) {
        		node.isEnd = true;
        	}
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        HashMap<Character, TrieNode> children = node.children;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (!children.containsKey(c)) {
        		return false;
        	} else {
        		node = children.get(c);
        		children = node.children;
        	}
			if (i == word.length() - 1) {
        		return node.isEnd;
        	}
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        HashMap<Character, TrieNode> children = node.children;
        for (char c : prefix.toCharArray()) {
        	if (!children.containsKey(c)) {
        		return false;
        	} else {
        		node = children.get(c);
        		children = node.children;
        	}
        }
        return true;
    }
}