package SystemDesignCodes;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 7/10/17.
 */
public class SerializeTrieTree {
    private class TrieNode {
      public NavigableMap<Character, TrieNode> children;
      public TrieNode() {
          children = new TreeMap<Character, TrieNode>();
      }
  }
  public String Serialize(TrieNode node){
        if(node == null){
            return "";
        }
        String s="";
        for(Map.Entry<Character,TrieNode> entry:node.children.entrySet()){
            s = "+"+entry.getKey();
            s = s+ Serialize(entry.getValue());
            s =s +"-";
        }
        return s;
  }
  TrieNode deserialize(TrieNode current,String s, AtomicInteger a){
      if(a.get() == s.length()){
          return null;
      }
      if(s.charAt(a.get()) =='+'){
          current = new TrieNode();
          a.incrementAndGet();
          while (a.get()<s.length()) {
              Character character = s.charAt(a.get());
              a.incrementAndGet();
              current.children.put(character, deserialize(current.children.get(character), s, a));
          }
      }
      else if(s.charAt(a.get()) =='-'){
          a.incrementAndGet();
          return current;
      }
      else {
          return null;
      }
      return current;
  }

  //Stack Version

    public TrieNode deserilaize(String s ){
      int index = 0;
        Stack<TrieNode>stack = new Stack<>();
        TrieNode root = new TrieNode();
        stack.push(root);
        while (index<s.length()){

            if(s.charAt(index) == '+'){
                char c = s.charAt(++index);
                TrieNode node = new TrieNode();
                stack.peek().children.put(c,node);
                // very imp step as think through keep pusing and updaing children
                // post that
                // very nice logic shud be done non recursively
                // clear and simple
                stack.push(node);
            }
            else {
                index++;
                stack.pop();
            }
        }
        return root;
    }
}
