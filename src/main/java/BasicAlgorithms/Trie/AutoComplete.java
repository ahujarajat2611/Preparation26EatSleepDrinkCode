package BasicAlgorithms.Trie;

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
            if(!curr.children.containsKey(s.charAt(i))){
                curr.children.put(s.charAt(i),new TrieNode(s.substring(0,i+1)));
            }
            curr = curr.children.get(s.charAt(i));
            if(i == s.length()-1){
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
                return results;
            }
        }
        getAllWords(curr,results);
        return results;
    }
    void getAllWords(TrieNode curr,List<String> results){
        if (curr.isWord == true){
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
class TrieNode {
    String prefix;
    boolean isWord;
    HashMap<Character, TrieNode> children;
    TrieNode(String prefix){
        children = new HashMap<>();
        this.prefix = prefix;
    }
}