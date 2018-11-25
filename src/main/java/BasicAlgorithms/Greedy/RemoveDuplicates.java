package BasicAlgorithms.Greedy;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class RemoveDuplicates {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),1);
            }
            else {
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }
        }
        int end =0;
        List<Character> list = new LinkedList<>();
        while (end<s.length()){
            char c= s.charAt(end);
            int freq = hashMap.get(s.charAt(end));
            freq = freq -1;
            if(freq == 0){
                hashMap.remove(s.charAt(end));
            }
            hashMap.put(s.charAt(end),freq);
            end++;
            if(list.contains(c))continue;

            while (!list.isEmpty() && c<list.get(list.size()-1) && hashMap.get(list.get(list.size()-1))>0){
                list.remove(list.size()-1);
            }
            list.add(c);
        }
        String ans = "";
        for(Character c:list) {
            ans = ans + c;
        }
        return ans;
    }
    public String removeDuplicateLettersMineAccepted(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),1);
            }
            else {
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }
        }
        int end =0;
        Stack<Character> stack = new Stack<>();
        while (end<s.length()){
            char c= s.charAt(end);
            int freq = hashMap.get(s.charAt(end));
            freq = freq -1;
            if(freq == 0){
                hashMap.remove(s.charAt(end));
            }
            // once you are travelling forward keep track of  how manyt chars left in your kitty !!
            // based on this cout yuou will decide whether to rmeove it ot not @!!!
            hashMap.put(s.charAt(end),freq);
            end++;
            // if stack already contains this particulat char better dont consider it
            if(stack.contains(c))continue;
            while (!stack.isEmpty() && c< stack.peek()&& hashMap.get(stack.peek())>0){
                stack.pop();
            }
            stack.add(c);
        }
        String ans = "";
        while (!stack.isEmpty()){
            ans = stack.pop() +ans;
        }
        return ans;
    }
}

