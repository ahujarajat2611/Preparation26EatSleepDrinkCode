package zrzahid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 10/9/17.
 */
// trie node has two imp things
    // one is prefix till that point
    // second is isword boolean thing
public class AutoComplete {
    private class Node{
        String prefix;
        HashMap<Character,Node> children;
        boolean isWord;
        private Node(String prefix){
            this.prefix = prefix;
            this.children = new HashMap<>();
        }

    }
    private Node trie;
    public AutoComplete(String [] dict){
        trie = new Node("");
        for(String s :dict){
            insertWord(s);
        }
    }

    // it has to  be non recursive sicne it easy to deal with
    // in non-recursive way
    // see how are we adding prefix using substing method
    private void insertWord(String s) {
        Node curr= trie;
        for(int i=0;i<s.length();i++){
            if(!curr.children.containsKey(s.charAt(i))){
                curr.children.put(s.charAt(i),new Node(s.substring(0,i+1)));
            }
            curr = curr.children.get(s.charAt(i));
            if(i == s.length()-1){
                curr.isWord = true;
            }
        }
    }

    public List<String> getWordsForPrefixString(String pre){
           List<String> results = new LinkedList<>();
           Node curr = trie;
           for(int i=0;i<pre.length();i++){
               if(curr.children.containsKey(pre.charAt(i))){
                   curr= curr.children.get(pre.charAt(i));
               }
               else {
                   return results;
               }
           }
           findAllWords(curr,results);
            return results;
    }

    // proper DFS to get all the words
    private void findAllWords(Node curr, List<String> results) {
         if(curr.isWord){
             results.add(curr.prefix);
             return;
         }
         else {
             for(Node child:curr.children.values()){
                 findAllWords(child,results);
             }
         }
    }
    public static void main(String args[]){
        String [] array = new String[6];
        array[0] = "abc";
        array[1] = "acd";
        array[2] = "bcd";
        array[3] = "def";
        array[4] = "a";
        array[5] = "aba";
        AutoComplete autoComplete = new AutoComplete(array);
        System.out.println(autoComplete.getWordsForPrefixString("ab"));
    }

}
