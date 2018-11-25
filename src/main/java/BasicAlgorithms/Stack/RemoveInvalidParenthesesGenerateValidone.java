package BasicAlgorithms.Stack;

import java.util.*;

/**
 * Created by hadoop on 19/10/17.
 */
/*
"()())()" -> ["()()()", "(())()"]
				"(a)())()" -> ["(a)()()", "(a())()"]
				")(" -> [""]
 */


// very nice multiple are possibel hence apply bfs to get
    // shortest all possible paths ..
    // rememver bfs template /// very nice problem it is ..

public class RemoveInvalidParenthesesGenerateValidone {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        if(s == null || s.length() == 0){
            return list;
        }
        Set<String> visited = new HashSet<>();
        String source = s;
        int infinity = Integer.MAX_VALUE;
        HashMap<String,Integer> distance = new HashMap<>();
        HashMap<String,String> path = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        distance.put(s,0);
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()){
            String polled = queue.poll();
            System.out.println("polled "+polled);
            // check if state has been achiveed
            if(isValid(polled)){
                list.add(polled);
                // instead of iterating get all shortest paths and qui
                // done enter loop and look for states
                found = true;
            }
            if(found){
                // if we found then rather than pushing more items i would like to pop in the queue at the level
                // so that i can get all possiblibe longeest lenegh valid strinngs
                continue;
            }
            // we cant look for validity since here
            /// we might validity after romaval of several characnerts
            // bit different  but inytereting
            List<String> states = getAllStates(polled);
            System.out.println("all satteds "+states );
            for(String neightbour:states){
                if(!visited.contains(neightbour)) {
                    visited.add(neightbour);
                    distance.put(neightbour,distance.get(polled)+1);
                    path.put(neightbour,polled);
                    queue.add(neightbour);
                }
            }
        }
        return list;
    }

    private List<String> getAllStates(String polled) {
        List<String> states = new LinkedList<>();
        for(int i=0;i<polled.length();i++){
            if(polled.charAt(i)=='(' || polled.charAt(i)==')') {
                states.add(polled.substring(0, i) + polled.substring(i + 1));
            }
        }
        return states;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
//        if(s.length() == 1){
//            return false;
//        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty() && matching(stack.peek(), c)) {
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else {

            }
        }
        return stack.isEmpty();
    }

    private boolean matching(Character peek, char c) {
        if (peek == '(' && c == ')') {
            return true;
        }
        if (peek == '[' && c == ']') {
            return true;
        }
        if (peek == '{' && c == '}') {
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        RemoveInvalidParenthesesGenerateValidone r = new RemoveInvalidParenthesesGenerateValidone();
        System.out.println(r.removeInvalidParentheses("()())()"));

    }
}