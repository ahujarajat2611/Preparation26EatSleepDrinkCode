package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hadoop on 19/9/17.
 */
public class AutoComplete {
    private class TrieNode {
        String prefix;
        boolean isWord;
        HashMap<Character, TrieNode> hashMap;
        TrieNode(String prefix){
            hashMap = new HashMap<>();
            this.prefix = prefix;
        }
    }
    private TrieNode trieNode;
    public AutoComplete(){
        trieNode = new TrieNode("");
    }

    public void insertWord(String word){
        TrieNode current = trieNode;
        for(int i=0;i<word.length();i++){
            TrieNode children =current.hashMap.get(word.charAt(i));
            if(children == null){
                children = new TrieNode(word.substring(0,i+1));
                current.hashMap.put(word.charAt(i),children);
            }
            current = children;
            if(i == word.length()-1){
                children.isWord = true;
            }
        }
    }
    public void insertShort(String s){
        TrieNode curr = trieNode;
        for(int i=0;i<s.length();i++){
            if(!curr.hashMap.containsKey(s.charAt(i))){
                curr.hashMap.put(s.charAt(i),new TrieNode(s.substring(0,i+1)));
            }
            curr = curr.hashMap.get(s.charAt(i));
            if(i == s.length()-1){
                curr.isWord = true;
            }
        }
    }
    public boolean search(String s){
        if(s == null || s.length() ==0){
            return false;
        }
        TrieNode curr = trieNode;
        for(int i=0;i<s.length();i++){
            if(!curr.hashMap.containsKey(s.charAt(i))){
                return false;
            }
            curr = curr.hashMap.get(s.charAt(i));
            if(curr == null){
                return false;
            }
        }
        return curr.isWord;
    }
    public List<String> getAllWordsForPrefix(String s){
        List<String> results = new ArrayList<>();
        TrieNode curr = trieNode;
        for( int i=0;i<s.length();i++){
            if(curr.hashMap.containsKey(s.charAt(i))){
                curr = curr.hashMap.get(s.charAt(i));
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
        for(TrieNode childrens:curr.hashMap.values()){
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