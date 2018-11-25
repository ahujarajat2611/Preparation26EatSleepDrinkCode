package BasicAlgorithms.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
public class SimplfyPath {
    public String simplifyPath(String path) {
        String array[] = path.split("/");

        Deque<String> deque = new LinkedList<>();
        for(int i=0;i<array.length;i++){
           // System.out.println(array[i]);
            if(array[i].equals(".") || array[i].equals("")){
                continue;
            }
            else if(array[i].equals("..")){
                if(!deque.isEmpty()){
                    deque.pop();
                }
                continue;
            }
            else{
                deque.push(array[i]);

            }
        }
        String ans = "";
        if(deque.isEmpty()){
            return "/";
        }
        while (!deque.isEmpty()){
            ans = ans + "/"+deque.pollLast();
        }
        return ans;
    }

    public static void main(String[] args) {
        SimplfyPath simplfyPath = new SimplfyPath();
        System.out.println(simplfyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplfyPath.simplifyPath("/home/"));
    }
}