package SystemDesignCodes;

import java.util.*;

/**
 * Created by hadoop on 7/10/17.
 */
public class Typeahead {
    Set<String> dict ;
    private class TreeNode{
        Set<String> tops;
        Map<Character,TreeNode> neighbors;
        TreeNode(){
            tops = new HashSet<>();
            neighbors = new HashMap<>();
        }
    }
    Typeahead(Set<String> dict){
        this.dict = dict;
    }
    TreeNode root;
    List<String> search(String str){
        TreeNode current = root;
        for(char c:str.toCharArray()){
            current = current.neighbors.get(c);
            if(current == null){
                return new ArrayList<>();
            }
        }
        return new ArrayList<>(current.tops);
    }

    TreeNode buildTreeFromDict(Set<String> dict){
        TreeNode current = new TreeNode();
        for(String word :dict){
            for(int i=0;i<word.length();i++) {
                String subWord = word.substring(i);
                for (char c : subWord.toCharArray()) {
                    if (!current.neighbors.containsKey(c)) {
                        TreeNode node = new TreeNode();
                        current.neighbors.put(c, node);
                    }
                    current.tops.add(subWord);
                    current = current.neighbors.get(c);
                }
            }
        }
        return current;
    }

}
