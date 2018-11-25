package AwangDevLintCode;

import java.util.*;

/**
 * Created by hadoop on 13/10/17.
 */
public class AutoComplete {
    TrieNode root;
    public AutoComplete(){
        root = new TrieNode("");
    }

    public void insertWord(String word){
        TrieNode current = root;
        // walwyas publish from root !!!
        // autocomplete would have root node always with him !!!

        for(int i=0;i<word.length();i++){
            TrieNode children =current.children.get(word.charAt(i));
            if(children == null){
                children = new TrieNode(word.substring(0,i+1));
                current.children.put(word.charAt(i),children);
            }
            current = children;
            if(i == word.length()-1){
                children.isWord = true;
            }
        }
    }
    public void insertShort(String s){
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            // thats the approach we should take if map does not have that character's tried node
            // create first
            if(!curr.children.containsKey(s.charAt(i))){
                curr.children.put(s.charAt(i),new TrieNode(s.substring(0,i+1)));
            }
            // then move to next for everyone since we have created in case it does nt exisst
            curr = curr.children.get(s.charAt(i));
            if(i == s.length()-1){
                // end of word very imp !!!
                curr.isWord = true;
            }
        }
    }
    public boolean search(String s){
        if(s == null || s.length() ==0){
            return false;
        }
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            if(!curr.children.containsKey(s.charAt(i))){
                return false;
            }
            curr = curr.children.get(s.charAt(i));
            if(curr == null){
                return false;
            }
        }
        return curr.isWord;
    }
    public List<String> getAllWordsForPrefix(String s){
        List<String> results = new ArrayList<>();
        TrieNode curr = root;
        for( int i=0;i<s.length();i++){
            if(curr.children.containsKey(s.charAt(i))){
                curr = curr.children.get(s.charAt(i));
            }
            else {
                // it means prefix itself does not exisit
                return results;
            }
        }
        // in the end you need to gather all words starting from this curr .. since curr now becomes new tree and scan
        // whole tree
        getAllWords(curr,results);
        return results;
    }
    // try all possible paths in getAllWords();
    void getAllWords(TrieNode curr,List<String> results){
        if (curr.isWord == true){
            // if isword is true
            results.add(curr.prefix);
            return;
        }
        for(TrieNode childrens:curr.children.values()){
            getAllWords(childrens,results);
        }
    }

    public static void main(String[] args) {
        AutoComplete autoComplete = new AutoComplete();
        autoComplete.insertWord("abc");
        autoComplete.insertWord("acd");
        autoComplete.insertWord("bcd");
        autoComplete.insertShort("def");
        autoComplete.insertShort("a");
        autoComplete.insertWord("aba");
        System.out.println(autoComplete.getAllWordsForPrefix("ab"));
        System.out.println(autoComplete.search("ab"));
    }

}
// make sure you leep prefix else you will have to use backtracking kind of algorithms to generate all patsh
// if prefix storeed you are sure to reach end andd get that prefix
// hashMp<character,TrenOde> childeren
// isword reqyured
class TrieNode {
    String prefix;
    boolean isWord;
    // worst case we will have chars map of all 26 characters in my hashMap
    // that would solve this problem !!!
    HashMap<Character, TrieNode> children;
    TrieNode(String prefix){
        // very imp we are passing predix in the constructor so that every node has prefix with it
        // make it manadator to create prefix before even you create node !!! looks cleaner approach
        // make prefix manadaraoty in trie node while creating trienode
        children = new HashMap<>();
        this.prefix = prefix;
    }
}