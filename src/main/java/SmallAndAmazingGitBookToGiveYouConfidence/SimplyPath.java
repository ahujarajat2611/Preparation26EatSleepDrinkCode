package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by hadoop on 22/9/17.
 */
public class SimplyPath {
    public String simplyPath(String a){
        Deque<String> deque = new LinkedList<>();
        String []tokens = a.split("/");
        for(String token:tokens){
            if(token.equals("..")){
                deque.removeLast();
            }
            // if valid token add it to queue
            else if(!token.equals(".") && !token.equals("")){
                deque.addLast(token);
            }
        }
//        Deque<String> mydeque = new LinkedList<>();
//        mydeque.peekLast();
//        mydeque.peekFirst();

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(deque.removeFirst());
        }
        return stringBuilder.length()>0?stringBuilder.toString():stringBuilder.append("/").toString();
    }
}
