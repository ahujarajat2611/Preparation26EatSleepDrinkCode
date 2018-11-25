package BasicAlgorithms.BfsDfs;
import java.util.*;

/**
 * Created by hadoop on 21/10/17.
 */
public class RemoveInvalidPrenthsis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        // Some times u need to create state on the fly
        // here is one of the example//
        // u just cant make state beforehand to process
        // word ladder problem was one of the xample
        // Make state on the fly ............
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);
        HashMap<String,Integer> distance = new HashMap<>();
        distance.put(s,0);
        int mindis = Integer.MAX_VALUE;
        List<String> ans = new LinkedList<>();
        while (!queue.isEmpty()){
            String polled = queue.poll();
            int dist = distance.get(polled);
            if(isValid(polled)){
                mindis = dist;
                ans.add(polled);
            }
            List<String> states = getStates(polled);
            for(String v:states){
                if(!visited.contains(v) && dist+1 <mindis){
                    visited.add(v);
                    queue.add(v);
                    distance.put(v,dist+1);
                }
            }
        }
        return ans;
    }

    private boolean isValid(String polled) {
        Stack<Character> stack= new Stack<>();
        for(char c:polled.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                if (stack.peek() == '('){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.size()==0;
    }

    private List<String> getStates(String polled) {
        List<String> states = new ArrayList<>();

        for(int i=1;i<polled.length();i++){
            if(!(polled.charAt(i) !='(' && polled.charAt(i) != ')')){
                states.add(polled.substring(0,i) +polled.substring(i+1));
            }
        }
        return states;
    }

    public static void main(String[] args) {
        RemoveInvalidPrenthsis removeInvalidPrenthsis = new RemoveInvalidPrenthsis();
        System.out.println(removeInvalidPrenthsis.removeInvalidParentheses("()())()"));
    }
}